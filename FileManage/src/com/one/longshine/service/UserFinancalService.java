package com.one.longshine.service;

import java.util.List;

import com.one.longshine.entity.ChangeRecord;
import com.one.longshine.entity.UserFinancalInfo;

public interface UserFinancalService {
	/**
	 * ����ָ����ˮ�ŵ��û���������Ϣ
	 */
	List<UserFinancalInfo> searchByUserSerialId(int uid);
	/**
	 * ����ָ��������ˮ�ŵ�������Ϣ
	 */
	UserFinancalInfo searchByFinancalserialid(int fid);
	/**
	 * ����ָ��������ˮ�ŵ�����������Ϣ
	 */
	boolean updateFinancal(int ufnid,ChangeRecord cr);
	/**
	 * ����������Ϣ
	 */
	boolean addFinancal(int uid,String bank,String account);
	/**
	 * ɾ��������Ϣ
	 */
	boolean delFinancal(int uid,int fid);
	/**
	 * ͨ�����������˺Ų���������Ϣ
	 */
	boolean searchByBankAccount(String bank,String account);
}
