package com.generate.api.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generate.api.security.model.UserEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long>{

	Optional<UserEntity> findByUsername(String username);
}
