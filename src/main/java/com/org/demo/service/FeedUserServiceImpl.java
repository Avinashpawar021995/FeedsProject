package com.org.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.demo.enitity.User;
import com.org.demo.repository.UserRepository;
@Service
public class FeedUserServiceImpl implements FeedUserService{
    @Autowired
	UserRepository userRepository;
	
	@Override
	public ResponseEntity<User> create(User user) 
	{      String id=UUID.randomUUID().toString();
	             user.setId(id);
		User user1=userRepository.save(user);
	  return new ResponseEntity<>(user1, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<User> login(User user) {
	     String email=user.getEmail();
	     String password=user.getPassword();
		 User user1=userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("user is not  able"));
		 if(user1.getPassword().equals(user.getPassword()))
		 {
				return new ResponseEntity<User>(user1, HttpStatus.OK);		 
		 }
		 else
		 {
				return new ResponseEntity<User>( HttpStatus.NOT_FOUND);		
		 }
	}
	

	@Override
	public ResponseEntity<List<User>> fetchUser() {
		 List<User> users= userRepository.findAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	
}
