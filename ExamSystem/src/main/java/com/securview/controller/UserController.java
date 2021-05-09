package com.securview.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securview.exceptions.ResourceNotFoundException;
import com.securview.model.Users;
import com.securview.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	Logger logger = Logger.getLogger(UserController.class.getName());
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public List<Users> getUsers() {
		return userService.getUsers();
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<Users> getUserById(@PathVariable Long userId) throws ResourceNotFoundException {
		logger.info("getting user by id : "+userId);
		Users user = null;
		try{
			user = userService.getUserById(userId);
		}catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping("/")
	public Users saveUser(@RequestBody Users user) {
		return userService.saveUser(user);
	}
	
	@PutMapping("/")
	public Users updateUser(@RequestBody Users user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable(value="id") Long userId) {
		userService.deleteUser(userId);
	}

}
