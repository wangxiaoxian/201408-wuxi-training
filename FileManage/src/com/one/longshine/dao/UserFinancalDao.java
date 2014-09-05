package com.one.longshine.dao;

import java.util.List;

import com.one.longshine.entity.ChangeRecord;
import com.one.longshine.entity.UserFinancalInfo;


public interface UserFinancalDao {
	/**
	 * ��ȡ�û���ϵ�����һ��ID
	 */
	int getNextId();
	/**
	 * ͨ���û���ˮ�Ų����û�������Ϣ
	 */
	List<UserFinancalInfo> searchByUserSerialId(int userSerialId);
	
	/**
	 * ͨ��������ˮ�Ų���������Ϣ
	 */
	UserFinancalInfo searchByFinancalSerialId(int financalSerialId);
	
	/**
	 * �����û�������Ϣ
	 */
	boolean updateFinancal(int fid,String field,String value,ChangeRecord cr);
	
	/**
	 * ͨ���û������������û�������Ϣ
	 */
	boolean addUserFinancalInfo(UserFinancalInfo ufni);
	
	/**
	 * ͨ���û�����IDɾ���û�������Ϣ
	 */
	boolean delUserFinancalInfo(int fid);
	/**
	 * ͨ�����������˺Ų���������Ϣ
	 */
	boolean searchByBankAccount(String bank,String account);
}
