package com.one.longshine.entity;

/**
 * �û�������Ϣ
 * @author xu
 *
 */
public class UserFinancalInfo {

	private int financalSerialId; //������Ϣ��ˮ��
	private UserFileInfo userFile;//�û���ˮ��
	private String openingBank;   //������
	private String account;       //�˺�
	public int getFinancalSerialId() {
		return financalSerialId;
	}
	public void setFinancalSerialId(int financalSerialId) {
		this.financalSerialId = financalSerialId;
	}
	public UserFileInfo getUserFile() {
		return userFile;
	}
	public void setUserFile(UserFileInfo userFile) {
		this.userFile = userFile;
	}
	public String getOpeningBank() {
		return openingBank;
	}
	public void setOpeningBank(String openingBank) {
		this.openingBank = openingBank;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
}
