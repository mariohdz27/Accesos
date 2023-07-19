package com.unchesquito.response;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class LoginResponse {

	
	private int idUsuario;

	private String user;

	
}
