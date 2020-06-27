package com.generate.api.security.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.generate.api.security.model.UserEntity;

@Service("userDetailsService")
public class CustomUserDeatilsService implements UserDetailsService {

	
	@Autowired
	private UserEntityService userEntityService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userEntityService.findUserByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(username + " no existe"));
	}
	
	public UserEntity loadUserById(Long id) throws UsernameNotFoundException {
		return userEntityService.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario con id " + id + "no existe"));
	}

}
