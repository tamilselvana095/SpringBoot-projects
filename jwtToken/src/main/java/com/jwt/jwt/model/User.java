package com.jwt.jwt.model;



import java.time.LocalDateTime;


import org.apache.tomcat.util.bcel.classfile.Constant;
import org.hibernate.annotations.Type;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class User {
	   @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	    private Long id;
	    private String name;
	    private String gender;
	    private String emailId;
	    private String phoneNumber;
	    private String userType ;
	    private String password;
	    private Boolean isActive = true;
	    private Integer loginCount = 0;
	    private String ssoType;
	   
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Long getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getGender() {
			return gender;
		}

		public String getEmailId() {
			return emailId;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public String getUserType() {
			return userType;
		}

		public String getPassword() {
			return password;
		}

		public Boolean getIsActive() {
			return isActive;
		}

		public Integer getLoginCount() {
			return loginCount;
		}

		public String getSsoType() {
			return ssoType;
		}

		

		public void setId(Long id) {
			this.id = id;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public void setUserType(String userType) {
			this.userType = userType;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public void setIsActive(Boolean isActive) {
			this.isActive = isActive;
		}

		public void setLoginCount(Integer loginCount) {
			this.loginCount = loginCount;
		}

		public void setSsoType(String ssoType) {
			this.ssoType = ssoType;
		}

		
		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", emailId=" + emailId
					+ ", phoneNumber=" + phoneNumber + ", userType=" + userType + ", password=" + password
					+ ", isActive=" + isActive + ", loginCount=" + loginCount + ", ssoType=" + ssoType + "]";
		}
	    
}


	   