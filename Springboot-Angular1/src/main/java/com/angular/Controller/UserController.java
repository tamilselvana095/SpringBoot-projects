package com.angular.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.angular.Repository.UserRepository;
import com.angular.model.User;

@RestController

public class UserController {

	@Autowired
	UserRepository userRepository;


	@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
	@GetMapping("/users")
	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
	}

	@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
	@PostMapping("/user") 
	User addUser(@RequestBody User user) {
		return userRepository.save(user); 
	}

}

