package com.org.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.org.demo.enitity.PostEntity;
import com.org.demo.service.FeedPostService;
@CrossOrigin("*")
@RestController
@RequestMapping("/post")
public class FeedPostController {

	@Autowired
	private FeedPostService feedPostService;
	
	@PostMapping("/{id}")
	public  ResponseEntity<PostEntity> createPost(@RequestBody PostEntity entity, @PathVariable String id)
	{	
		return feedPostService.creatPost(entity,id);
	}
	
	@GetMapping
	public  ResponseEntity<List<PostEntity>> getAllPost()
	{
		return feedPostService.getAllPost();
	}
	
	@GetMapping("/{post_id}")
	public  ResponseEntity<PostEntity> getByUserId(@PathVariable String post_id)
	{
		return feedPostService.getByUSerId(post_id);
	}
	
	@PutMapping("/up/{id}")
	public ResponseEntity<PostEntity> updateByPostUsingID(@RequestBody PostEntity postEntity, @PathVariable String id )
	{
		return feedPostService.updateByPostUsingID(postEntity, id);
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<HttpStatus> deletedPostUsingId(@PathVariable String id)
	{
		return feedPostService.deletedPostUsingID(id);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<List<PostEntity>> getUserIdPostAccess(@PathVariable String id)
	{
		return feedPostService.getUserIdPostAccess(id);
	}
	
	  @GetMapping("/user/{id}/status/{success}")
	  public
	  ResponseEntity<PostEntity> getUserIdPostAccessRole(@PathVariable Boolean success, @PathVariable String id) { 
		  return feedPostService.getUserIdPostAccessRole(success,id); }
	 
}
