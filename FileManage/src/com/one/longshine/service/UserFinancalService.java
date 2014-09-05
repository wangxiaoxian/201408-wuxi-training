package com.one.longshine.service;

import java.util.List;

import com.one.longshine.entity.ChangeRecord;
import com.one.longshine.entity.UserFinancalInfo;

public interface UserFinancalService {
	/**
	 * 查找指定流水号的用户的账务信息
	 */
	List<UserFinancalInfo> searchByUserSerialId(int uid);
	/**
	 * 查找指定账务流水号的账务信息
	 */
	UserFinancalInfo searchByFinancalserialid(int fid);
	/**
	 * 更新指定账务流水号的账务的相关信息
	 */
	boolean updateFinancal(int ufnid,ChangeRecord cr);
	/**
	 * 增加账务信息
	 */
	boolean addFinancal(int uid,String bank,String account);
	/**
	 * 删除账务信息
	 */
	boolean delFinancal(int uid,int fid);
	/**
	 * 通过开户行与账号查找账务信息
	 */
	boolean searchByBankAccount(String bank,String account);
}
