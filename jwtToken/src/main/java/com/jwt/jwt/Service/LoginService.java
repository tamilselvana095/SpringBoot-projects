package com.jwt.jwt.Service;



import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jwt.jwt.Dto.LoginRequestDto;
import com.jwt.jwt.Dto.SignupRequestDto;
import com.jwt.jwt.apiResponse.Apiresponse;
import com.jwt.jwt.model.User;
import com.jwt.jwt.repostry.UserRepostry;
import com.jwt.jwt.utils.Jwtutils;



@Service
public class LoginService {
	
	
	@Autowired
	UserRepostry userRepostry;

	
	@Autowired
	 Jwtutils jwtutils;
	@Autowired
	User userEntity;
	
	public ResponseEntity<Apiresponse> signUp(SignupRequestDto signupRequestDto) {
		
		Apiresponse apiresponse=new Apiresponse();
		
		//User userEntity=new User();
		
		userEntity.setName(signupRequestDto.getName());
		userEntity.setEmailId(signupRequestDto.getEmailId());
		userEntity.setIsActive(Boolean.TRUE);
		userEntity.setGender(signupRequestDto.getGender());
		userEntity.setPhoneNumber(signupRequestDto.getPhoneNumber());
		userEntity.setPassword(signupRequestDto.getPassword());
		
		 userEntity=userRepostry.save(userEntity);
		 

		
		 apiresponse.setStatus(HttpStatus.CREATED);
		 apiresponse.setData(userEntity);
		 apiresponse.setError("no error");
		
		
		return new ResponseEntity<Apiresponse>(apiresponse, HttpStatus.CREATED);
	}

	public Apiresponse login(LoginRequestDto loginRequestDto) throws Exception {
		
		User user=userRepostry.findOneByemailIdignorecaseAndpassword(loginRequestDto.getEmailId(),loginRequestDto.getPassword());
		Apiresponse apiresponse=new Apiresponse();
		if(user==null) {
			throw new Exception();
			
		}
		
		String token=jwtutils.generateJwt(user);
		
		Map<String, Object>data=new HashMap<>();
		data.put("accessToken",token);
		
		apiresponse.setData(data);
		
		return apiresponse;
	}

}
