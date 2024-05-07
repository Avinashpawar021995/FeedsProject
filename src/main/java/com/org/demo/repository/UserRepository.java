package com.org.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.org.demo.enitity.User;
@Repository
public interface UserRepository extends JpaRepository<User, String> {
	Optional<User> findByEmail(String email);



//	@Query("select u from User u where u.username= :username  && u.password= :password")	 
//	User findbyLogin(@Param("username") String username, @Param("password") String password);
}
