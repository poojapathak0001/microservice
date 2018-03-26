package com.main.modal;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description="All details about the user. ")
public class UserInformation {

	@Id
	private String userId;
	@Size(min=2,max=8,message="User Name should be atleast of length 2 and max of length 8")
	@NotNull
	@ApiModelProperty(notes="Name should have atleast 2 characters")
	private String userName;
	@Id
	private String email;
	@Size(min=6,max=12,message="Password should be atleast of length 6 and max of length 12")
	private String password;

	public UserInformation() {
		super();

	}

	public UserInformation(@NotNull String userId,
			@Size(min = 2, max = 8, message = "User Name should be atleast of length 2 and max of length 8") @NotNull String userName,
			String email,
			@Size(min = 6, max = 12, message = "Password should be atleast of length 6 and max of length 12") String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
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
