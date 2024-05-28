package com.jwt.jwt.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


import com.jwt.jwt.utils.Jwtutils;

import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {
	

	@Autowired 
	Jwtutils jwtutils;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		String auth=request.getHeader("Authorization");
		
		
		if(!(request.getRequestURI().contains("login") || request.getRequestURI().contains("signup"))){
		jwtutils.Verify(auth);
		}
		return true;
	}

}
