package com.nikh.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;

@Entity
@Data
@Table( name = "user_tab")
public class User {
	
	@Id
	private Integer id;
	private String name;
	private String email;
	private String password;
	private String about;
	
	

}
