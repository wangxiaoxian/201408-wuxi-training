package com.one.longshine.entity;

import java.util.Date;

/**
 * �û�������Ϣ
 * @author xu
 *
 */
public class UserFileInfo {
	
	private int userSerialId;//�û���ˮ��
	private String userId;      //�û����
	private String userName; //�û���
	private Date createDate; //��������
	private String address;  //�û���ַ
	private String state;    //�Ƿ�������y������   n�������ã�
	private Date logoutDate; //��������
	
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
