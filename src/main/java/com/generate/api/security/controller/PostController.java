package com.generate.api.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.generate.api.bean.PostPagination;
import com.generate.api.security.model.Post;
import com.generate.api.security.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService postService;
	
	
	@RequestMapping(method = RequestMethod.GET,produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public List<Post> getAll(@RequestParam(name = "from", required = false) Long from, @RequestParam(name = "until", required = false) Long until ){
		 return postService.findAll();
	}
	
	@PostMapping("/findallpagination")
	@ResponseBody
	public PostPagination getAllPagination(@RequestParam(name = "from", required = false) Long from, @RequestParam(name = "until", required = false) Long until ){
		PostPagination postPagination = new PostPagination();  
		postPagination.setPosts(postService.findAll(from, until));
		postPagination.setTotalPost(postService.getTotalPost());
		return postPagination;
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Post get(@PathVariable Long id) {
		return postService.findById(id).get();
	}
	
	@RequestMapping(method = RequestMethod.POST ,produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public Post save(@RequestBody Post post) {
		return postService.save(post);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public Post update(@RequestBody Post post) {
		return postService.save(post);
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable Long id) {
		postService.deleteById(id);
	}
}
