package com.one.longshine.form;

import org.apache.struts.action.ActionForm;

/**
 * �û�������ӣ����µı�
 * @author Administrator
 *
 */
public class UserFileForm extends ActionForm {

	private static final long serialVersionUID = 4296418814243141498L;
	
	private int userSerialId;	// �û���ˮ��
	private String userId;		// �û����
	private String userName; 	// �û���
	private String address;	 	// �û���ַ
	private String oldValue; 	// ���ǰֵ
	private String reason;	 	// ���ԭ��
	private String content;  	// �������
	
	private String field;		// Ҫ���µ�����
	
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
