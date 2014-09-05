package com.one.longshine.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.one.longshine.entity.ChangeRecord;

public class UserFinancalForm extends ActionForm{
	/**
	 * 用户修改form
	 */
	private ChangeRecord changeRecord;//更改记录对象
	
	
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
