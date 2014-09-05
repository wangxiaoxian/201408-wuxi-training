package com.one.longshine.form;

import org.apache.struts.action.ActionForm;

public class AddFinancalForm extends ActionForm {
	/**
	 * 增加账务信息form
	 */
	private static final long serialVersionUID = 1L;
	
	private String openingBank;//开户行
	private String account;//账号
	
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
