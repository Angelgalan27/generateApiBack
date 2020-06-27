package com.generate.api.security.serviceImpl;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.generate.api.security.model.UserEntity;
import com.generate.api.security.repository.UserEntityRepository;
import com.generate.api.security.utils.UserRole;

@Service
public class UserEntityService extends BaseServiceImpl<UserEntity, Long, UserEntityRepository>{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public Optional<UserEntity> findUserByUsername(String username){
		return repositorio.findByUsername(username);
	}
	
	public UserEntity newUser(UserEntity user) {
	    user.setPassword(passwordEncoder.encode(user.getPassword()));
	    user.setRoles(Stream.of(UserRole.USER).collect(Collectors.toSet()));
	    return repositorio.save(user);
	}
	
}
