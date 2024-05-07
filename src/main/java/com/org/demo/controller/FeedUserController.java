package com.org.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.demo.enitity.User;
import com.org.demo.service.FeedUserService;
@CrossOrigin("*")
@RestController
@RequestMapping("/app")
public class FeedUserController {
 @Autowired
 private FeedUserService feedUserService;	
	  @PostMapping("/reg") 
	  public ResponseEntity<User> create(@RequestBody User user) 
	  {
		  return feedUserService.create(user);
	  }
	  
	  @PostMapping("/login")
	  public ResponseEntity<User> login(@RequestBody User user) {
	  return feedUserService.login(user);
	  }
}
