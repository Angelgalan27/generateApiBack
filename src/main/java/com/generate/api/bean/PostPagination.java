package com.generate.api.bean;

import java.util.List;

import com.generate.api.security.model.Post;

public class PostPagination {

	private List<Post> posts;
	
	private Long totalPost;

	public List<Post> getPost() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Long getTotalPosts() {
		return totalPost;
	}

	public void setTotalPost(Long totalPost) {
		this.totalPost = totalPost;
	}
	
	
	
	
}
