package com.junit.controller;

import java.util.List;

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

import com.junit.entity.User;
import com.junit.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/adduser")
	public ResponseEntity<String> addUser(@RequestBody User user){return userService.addUser(user);}
	
	@GetMapping("/getall")
	public List<User> getAll(){return userService.getAll();}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Integer id,@RequestBody User user){return userService.updateUser(id,user);}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable Integer id) {return userService.deleteUser(id);}


}
