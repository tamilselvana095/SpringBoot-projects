package com.angular.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.angular.Entity.User;
import com.angular.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User addUser(User user) {
		
		//String insert = "User details inserted successfully";
		return userRepository.save(user);
	}

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public ResponseEntity<String> updateUser(Integer id, User user) {
		User updated = userRepository.findById(id).get();
		updated.setName(user.getName());
		updated.setEmail(user.getEmail());
		updated.setPassword(user.getPassword());
		userRepository.save(updated);
		String update = "User data updated successfully";

		return new ResponseEntity<String>(update, HttpStatus.OK);
	}

	public String deleteUser(Integer id) {
		userRepository.deleteById(id);
		String delete = "user data deleted successfully";
		return delete;

	}

}
