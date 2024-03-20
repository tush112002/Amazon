package com.model;

public class Users {
	private int userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private String userAvatar;
	private String userAddress;
	private String userMobile;

	public Users() {

	}
	
	public Users(int userId) {
		super();
		this.userId = userId;
	}

	public Users(int userId, String userName, String userEmail, String userPassword, String userMobile, String userAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userMobile = userMobile;
		this.userAddress = userAddress;
	}

	public Users(int userId, String userName, String userEmail, String userPassword, 
			String userMobile,String userAddress , String userAvatar) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userAvatar = userAvatar;
		this.userAddress = userAddress;
		this.userMobile = userMobile;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}
	
	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", userAvatar=" + userAvatar + ", userAddress=" + userAddress + ", userMobile="
				+ userMobile + "]";
	}

}
