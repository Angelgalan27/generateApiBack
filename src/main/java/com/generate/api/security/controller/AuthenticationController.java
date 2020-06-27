package com.generate.api.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generate.api.security.jwt.JwtProvider;
import com.generate.api.security.jwt.model.JwtUserResponse;
import com.generate.api.security.jwt.model.LoginRequest;
import com.generate.api.security.model.Login;
import com.generate.api.security.model.UserEntity;



@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtProvider jwtProvider;
	

	@PostMapping("/auth/login")
	public ResponseEntity<JwtUserResponse> login(@RequestBody Login login) {
		LoginRequest loginRequest = new LoginRequest(login.getEmail(), login.getPassword());
		Authentication auth =
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
						loginRequest.getUsername(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		UserEntity user = (UserEntity) auth.getPrincipal();
		String token = jwtProvider.generateToken(auth);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(convertUserEntityAndTokenToJwtEntityResponse(user, token));
	}


	private JwtUserResponse convertUserEntityAndTokenToJwtEntityResponse(UserEntity user, String token) {
		return new JwtUserResponse(
				 token
				,user.getId()
				,user.getUsername()
				,user.getAvatar()
				,user.getRoles()
				,user.getName()
				,user.getSurname());
	}


	
}


