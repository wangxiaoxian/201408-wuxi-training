package com.one.longshine.form;

import org.apache.struts.action.ActionForm;
/**
 * ������ϵ��Ϣform
 * @author Administrator
 *
 */
public class AddContactForm extends ActionForm {
	
	private static final long serialVersionUID = 1L;
	private String contactType;//��ϵ��ʽ
	private String contactDetails;//��ϵ����
	
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
