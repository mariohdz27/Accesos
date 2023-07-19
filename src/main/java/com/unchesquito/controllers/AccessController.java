package com.unchesquito.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unchesquito.controllers.exceptions.http.BadRequestException;
import com.unchesquito.request.CreateAccountRequest;
import com.unchesquito.request.LoginRequest;
import com.unchesquito.response.LoginResponse;
import com.unchesquito.response.TeamsResponse;
import com.unchesquito.services.LoginService;
import com.unchesquito.utilidades.Utilidades;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@CrossOrigin(origins = "*")
public class AccessController {
	
	@Autowired
	private Utilidades utilidades;
	
	@Autowired
	@Qualifier("LoginServiceImpl")
	private LoginService loginService;
	
	
	
	@PostMapping("/login")
	public LoginResponse login(@RequestBody @Valid LoginRequest login, BindingResult bindingResult ) {
		log.info("Ejecutando metodo login");
		log.debug("Datos: " + login);
		
		if (bindingResult.hasErrors()) {
			List<String> mensajeError = utilidades.getErrors(bindingResult);
			
			throw new BadRequestException("klñklñ",mensajeError);
		}
		
		return this.loginService.login(login.getUser(), login.getPassword());
	}
	
	
	@PostMapping("/create-account")
	public LoginResponse createAccount( @RequestBody @Valid CreateAccountRequest request, BindingResult bindingResult)  {
		
		log.info("Ejecutando metodo createAccount");
		log.debug("Datos: "+ request);
		
		if (bindingResult.hasErrors()) {
			List<String> errors = utilidades.getErrors(bindingResult);
			log.warn("Ocurrieron los siguientes errores en la peticion: " + errors);
			throw new BadRequestException("Los datos no cumplen con las reglas", errors);
		}
		return this.loginService.createAccount(request);
		
	}
	
	@GetMapping("/get-teams")
	public List<TeamsResponse>  getTeams() {

		return this.loginService.getTeams();
	}

}
