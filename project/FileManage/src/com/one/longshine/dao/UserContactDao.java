package com.one.longshine.dao;

import java.util.List;

import com.one.longshine.entity.UserContactInfo;


public interface UserContactDao {

	/**
	 * ��ȡ�û���ϵ�����һ��ID
	 */
	int getNextId();
	/**
	 * ͨ���û���ˮ�Ų����û���ϵ��Ϣ
	 */
	List<UserContactInfo> searchByUserSerialId(int uid);
	
	/**
	 * ͨ����ϵ��ˮ�Ų��Ҷ�Ӧ����ϵ��Ϣ 
	 */
	UserContactInfo searchByContactSerialId(int cid);
	
	/**
	 * �����û���ϵ��Ϣ
	 */
	boolean updateContact(int cid,String field,String value);
	
	/**
	 * ͨ���û���ϵ�������û���ϵ��Ϣ
	 */
	boolean addUserContactInfo(UserContactInfo uci);
	
	/**
	 * ͨ���û���ϵIDɾ���û���ϵ��Ϣ
	 */
	boolean delUserContactInfo(int cid);
	
	/**
	 * ͨ����ϵ��ʽ����ϵ���ݲ�����ϵ��Ϣ
	 */
	boolean searchByTypeDetail(String type,String detail);
}
