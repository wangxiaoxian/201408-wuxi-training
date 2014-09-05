package com.one.longshine.entity;

import java.util.Date;

/**
 * 档案变更记录
 * @author xu
 *
 */
public class ChangeRecord {
	private int changeSerialId;  //变更流水号
	private String cTable;       //变更表名
	private int cTableSerialId;  //对应修改表的流水号
	private UserFileInfo userFile;    //用户流水号
	private String cField;       //变更字段
	private String cBeforeValue; //变更前值
	private String cAfterValue;  //变更后值
	private String cReason;      //变更原因
	private String cContent;     //变更内容
	private String handler;      //处理人
	private Date handleTime;     //处理时间
	
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
	
	public UserFileInfo getUserFile() {
		return userFile;
	}
	public void setUserFile(UserFileInfo userFile) {
		this.userFile = userFile;
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






}
