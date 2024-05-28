package com.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.junit.controller.UserController;
import com.junit.entity.User;
import com.junit.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	
	@Mock
	UserService userService;
	
	@InjectMocks
	UserController usercontroller;
	
	@Test
	public void testAddUser() {
		
		User user=new User();
		
		when(userService.addUser(user)).thenReturn(new ResponseEntity<String>("User added successfully", HttpStatus.CREATED));
		
		ResponseEntity<String>result=usercontroller.addUser(user);
		
		assertEquals(HttpStatus.CREATED, result.getStatusCode());
		assertEquals("User added successfully", result.getBody());
		
		verify(userService, times(1)).addUser(user);
		
	}
	
	@Test
	public void testGetAll() {
		
		List<User>userlist=new ArrayList<>();
		userlist.add(new User());
		userlist.add(new User());
		userlist.add(new User());
		
		when(userService.getAll()).thenReturn(userlist);
		
		List<User>result=usercontroller.getAll();
		
		assertEquals(userlist.size(), result.size() );
		
		verify(userService, times(1)).getAll();
		
	}
	
	@Test
	public void testUpdateUser() {
		
		User user=new User();
		
		when(userService.updateUser(1, user)).thenReturn(new ResponseEntity<String>("Updated successfully", HttpStatus.OK));
		
		ResponseEntity<String>result=usercontroller.updateUser(1, user);
		
		assertEquals(HttpStatus.OK,result.getStatusCode() );
		assertEquals("Updated successfully", result.getBody());
		verify(userService, times(1)).updateUser(1, user);
	}
	

}
