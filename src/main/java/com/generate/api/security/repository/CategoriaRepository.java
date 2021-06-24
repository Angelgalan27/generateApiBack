package com.generate.api.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generate.api.security.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>  {

}
