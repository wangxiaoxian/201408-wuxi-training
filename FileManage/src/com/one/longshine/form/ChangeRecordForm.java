package com.one.longshine.form;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ChangeRecordForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2976359047368542064L;
	
	
	private String userId;		 //�û����
	private int page;
	private int flag;
	
	private int changeSerialId;  //�����ˮ��
	private String cTable;       //�������
	private int cTableSerialId;  //��Ӧ�޸ı����ˮ��
	private int userSerialId;    //�û���ˮ��
	private String cField;       //����ֶ�
	private String cBeforeValue; //���ǰֵ
	private String cAfterValue;  //�����ֵ
	private String cReason;      //���ԭ��
	private String cContent;     //�������
	private String handler;      //������
	private Date handleTime;     //����ʱ��
	
	public ChangeRecordForm(){
		page=1;
		
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public int getChangeSerialId() {
		return changeSerialId;
	}


	public void setChangeSerialId(int changeSerialId) {
		this.changeSerialId = changeSerialId;
	}


	public String getcTable() {
		return cTable;
	}


	public void setcTable(String cTable) {
		this.cTable = cTable;
	}


	public int getcTableSerialId() {
		return cTableSerialId;
	}


	public void setcTableSerialId(int cTableSerialId) {
		this.cTableSerialId = cTableSerialId;
	}


	


	public String getcField() {
		return cField;
	}


	public void setcField(String cField) {
		this.cField = cField;
	}


	public String getcBeforeValue() {
		return cBeforeValue;
	}


	public void setcBeforeValue(String cBeforeValue) {
		this.cBeforeValue = cBeforeValue;
	}


	public String getcAfterValue() {
		return cAfterValue;
	}


	public void setcAfterValue(String cAfterValue) {
		this.cAfterValue = cAfterValue;
	}


	public String getcReason() {
		return cReason;
	}


	public void setcReason(String cReason) {
		this.cReason = cReason;
	}


	public String getcContent() {
		return cContent;
	}


	public void setcContent(String cContent) {
		this.cContent = cContent;
	}


	public String getHandler() {
		return handler;
	}


	public void setHandler(String handler) {
		this.handler = handler;
	}


	public Date getHandleTime() {
		return handleTime;
	}


	public void setHandleTime(Date handleTime) {
		this.handleTime = handleTime;
	}


	public int getUserSerialId() {
		return userSerialId;
	}


	public void setUserSerialId(int userSerialId) {
		this.userSerialId = userSerialId;
	}


	public int getFlag() {
		return flag;
	}


	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	
	
}
