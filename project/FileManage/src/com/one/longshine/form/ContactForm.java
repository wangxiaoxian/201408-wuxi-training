package com.one.longshine.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.one.longshine.entity.ChangeRecord;

public class ContactForm extends ActionForm {
	private ChangeRecord cr;
	
	public  ContactForm() {
		cr = new ChangeRecord();
	}
	public ChangeRecord getCr() {
		return cr;
	}
	public void setCr(ChangeRecord cr) {
		this.cr = cr;
	}
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.cr = new ChangeRecord();
		super.reset(mapping, request);
	}
}
