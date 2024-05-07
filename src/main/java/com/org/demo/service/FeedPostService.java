package com.org.demo.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.org.demo.enitity.PostEntity;

public interface FeedPostService {

	ResponseEntity<PostEntity> creatPost(PostEntity entity, String id);

	ResponseEntity<List<PostEntity>> getAllPost();

	ResponseEntity<PostEntity> getByUSerId(String id);

	ResponseEntity<PostEntity> updateByPostUsingID(PostEntity postEntity, String id);

	ResponseEntity<HttpStatus> deletedPostUsingID(String id);

	ResponseEntity<List<PostEntity>> getUserIdPostAccess(String id);

	ResponseEntity<PostEntity> getUserIdPostAccessRole(Boolean success,String id);
}
