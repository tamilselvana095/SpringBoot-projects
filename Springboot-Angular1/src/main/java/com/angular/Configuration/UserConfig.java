package com.angular.Configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class UserConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		 registry.addMapping("/**")
         .allowedOrigins("*") // Allow requests from any origin
         .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow only specified methods
         .allowedHeaders("*"); // Allow all headers
	}
	
}
