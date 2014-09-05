package com.one.longshine.form;

import org.apache.struts.action.ActionForm;

/**
 * 用户档案添加，更新的表单
 * @author Administrator
 *
 */
public class UserFileForm extends ActionForm {

	private static final long serialVersionUID = 4296418814243141498L;
	
	private int userSerialId;	// 用户流水号
	private String userId;		// 用户编号
	private String userName; 	// 用户名
	private String address;	 	// 用户地址
	private String oldValue; 	// 变更前值
	private String reason;	 	// 变更原因
	private String content;  	// 变更内容
	
	private String field;		// 要更新的列名
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOldValue() {
		return oldValue;
	}
	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getUserSerialId() {
		return userSerialId;
	}
	public void setUserSerialId(int userSerialId) {
		this.userSerialId = userSerialId;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
}
