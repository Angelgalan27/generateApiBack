package com.generate.api.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generate.api.security.model.UserEntity;
import com.generate.api.security.serviceImpl.UserEntityService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserEntityService userEntityService;
	
	@RequestMapping(value = "/new", method = RequestMethod.POST,produces={"application/json; charset=UTF-8"})
	public ResponseEntity<UserEntity> newUser (@RequestBody UserEntity user) {
		try {
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(userEntityService.newUser(user));
		} catch (DataIntegrityViolationException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT,produces={"application/json; charset=UTF-8"})
	public UserEntity update(@RequestBody UserEntity user) {
		return userEntityService.save(user);
	}

	@GetMapping("/me")
	public UserEntity me(@AuthenticationPrincipal UserEntity user) {
		return user;
	}
}
