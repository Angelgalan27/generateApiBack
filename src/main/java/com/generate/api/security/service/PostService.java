package com.generate.api.security.service;

import java.util.List;
import java.util.Optional;

import com.generate.api.security.model.Post;

public interface PostService {

	
	public Post save(Post t);
	
	public Optional<Post> findById(Long id);
	
	public List<Post> findAll();
	
	public List<Post> findAll(Long from, Long until);
	
	public Post edit(Post t);
	
	public void delete(Post t);
	
	public void deleteById(Long id);
	
	public Long getTotalPost();
}
