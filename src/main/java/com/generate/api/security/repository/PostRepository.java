package com.generate.api.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.generate.api.security.model.Post;


public interface PostRepository extends JpaRepository<Post, Long>  {

	@Query( value = "SELECT * FROM post ORDER BY id ASC LIMIT ?1 OFFSET ?2", nativeQuery = true)
	public List<Post> findAll(int limit, int until );
	
	@Query( value = "SELECT * FROM post ORDER BY id ASC", nativeQuery = true)
	public List<Post> findAll();
	
	@Query(value = "SELECT count(*) from post", nativeQuery = true)
	public Long getTotalPost();
}
