package com.one.longshine.form;

import org.apache.struts.action.ActionForm;

/**
 * ҵ��Ա��½��
 * @author Administrator
 *
 */
public class LoginForm extends ActionForm {

	private static final long serialVersionUID = 4253009296477102041L;
	
	private int userId; // ҵ��Աid
	private String userName;//��½��
	private String password;//����
	
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
