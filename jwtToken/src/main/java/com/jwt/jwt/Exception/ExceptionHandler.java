package com.jwt.jwt.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.jwt.jwt.apiResponse.Apiresponse;

@ControllerAdvice
public class ExceptionHandler {

	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity handleBadrequestException(BadRequestException e) {
		Apiresponse apiresponse=new Apiresponse();
		apiresponse.setStatus(HttpStatus.BAD_REQUEST.value());
		
		
		return ResponseEntity.status(400).body(apiresponse);
		
		
	}
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity handleAccessdeniedException(AccessdeniedException e) {
		Apiresponse apiresponse=new Apiresponse();
		apiresponse.setStatus(HttpStatus.UNAUTHORIZED.value());
		apiresponse.setError(e.getMessage());
		
		return ResponseEntity.status(400).body(apiresponse);
		//return new ResponseEntity<>(apiresponse,HttpStatus.UNAUTHORIZED);
		
	}
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity handleException(Exception E) {
		
		Apiresponse apiresponse=new Apiresponse();
		
		apiresponse.setError("Oops....somthing went wrong");
		apiresponse.setStatus(500);
		
		return  ResponseEntity.status((HttpStatus) apiresponse.getStatus()).body(apiresponse);
	}
	
}
