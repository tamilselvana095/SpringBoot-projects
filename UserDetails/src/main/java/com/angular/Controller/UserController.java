package com.angular.Controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.angular.Entity.User;
import com.angular.Service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class UserController {

	@Autowired
	UserService userService;
	
	
	@PostMapping("/adduser")
	public User addUser(@RequestBody User user){return userService.addUser(user);}
	
	@GetMapping("/getall")
	public List<User> getAll(){return userService.getAll();}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Integer id,@RequestBody User user){return userService.updateUser(id,user);}
	
	@CrossOrigin(origins = "http://localhost:4200") 
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable Integer id) {return userService.deleteUser(id);}
}
