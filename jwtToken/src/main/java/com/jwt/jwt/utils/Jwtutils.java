package com.jwt.jwt.utils;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.jwt.jwt.Exception.AccessdeniedException;
import com.jwt.jwt.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;





@Component
public class Jwtutils {
	private static String secret="java";
	
	
	public String generateJwt(User user) {
		
		long milliTime=System.currentTimeMillis();
		long expiryTime=milliTime+(60*60*1000);
		Date issuedAt=new Date(milliTime);
		Date expiryAt=new Date(expiryTime);
		
		
		//set paylode
		
		
		Claims claims=Jwts.claims()
							.setIssuer(user.getId().toString())
							.setIssuedAt(issuedAt)
							.setExpiration(expiryAt);
		
		
		claims.put("type", user.getUserType());
		claims.put("name", user.getName());
		claims.put("email", user.getEmailId());
		claims.put("gender", user.getGender());
		
		
		
		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS512, secret)
				 .compact();
		
	}
	
	public void Verify(String authorisation) throws Exception {
		
		try {
		Jwts.parser().setSigningKey(secret).parseClaimsJws(authorisation);
		}
		catch (Exception e) {
			throw new AccessdeniedException("Access Denied");
		}
	}

}
