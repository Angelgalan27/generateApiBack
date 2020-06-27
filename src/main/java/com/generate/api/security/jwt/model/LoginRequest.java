package com.generate.api.security.jwt.model;

public class LoginRequest {

	private String username;
	private String password;

	
	public LoginRequest() {
	}

	public LoginRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}


	
	
}
