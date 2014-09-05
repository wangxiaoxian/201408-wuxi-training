package com.one.longshine.dao;

import java.util.List;

import com.one.longshine.entity.PagerModel;
import com.one.longshine.entity.UserFileInfo;
import com.one.longshine.form.SearchFileForm;


public interface UserFileDao {

	/**
	 * ��ȡ�����û�
	 * @return
	 */
	List<UserFileInfo> getAllUserFile();

	/**
	 * ����sid��ȡָ�����û�����
	 * @param sid
	 * @return
	 */
	UserFileInfo getUserFile(int sid);

	/**
	 * �����û�����
	 */
	void updateUserFile(String field, UserFileInfo uf);

	/**
	 * �����û�����
	 */
	int insertUserFile(UserFileInfo uf);

	/**
	 * ��ҳ��ȡ�û������б�
	 */
	PagerModel<UserFileInfo> getPagedUserFile(SearchFileForm sff, int recordNo, int pageSize);
	
	/**
	 * ͨ���û���ˮ�Ų��Ҷ�Ӧ���û�����
	 * hjm
	 */
	UserFileInfo searchByUserSerialId(int userSerialId);
}
