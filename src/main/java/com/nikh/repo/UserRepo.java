package com.nikh.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nikh.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	
	
	
	@Query("SELECT E FROM User E WHERE name:name")
	List<User> sameNameUser(String name);
	
	Optional<User> findByEmail(String email);
	
	
}
