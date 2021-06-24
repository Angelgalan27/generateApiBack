package com.generate.api.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.generate.api.security.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

	@Query( value = "SELECT * FROM evento ORDER BY id ASC LIMIT ?1 OFFSET ?2", nativeQuery = true)
	public List<Evento> findAll(int limit, int until );
	
	@Query( value = "SELECT * FROM evento ORDER BY id ASC", nativeQuery = true)
	public List<Evento> findAll();
	
	@Query(value = "SELECT count(*) from evento", nativeQuery = true)
	public Long getTotalPost();
}
