package com.one.longshine.entity;

/**
 * 用户联系信息
 * @author xu
 *
 */
public class UserContactInfo {
		
	private int contactSerialId;      //联系信息流水号
	private UserFileInfo userFile;//用户档案实体
	private String contactType;       //联系方式('号码'：号码    '邮箱'：邮箱)
	private String contactDetails;    //联系号码或邮箱
	
	
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
