package com.one.longshine.form;

import org.apache.struts.action.ActionForm;

/**
 * 业务员登陆表单
 * @author Administrator
 *
 */
public class LoginForm extends ActionForm {

	private static final long serialVersionUID = 4253009296477102041L;
	
	private int userId; // 业务员id
	private String userName;//登陆名
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
