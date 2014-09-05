package com.one.longshine.form;

import org.apache.struts.action.ActionForm;
/**
 * 增加联系信息form
 * @author Administrator
 *
 */
public class AddContactForm extends ActionForm {
	
	private static final long serialVersionUID = 1L;
	private String contactType;//联系方式
	private String contactDetails;//联系内容
	
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
