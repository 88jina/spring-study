package com.beans;

public class LoginBean {
	private String userEmail;
	private String userPassword;
	private int authStatus;
	@Override
	public String toString() {
		return "LoginBean [userEmail=" + userEmail + ", userPassword=" + userPassword + ", authStatus=" + authStatus
				+ "]";
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
	public int getAuthStatus() {
		return authStatus;
	}
	public void setAuthStatus(int authStatus) {
		this.authStatus = authStatus;
	}
}
