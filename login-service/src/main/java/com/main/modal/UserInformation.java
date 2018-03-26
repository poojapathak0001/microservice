package com.main.modal;

import java.util.Date;


public class UserInformation {

	private String userId;

	private String userName;
	private String email;
	
	private String password;

	public UserInformation() {
		super();

	}
	
	public UserInformation(String userId, String userName, String email, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserInformation [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password="
				+ password + "]";
	}
	
	
}
