package com.one.longshine.entity;

/**
 * �û���ϵ��Ϣ
 * @author xu
 *
 */
public class UserContactInfo {
		
	private int contactSerialId;      //��ϵ��Ϣ��ˮ��
	private UserFileInfo userFile;//�û�����ʵ��
	private String contactType;       //��ϵ��ʽ('����'������    '����'������)
	private String contactDetails;    //��ϵ���������
	
	
	public int getContactSerialId() {
		return contactSerialId;
	}
	public void setContactSerialId(int contactSerialId) {
		this.contactSerialId = contactSerialId;
	}
	
	public UserFileInfo getUserFile() {
		return userFile;
	}
	public void setUserFile(UserFileInfo userFile) {
		this.userFile = userFile;
	}
	public String getContactType() {
		return contactType;
	}
	public void setContactType(String contactType) {
		this.contactType = contactType;
	}
	public String getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}
	
}
