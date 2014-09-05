package com.one.longshine.service;

import java.util.List;

import com.one.longshine.entity.ChangeRecord;
import com.one.longshine.entity.PagerModel;
import com.one.longshine.entity.UserFileInfo;
import com.one.longshine.form.SearchFileForm;

public interface UserFileService {

	public List<UserFileInfo> getUserFiles();
	
	public PagerModel<UserFileInfo> getUserFiles(SearchFileForm sff, int recordNo, int pageSize);

	public UserFileInfo getUserFile(int sid);

	public void editUserFile(String field, UserFileInfo uf, ChangeRecord cr);

	public void addUserFile(UserFileInfo uf, ChangeRecord cr);
	
	/**
	 * 查找指定流水号的用户档案信息
	 * hjm
	 */
	UserFileInfo searchByUserSerialId(int userSerialId);
}
