package com.unchesquito.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.unchesquito.controllers.exceptions.http.BadRequestException;
import com.unchesquito.controllers.exceptions.http.InternalServerException;
import com.unchesquito.controllers.exceptions.http.NotFoundException;
import com.unchesquito.entities.EstatusEntity;
import com.unchesquito.entities.TeamsEntity;
import com.unchesquito.entities.UserEntity;
import com.unchesquito.repository.TeamsRepository;
import com.unchesquito.repository.UserRepository;
import com.unchesquito.request.CreateAccountRequest;
import com.unchesquito.response.LoginResponse;
import com.unchesquito.response.TeamsResponse;
import com.unchesquito.services.LoginService;
import com.unchesquito.utilidades.Encryption;
import com.unchesquito.utilidades.Utilidades;

@Service("LoginServiceImpl")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TeamsRepository teamsRepository;

	@Autowired
	private Encryption encryption;

	@Autowired
	private Utilidades utilidades;

	@Value(value = "${supportMail}")
	private String supportMail;

	@Value("${AESFront}")
	private String aesFront;

	@Value("${AESEncryptBack}")
	private String aesEncryptBack;

	@Override
	public LoginResponse login(String user, String password) {

		UserEntity userCreated;

		try {
			String decryptPass = encryption.decryptAES(password, aesFront, aesFront);

			userCreated = this.userRepository.login(user,
					encryption.encryptionAES(decryptPass, aesEncryptBack, aesEncryptBack));

			if (userCreated == null) {
				throw new NotFoundException("Error al buscar el usuario");
			}

			return LoginResponse.builder().idUsuario(userCreated.getIdUser()).build();
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}

	}

	@Override
	public LoginResponse createAccount(CreateAccountRequest request) {

		EstatusEntity estatus = new EstatusEntity();
		estatus.setIdEstatus(1);

		TeamsEntity teams = new TeamsEntity();
		teams.setIdEstatus(estatus);
		teams.setIdTeam(Integer.parseInt(request.getIdAvatar()));

		UserEntity user = null;
		UserEntity userEntity = this.userRepository.findAccount(request.getUser(), request.getEmail(),
				request.getTelephone());

		String decryptPass;
		try {
			decryptPass = encryption.decryptAES(request.getPassword(), aesFront, aesFront);

			if (userEntity != null) {
				throw new BadRequestException(
						"No fue posible crear la cuenta, favor de revisar los datos introducidos. Si continuas teniendo problemas comunicate con nosotros al siguiente correo: "
								.concat(supportMail));
			}

			UserEntity usuarioEntity = UserEntity.builder().user(request.getUser()).name(request.getName())
					.email(request.getEmail()).telephone(request.getTelephone())
					.password(encryption.encryptionAES(decryptPass, aesEncryptBack, aesEncryptBack))
					.name(request.getName()).lastName(request.getLastName())
					.birthdate(utilidades.stringToDate(request.getBirthdate())).registrationDate(new Date())
					.idEstatus(estatus).idAvatar(teams).build();
			user = this.userRepository.save(usuarioEntity);

		} catch (Exception e) {
			throw new InternalServerException(e);
		}

		return LoginResponse.builder().idUsuario(user.getIdUser()).user(user.getUser()).build();
	}

	@Override
	public List<TeamsResponse> getTeams() {

		EstatusEntity estatus = new EstatusEntity();
		estatus.setIdEstatus(1);
		List<TeamsEntity> teams = teamsRepository.findByIdEstatus(estatus);
		List<TeamsResponse> teamsResponse = new ArrayList<>();

		for (TeamsEntity teamsEntity : teams) {

			TeamsResponse response = TeamsResponse.builder().id(teamsEntity.getIdTeam())
					.team_name(teamsEntity.getTeamName()).image(new String(teamsEntity.getImage())).build();
			teamsResponse.add(response);

		}
		return teamsResponse;
	}
}