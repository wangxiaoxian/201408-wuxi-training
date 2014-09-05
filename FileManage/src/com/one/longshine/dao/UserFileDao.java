package com.one.longshine.dao;

import java.util.List;

import com.one.longshine.entity.PagerModel;
import com.one.longshine.entity.UserFileInfo;
import com.one.longshine.form.SearchFileForm;


public interface UserFileDao {

	/**
	 * 获取所有用户
	 * @return
	 */
	List<UserFileInfo> getAllUserFile();

	/**
	 * 按照sid获取指定的用户档案
	 * @param sid
	 * @return
	 */
	UserFileInfo getUserFile(int sid);

	/**
	 * 更新用户档案
	 */
	void updateUserFile(String field, UserFileInfo uf);

	/**
	 * 插入用户档案
	 */
	int insertUserFile(UserFileInfo uf);

	/**
	 * 分页获取用户档案列表
	 */
	PagerModel<UserFileInfo> getPagedUserFile(SearchFileForm sff, int recordNo, int pageSize);
	
	/**
	 * 通过用户流水号查找对应的用户档案
	 * hjm
	 */
	UserFileInfo searchByUserSerialId(int userSerialId);
}
