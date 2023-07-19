package com.unchesquito.services;


import java.util.List;

import com.unchesquito.request.CreateAccountRequest;
import com.unchesquito.response.LoginResponse;
import com.unchesquito.response.TeamsResponse;


public interface LoginService {

		public LoginResponse login(String usuario, String password);
		
		public LoginResponse createAccount(CreateAccountRequest request) ;
		
		public List<TeamsResponse > getTeams ();


}
