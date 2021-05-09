package com.securview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securview.exceptions.ResourceNotFoundException;
import com.securview.model.Users;
import com.securview.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<Users> getUsers() {
		
		return userRepository.findAll();
	}
	
	public Users getUserById(Long userId) throws ResourceNotFoundException {
		Users user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Not found for this id: "+userId));
		return user;
	}
	
	public Users saveUser(Users user) {
		
		return userRepository.save(user);
	}
	
	public Users updateUser(Users user) {
		
		return userRepository.save(user);
	}
	
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}
}
