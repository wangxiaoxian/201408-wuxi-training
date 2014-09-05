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
	
	
	private String userId;		 //用户编号
	private int page;
	private int flag;
	
	private int changeSerialId;  //变更流水号
	private String cTable;       //变更表名
	private int cTableSerialId;  //对应修改表的流水号
	private int userSerialId;    //用户流水号
	private String cField;       //变更字段
	private String cBeforeValue; //变更前值
	private String cAfterValue;  //变更后值
	private String cReason;      //变更原因
	private String cContent;     //变更内容
	private String handler;      //处理人
	private Date handleTime;     //处理时间
	
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
