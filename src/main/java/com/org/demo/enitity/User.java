package com.org.demo.enitity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@Entity
public class User  {
	@Id
 private String id;
	@Column(nullable = false)
 private String name;
	@Column(nullable = false)
 private String password;
	@Column(nullable = false, unique = true)
 private String email;
	@Column(nullable = false)
 private String phone_no;
  private String role;
}
