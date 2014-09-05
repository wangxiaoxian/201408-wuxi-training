package com.one.longshine.entity;

import java.util.Date;

/**
 * 用户档案信息
 * @author xu
 *
 */
public class UserFileInfo {
	
	private int userSerialId;//用户流水号
	private String userId;      //用户编号
	private String userName; //用户名
	private Date createDate; //立户日期
	private String address;  //用户地址
	private String state;    //是否销户（y：可用   n：不可用）
	private Date logoutDate; //销户日期
	
	public int getUserSerialId() {
		return userSerialId;
	}
	public void setUserSerialId(int userSerialId) {
		this.userSerialId = userSerialId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getLogoutDate() {
		return logoutDate;
	}
	public void setLogoutDate(Date logoutDate) {
		this.logoutDate = logoutDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
