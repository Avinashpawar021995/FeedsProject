package com.org.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.demo.enitity.PostEntity;
import com.org.demo.enitity.User;
@Repository
public interface PostRepository extends JpaRepository<PostEntity, String> {

	List<PostEntity> findByuser(User user);

}
