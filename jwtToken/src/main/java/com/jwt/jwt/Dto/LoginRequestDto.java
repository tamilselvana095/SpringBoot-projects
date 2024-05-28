package com.jwt.jwt.Dto;




public class LoginRequestDto {
	
	private String emailId;
	private String password;
	public LoginRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmailId() {
		return emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginRequestDto [emailId=" + emailId + ", password=" + password + "]";
	}

}
