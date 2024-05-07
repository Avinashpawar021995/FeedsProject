package com.org.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.org.demo.enitity.User;

public interface FeedUserService {

	ResponseEntity<User> create(User user);

	ResponseEntity<User> login(User user);

	ResponseEntity<List<User>> fetchUser();


}
