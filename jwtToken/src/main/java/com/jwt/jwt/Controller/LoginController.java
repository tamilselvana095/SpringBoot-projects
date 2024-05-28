package com.jwt.jwt.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.jwt.Dto.LoginRequestDto;
import com.jwt.jwt.Dto.SignupRequestDto;
import com.jwt.jwt.Service.LoginService;
import com.jwt.jwt.apiResponse.Apiresponse;
import com.jwt.jwt.utils.Jwtutils;



@RestController
public class LoginController {
	
	
	@Autowired
	private LoginService loginservice;
	
	@Autowired
	Jwtutils jwtutils;
	
	@PostMapping("/signup")
	public ResponseEntity<Apiresponse> signUp(@RequestBody SignupRequestDto signupRequestDto ) {
		
		return loginservice.signUp(signupRequestDto);
		
	}
	@PostMapping("/login")
	public Apiresponse login(@RequestBody LoginRequestDto loginRequestDto ) throws Exception {
		
		return loginservice.login(loginRequestDto);
		
	}
	@GetMapping("/privateApi")
	public ResponseEntity<Apiresponse>privateApi(@RequestHeader(value = "authorisation")String auth) throws Exception{
		Apiresponse apiresponse=new Apiresponse();
		
		//jwtutils.Verify(auth);
		
		
		apiresponse.setData("this is private");
		apiresponse.setStatus(HttpStatus.OK.value());
		return ResponseEntity.status((HttpStatus) apiresponse.getStatus()).body(apiresponse);
	}
	

}
