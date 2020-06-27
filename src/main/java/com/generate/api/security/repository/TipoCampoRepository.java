package com.generate.api.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generate.api.security.model.TipoCampo;

public interface TipoCampoRepository extends JpaRepository<TipoCampo, Long> {

}
