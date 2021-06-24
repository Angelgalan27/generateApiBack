package com.generate.api.security.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.generate.api.security.utils.UserRole;


@Entity
@Table(name="user_entity") 
@EntityListeners(AuditingEntityListener.class)
public class UserEntity implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7063590493777815462L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String username;
	
	@Column(unique = true)
	private String email;

	@Column
	private String name;
	
	@Column
	private String surname;
	

	@Column
	private String password;
	
	@Column
	private String avatar;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	private Set<UserRole> roles;
	
	@JsonIgnore
	@CreatedDate
	private LocalDateTime createDate;
	
	@JsonIgnore
	private LocalDateTime lastPasswordChange = LocalDateTime.now();
	
	

	public UserEntity() {
		super();
	}
	
	public UserEntity(Long id, String username, String avatar, Set<UserRole> roles, String name, String surname) {
		super();
		this.id = id;
		this.username = username;
		this.avatar = avatar;
		this.roles = roles;
		this.name = name;
		this.surname = surname;
	}

	
	public UserEntity(Long id, String username, String email, String name, String surname, String password,
			String avatar, Set<UserRole> roles, LocalDateTime createDate, LocalDateTime lastPasswordChange) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.avatar = avatar;
		this.roles = roles;
		this.createDate = createDate;
		this.lastPasswordChange = lastPasswordChange;
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
			return roles
					.stream()
					.map(role -> new SimpleGrantedAuthority("ROLE_"+role.name()))
					.collect(Collectors.toList());
	}


	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}


	@Override
	public String getPassword() {
		return this.password;
	}


	@Override
	public String getUsername() {
		return this.username;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAvatar() {
		return avatar;
	}


	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	public Set<UserRole> getRoles() {
		return roles;
	}


	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}


	public LocalDateTime getCreateDate() {
		return createDate;
	}


	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}


	public LocalDateTime getLastPasswordChange() {
		return lastPasswordChange;
	}


	public void setLastPasswordChange(LocalDateTime lastPasswordChange) {
		this.lastPasswordChange = lastPasswordChange;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
}
