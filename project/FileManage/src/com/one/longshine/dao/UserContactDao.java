package com.one.longshine.dao;

import java.util.List;

import com.one.longshine.entity.UserContactInfo;


public interface UserContactDao {

	/**
	 * 获取用户联系表的下一个ID
	 */
	int getNextId();
	/**
	 * 通过用户流水号查找用户联系信息
	 */
	List<UserContactInfo> searchByUserSerialId(int uid);
	
	/**
	 * 通过联系流水号查找对应的联系信息 
	 */
	UserContactInfo searchByContactSerialId(int cid);
	
	/**
	 * 更新用户联系信息
	 */
	boolean updateContact(int cid,String field,String value);
	
	/**
	 * 通过用户联系类增加用户联系信息
	 */
	boolean addUserContactInfo(UserContactInfo uci);
	
	/**
	 * 通过用户联系ID删除用户联系信息
	 */
	boolean delUserContactInfo(int cid);
	
	/**
	 * 通过联系方式与联系内容查找联系信息
	 */
	boolean searchByTypeDetail(String type,String detail);
}
