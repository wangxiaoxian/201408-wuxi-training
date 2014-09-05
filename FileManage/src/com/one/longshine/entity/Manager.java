package com.one.longshine.entity;

/**
 * 管理信息
 * @author xu
 *
 */
public class Manager {
	
	private int userId;//用户ID
	private String userName;//用户名
	private String password;//密码
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
