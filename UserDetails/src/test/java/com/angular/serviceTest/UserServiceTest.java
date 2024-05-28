package com.angular.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

import com.angular.Entity.User;
import com.angular.Repository.UserRepository;
import com.angular.Service.UserService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTest {
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserService userService;
	
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
	
	
	@Test
	public void testAddUser() {
		User user=new User(101,"arul","aaa@gmail.com","aaaa");
		when(userRepository.save(user)).thenReturn(user);
		User users=userService.addUser(user);
		
		//assertEquals(HttpStatus.CREATED, users.getStatusCode());
		assertEquals(user, users);
		
		verify(userRepository, times(1)).save(user);
	}
	
	

}
