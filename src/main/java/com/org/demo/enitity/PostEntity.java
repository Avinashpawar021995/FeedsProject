package com.org.demo.enitity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Post")
@Entity
public class PostEntity {
	@Id
private String post_id;
@Column(nullable=false)
private String  postfield;
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
 private Date date;
private boolean flag;
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(referencedColumnName  = "id")
 private User user;
}
