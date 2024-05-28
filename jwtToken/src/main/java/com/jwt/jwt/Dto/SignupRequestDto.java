package com.jwt.jwt.Dto;

public class SignupRequestDto {
	
	    private String name;
	    private String gender;
	    private String emailId;
	    private String phoneNumber;
	    private String password;
	    public SignupRequestDto() {
			super();
			// TODO Auto-generated constructor stub
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
		public String getPassword() {
			return password;
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
		public void setPassword(String password) {
			this.password = password;
		}
		@Override
		public String toString() {
			return "SignupRequestDto [name=" + name + ", gender=" + gender + ", emailId=" + emailId + ", phoneNumber="
					+ phoneNumber + ", password=" + password + "]";
		}
		

}
