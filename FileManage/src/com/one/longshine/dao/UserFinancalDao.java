package com.one.longshine.dao;

import java.util.List;

import com.one.longshine.entity.ChangeRecord;
import com.one.longshine.entity.UserFinancalInfo;


public interface UserFinancalDao {
	/**
	 * 获取用户联系表的下一个ID
	 */
	int getNextId();
	/**
	 * 通过用户流水号查找用户账务信息
	 */
	List<UserFinancalInfo> searchByUserSerialId(int userSerialId);
	
	/**
	 * 通过账务流水号查找账务信息
	 */
	UserFinancalInfo searchByFinancalSerialId(int financalSerialId);
	
	/**
	 * 更新用户账务信息
	 */
	boolean updateFinancal(int fid,String field,String value,ChangeRecord cr);
	
	/**
	 * 通过用户账务类增加用户账务信息
	 */
	boolean addUserFinancalInfo(UserFinancalInfo ufni);
	
	/**
	 * 通过用户账务ID删除用户账务信息
	 */
	boolean delUserFinancalInfo(int fid);
	/**
	 * 通过开户行与账号查找账务信息
	 */
	boolean searchByBankAccount(String bank,String account);
}
