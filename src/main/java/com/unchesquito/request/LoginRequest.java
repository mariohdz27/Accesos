package com.unchesquito.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class LoginRequest {

	@NotNull(message = "El campo usuario es obligatorio")
	@NotBlank(message = "El campo usuario es obligatorio")
	private String user;

	@NotNull(message = "El campo password es obligatorio")
	@NotBlank(message = "El campo password es obligatorio")
	private String password;
	
}
