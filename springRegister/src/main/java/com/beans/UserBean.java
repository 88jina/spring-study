package com.beans;

import javax.validation.constraints.*;


public class UserBean {
	private int userId;
	
	@Email
	private String userEmail;
	@NotEmpty(message = "비밀번호를 입력해주세요")
	private String userPassword;
	private String userAddr;
	private int userDegree;
	private int userType;
	private String authKey;
	private int authStatus;
	private int availablePoint;
	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", userEmail=" + userEmail + ", userPassword=" + userPassword
				+ ", userAddr=" + userAddr + ", userDegree=" + userDegree + ", userType=" + userType + ", authKey="
				+ authKey + ", authStatus=" + authStatus + ", availablePoint=" + availablePoint + "]";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public int getUserDegree() {
		return userDegree;
	}
	public void setUserDegree(int userDegree) {
		this.userDegree = userDegree;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getAuthKey() {
		return authKey;
	}
	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}
	public int getAuthStatus() {
		return authStatus;
	}
	public void setAuthStatus(int authStatus) {
		this.authStatus = authStatus;
	}
	public int getAvailablePoint() {
		return availablePoint;
	}
	public void setAvailablePoint(int availablePoint) {
		this.availablePoint = availablePoint;
	}
	
	
}
