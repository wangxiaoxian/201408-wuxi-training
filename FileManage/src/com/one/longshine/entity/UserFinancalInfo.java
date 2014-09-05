package com.one.longshine.entity;

/**
 * 用户账务信息
 * @author xu
 *
 */
public class UserFinancalInfo {

	private int financalSerialId; //账务信息流水号
	private UserFileInfo userFile;//用户流水号
	private String openingBank;   //开户行
	private String account;       //账号
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
