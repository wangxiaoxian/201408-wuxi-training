package com.one.longshine.entity;

import java.util.Date;

/**
 * ���������¼
 * @author xu
 *
 */
public class ChangeRecord {
	private int changeSerialId;  //�����ˮ��
	private String cTable;       //�������
	private int cTableSerialId;  //��Ӧ�޸ı����ˮ��
	private UserFileInfo userFile;    //�û���ˮ��
	private String cField;       //����ֶ�
	private String cBeforeValue; //���ǰֵ
	private String cAfterValue;  //�����ֵ
	private String cReason;      //���ԭ��
	private String cContent;     //�������
	private String handler;      //������
	private Date handleTime;     //����ʱ��
	
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
