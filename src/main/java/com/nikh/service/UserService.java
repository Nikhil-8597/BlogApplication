package com.nikh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nikh.dto.PageResponse;
import com.nikh.dto.UserDto;



@Service
public interface UserService {
	// create user
	public String saveUser(UserDto user);
	// update user
	public UserDto updateUser(UserDto dto , Integer userId);
	// fetch all user
	public PageResponse allUser(String sortDir, String sortBy, Integer pageSize, Integer pageNum);
	// fetch user by name
	public List<UserDto> fetchUsersByName(String name);
	// fetch user by email
	public UserDto fetchUserByEmail(String email);
	// delete user
	public String deleteUser(String email);
	
	

}
