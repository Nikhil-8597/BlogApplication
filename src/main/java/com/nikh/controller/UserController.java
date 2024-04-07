package com.nikh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nikh.dto.PageResponse;
import com.nikh.dto.UserDto;
import com.nikh.service.UserService;



@RestController
@RequestMapping("/v2/user")
public class UserController {
	
	
	@Autowired
	private UserService service;
	
	@PostMapping("/")
	public String saveUser( @RequestBody UserDto user) {
		return this.service.saveUser(user);
	}
	
	@PutMapping("/{userId}")
	public UserDto updateUser(@RequestBody UserDto dto ,@PathVariable Integer userId) {
		return this.updateUser(dto, userId);
	}
	
	@GetMapping("/")
	public PageResponse allUser(
			@RequestParam( value = "sortDir", defaultValue = "asc", required = false) String sortDir,
			@RequestParam( value = "sortBy", defaultValue = "name", required = false) String sortBy,
			@RequestParam ( value = "pageNum", defaultValue = "10", required = false)Integer pageNum,
			@RequestParam ( value = "pageSize", defaultValue = "1", required = false)Integer pageSize)
   {
		return this.service.allUser(sortDir, sortBy, pageSize, pageNum);
				
	}
	
	@GetMapping("/name/{name}")
	public List<UserDto> fetchUsersByName(@PathVariable String name){
		return this.service.fetchUsersByName(name);		
	}

	@GetMapping("/email/{email}")
	public UserDto fetchUserByEmail(@PathVariable String email) {
		return null;
	}
	
	@DeleteMapping("/{email}")
	public String deleteUser(@PathVariable String email) {
		return null;
	}
	

}
