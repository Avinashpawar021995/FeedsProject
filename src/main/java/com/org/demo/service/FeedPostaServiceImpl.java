package com.org.demo.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.org.demo.enitity.PostEntity;
import com.org.demo.enitity.User;
import com.org.demo.repository.PostRepository;
import com.org.demo.repository.UserRepository;
@Service
public class FeedPostaServiceImpl implements FeedPostService{
   @Autowired    
	private  PostRepository postRepository;
   @Autowired
    private UserRepository userRepository;
	@Override
	public ResponseEntity<PostEntity> creatPost(PostEntity entity, String id) {
	  // LocalDateTime parsedDate = LocalDateTime.parse(entity.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		User user=userRepository.findById(id).orElseThrow(()-> new RuntimeException("user id is not found"));
	     	   String postId=UUID.randomUUID().toString();
		        entity.setPost_id(postId);
                entity.setDate(new Date());
                entity.setUser(user);
                entity.setFlag(false);
                PostEntity postEntity =postRepository.save(entity);
		return new ResponseEntity<PostEntity>(postEntity, HttpStatus.CREATED);
	}
	@Override
	public ResponseEntity<List<PostEntity>> getAllPost() {
		 List<PostEntity> postEntity=postRepository.findAll();
		
		return new ResponseEntity<List<PostEntity>>(postEntity, HttpStatus.OK);
	}
	@Override
	public ResponseEntity<PostEntity> getByUSerId(String id) {
	
		PostEntity entities=postRepository.findById(id).orElseThrow(()-> new RuntimeException("post id  in not  found"));
		return new ResponseEntity<PostEntity>(entities , HttpStatus.OK);
	}
	@Override
	public ResponseEntity<PostEntity> updateByPostUsingID(PostEntity postEntity, String id) {
		PostEntity entities=postRepository.findById(id).orElseThrow(()-> new RuntimeException("post id  in not  found"));
		  entities.setPostfield(postEntity.getPostfield());
		  
		PostEntity postEntity2=   postRepository.save(entities);		  
		return  new ResponseEntity<PostEntity>(postEntity2, HttpStatus.OK);
	}
	@Override
	public ResponseEntity<HttpStatus> deletedPostUsingID(String id) {
		PostEntity entities=postRepository.findById(id).orElseThrow(()-> new RuntimeException("post id  in not  found"));
		     postRepository.delete(entities);
		return new  ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
	@Override
	public ResponseEntity<List<PostEntity>> getUserIdPostAccess(String id) {
	      User user= userRepository.findById(id).orElseThrow(()->new RuntimeException("user id not found"));
		  List<PostEntity> entity= postRepository.findByuser(user);
		return new ResponseEntity(entity, HttpStatus.OK);
	}
	@Override
	public ResponseEntity<PostEntity> getUserIdPostAccessRole(Boolean success, String id) {
	    User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("user id not found"));;
	    PostEntity postEntity2=null;	
	       List<PostEntity> entities=postRepository.findAll();
	        for (PostEntity postEntity : entities) {   
	        	 	PostEntity entities1=postRepository.findById(postEntity.getPost_id()).orElseThrow(()-> new RuntimeException("post id  in not  found"));
	        		 entities1.setFlag(success);
	        		 postEntity2=   postRepository.save(entities1);
	    
	        }
		return new ResponseEntity(postEntity2, HttpStatus.OK);
	}
	
}
