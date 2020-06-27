package com.generate.api.security.jwt.model;

import java.util.Set;

import com.generate.api.security.model.UserEntity;
import com.generate.api.security.utils.UserRole;




public class JwtUserResponse extends UserEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -850760588856884201L;
	private String token;

	
	
	public JwtUserResponse() {
	}
	

	public JwtUserResponse( String token, Long id, String username, String avatar, Set<UserRole> roles, String name, String surname) {
		super(id, username, avatar, roles, name, surname);
		this.token = token;
	}


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
