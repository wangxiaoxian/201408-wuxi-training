package com.one.longshine.service;

import java.util.List;

import com.one.longshine.entity.ChangeRecord;
import com.one.longshine.entity.UserContactInfo;

public interface UserContactService {
	/**
	 * ����ָ����ˮ�ŵ��û�����ϵ��Ϣ
	 */
	List<UserContactInfo> searchByUserSerialId(int uid);
	/**
	 * ����ָ����ϵ��ˮ�ŵ���ϵ��Ϣ
	 */
	UserContactInfo searchByContactserialid(int fid);
	/**
	 * ����ָ����ϵ��ˮ�ŵ���ϵ�����Ϣ
	 */
	boolean updateContact(int cid,ChangeRecord cr);
	/**
	 * ������ϵ��Ϣ
	 */
	boolean addContact(int uid,String type,String detail);
	
	/**
	 * ɾ����ϵ��Ϣ
	 */
	boolean delContact(int cid,int uid);
	
	/**
	 * ͨ����ϵ��ʽ�����ݲ�����ϵ��Ϣ
	 */
	boolean searchByTypeDetail(String type,String detail);
}
