package com.nikh.service.impl;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nikh.dto.PageResponse;
import com.nikh.dto.PageResponse.PageResponseBuilder;
import com.nikh.dto.UserDto;
import com.nikh.entity.User;
import com.nikh.repo.UserRepo;
import com.nikh.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private ModelMapper mapper;
	

	@Override
	public String saveUser(UserDto userDto) {
		
		User user = this.mapper.map(userDto, User.class);
		User save = this.repo.save(user);
		return " User : " +  save.getName() +" save successfully ";
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		 User user = this.repo.findById(userId).orElseThrow();
		 user.setAbout(userDto.getAbout());
		 user.setName(userDto.getName());
		 user.setPassword(userDto.getPassword());
		 User user2 = this.repo.save(user);
		return this.mapper.map(user2, UserDto.class);
	}

	@Override
	public PageResponse allUser(String sortDir, String sortBy, Integer pageSize, Integer pageNum) {
		
		
		Sort sort = sortDir.equalsIgnoreCase("asc")
				? Sort.by(sortBy).ascending()
						: Sort.by(sortBy).descending();
		
		Pageable p = PageRequest.of(pageNum, pageSize, sort);
		
		
		 Page<User> page = this.repo.findAll(p);
		 
		  PageResponse pageResponse = PageResponse.builder()
		 .content(page.getContent())
		 .isLast( page.isLast())
		 .totalElements(page.getTotalElements())
		 .totalPages(page.getTotalPages()).build();
	
		return pageResponse;
	}

	@Override
	public List<UserDto> fetchUsersByName(String name) {
		
		//List<User> users = this.repo.sameNameUser(name);
	//	return users.stream().map(user->this.mapper.map(users, UserDto.class)).toList(); 
	return null;
	}

	@Override
	public UserDto fetchUserByEmail(String email) {
		
	User findByEmail = this.repo.findByEmail(email).get();
		
		return this.mapper.map(findByEmail, UserDto.class);
	}

	@Override
	public String deleteUser(String email) {
		User findByEmail = this.repo.findByEmail(email).get();
		this.repo.deleteById(findByEmail.getId());
		return "User Delete Successfully";
	}

}
