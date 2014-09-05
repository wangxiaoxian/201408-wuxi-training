package com.one.longshine.service;

import java.util.List;

import com.one.longshine.entity.ChangeRecord;
import com.one.longshine.entity.UserContactInfo;

public interface UserContactService {
	/**
	 * 查找指定流水号的用户的联系信息
	 */
	List<UserContactInfo> searchByUserSerialId(int uid);
	/**
	 * 查找指定联系流水号的联系信息
	 */
	UserContactInfo searchByContactserialid(int fid);
	/**
	 * 更新指定联系流水号的联系相关信息
	 */
	boolean updateContact(int cid,ChangeRecord cr);
	/**
	 * 增加联系信息
	 */
	boolean addContact(int uid,String type,String detail);
	
	/**
	 * 删除联系信息
	 */
	boolean delContact(int cid,int uid);
	
	/**
	 * 通过联系方式与内容查找联系信息
	 */
	boolean searchByTypeDetail(String type,String detail);
}
