package com.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.junit.entity.User;
import com.junit.repository.UserRepository;
import com.junit.service.UserService;



@ExtendWith(MockitoExtension.class)
//@SpringBootTest
public class UserServiceTest {
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserService userService;
	
//	@BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
	
	
	@Test
	public void testAddUser() {
		User user=new User(101,"arul","aaa@gmail.com","aaaa");
		when(userRepository.save(user)).thenReturn(user);
		ResponseEntity<String>response=userService.addUser(user);
		
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals("User details inserted successfully", response.getBody());
		
		verify(userRepository, times(1)).save(user);
	}
	
	@Test
	public void testGetAll() {
		List<User>userlist=new ArrayList<>();
		userlist.add(new User());
		userlist.add(new User());
		userlist.add(new User());
		userlist.add(new User());
		
		when(userRepository.findAll()).thenReturn(userlist);
		
		List<User>result=userService.getAll();
		
		assertEquals(result.size(), userlist.size());
		
		verify(userRepository,times(1)).findAll();
		
	}
	
	@Test
    public void testUpdateUser() {
        // Given
        User existingUser = new User();
        existingUser.setId(1);
        existingUser.setName("John");
        existingUser.setEmail("john@example.com");
        existingUser.setPassword("password");

        User updatedUser = new User();
        updatedUser.setName("Updated John");
        updatedUser.setEmail("updatedjohn@example.com");
        updatedUser.setPassword("updatedpassword");

        when(userRepository.findById(1)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(existingUser)).thenReturn(existingUser);

        // When
        ResponseEntity<String> response = userService.updateUser(1, updatedUser);

        // Then
        assertEquals("User data updated successfully", response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedUser.getName(), existingUser.getName());
        assertEquals(updatedUser.getEmail(), existingUser.getEmail());
        assertEquals(updatedUser.getPassword(), existingUser.getPassword());
        verify(userRepository, times(1)).findById(1);
        verify(userRepository, times(1)).save(existingUser);
    }
	
	 @Test
	    public void testDeleteUser() {
	        // Given
	        Integer userId = 1;
	        doNothing().when(userRepository).deleteById(userId);

	        // When
	        String response = userService.deleteUser(userId);

	        // Then
	        assertEquals("user data deleted successfully", response);
	        verify(userRepository, times(1)).deleteById(userId);
	    }
	
	



}
