package com.generate.api.security.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.generate.api.security.model.Post;
import com.generate.api.security.repository.PostRepository;
import com.generate.api.security.service.PostService;

@Service
public class PostServiceImpl
		extends BaseServiceImpl<Post, Long, PostRepository>
			implements PostService{
	
	@Override
	public Post save(Post post) {
		post.setFecha(new Date());
		return repositorio.save(post);
	}

	@Override
	public List<Post> findAll(Long from, Long until) {
		return repositorio.findAll(Integer.valueOf(from.toString()), Integer.valueOf(until.toString()));
	}

	@Override
	public Long getTotalPost() {
		return repositorio.getTotalPost();
	}

}
