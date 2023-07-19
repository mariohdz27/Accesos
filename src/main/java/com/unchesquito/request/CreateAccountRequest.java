package com.unchesquito.request;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class CreateAccountRequest {
	
	
	@NotNull(message = " El campo birthdate es obligatorio")
	@NotEmpty(message = "El campo birthdate no puede estar vacío")
	@Size(min =10 , max = 10 , message = "La longitud del campo birthdate debe tener 10 caracteres")
	private String birthdate;

	@NotNull(message = "El campo email es obligatorio")
	@Email(message = "El email no tiene el formato esperado")
	@NotEmpty(message = "El campo email no puede estar vacío")
	@Size(max = 100 , message = "La longitud del campo email puede tener un máximo de 100 caracteres" )
	private String email;
	
	@NotNull(message = "El campo idAvatar es obligatorio")
	@NotEmpty(message = "El campo idAvatar no puede estar vacío")
	@Size(max = 1 , message = "La longitud del campo idAvatar puede tener un máximo de 1 carácter" )
	private String idAvatar;
	
	@NotNull(message = "El campo lastName es obligatorio")
	@NotEmpty(message = "El campo lastName no puede estar vacío")
	@Size(max = 50 , message = "La longitud del campo lastName puede tener un máximo de 50 caracteres" )
	private String lastName;
	
	@NotNull(message = "El campo name es obligatorio")
	@NotEmpty(message = "El campo name no puede estar vacío")
	@Size(max = 50 , message = "La longitud del campo name puede tener un máximo de  50 caracteres" )
	private String name;
	
	@NotNull(message = "El campo password es obligatorio")
	@NotEmpty(message = "El campo password no puede estar vacío")
	@Size(max = 50 , min = 8, message = "La longitud del campo password puede tener un máximo de  50 caracteres" )
	private String password;
	
		
	@NotNull(message = "El campo telephone es obligatorio")
	@NotEmpty(message = "El campo telephone no puede estar vacío")
	@Size(max = 10 , min = 10, message = "La longitud del campo telephone puede tener 10 números" )
	private String telephone;

	@NotNull(message = "El campo user es obligatorio")
	@NotEmpty(message = "El campo user no puede estar vacío")
	@Size(max = 30 , message = "La longitud del campo user puede tener un máximo de 300 caracteres" )
	private String user;
	

	


	
	
	
	
}
