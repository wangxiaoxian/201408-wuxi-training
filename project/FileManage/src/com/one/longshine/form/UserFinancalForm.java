package com.one.longshine.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.one.longshine.entity.ChangeRecord;

public class UserFinancalForm extends ActionForm{
	/**
	 * �û��޸�form
	 */
	private ChangeRecord changeRecord;//���ļ�¼����
	
	
	public  UserFinancalForm() {
		changeRecord = new ChangeRecord();
	}
	
	
	public ChangeRecord getChangeRecord() {
		return changeRecord;
	}
	public void setChangeRecord(ChangeRecord changeRecord) {
		this.changeRecord = changeRecord;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.changeRecord = new ChangeRecord();
		super.reset(mapping, request);
	}
}
