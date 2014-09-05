package com.one.longshine.service.impl;

import java.util.List;

import com.one.longshine.dao.ChangeRecordDao;
import com.one.longshine.dao.UserFileDao;
import com.one.longshine.dao.impl.ChangeRecordDaoImpl;
import com.one.longshine.dao.impl.UserFileDaoImpl;
import com.one.longshine.entity.ChangeRecord;
import com.one.longshine.entity.PagerModel;
import com.one.longshine.entity.UserFileInfo;
import com.one.longshine.form.SearchFileForm;
import com.one.longshine.service.UserFileService;

public class UserFileServiceImpl implements UserFileService {

	private UserFileDao ufDao = new UserFileDaoImpl();
	private ChangeRecordDao crDao = new ChangeRecordDaoImpl();
	
	@Override
	public List<UserFileInfo> getUserFiles() {
		
		return ufDao.getAllUserFile();
	}

	
	@Override
	public UserFileInfo getUserFile(int sid) {
		return ufDao.getUserFile(sid);
	}

	/**
	 * ����id���������������ݿ��Ϊָ����ֵ
	 * @param id ��¼��Ψһ��ʶ������ˮ��
	 * @param field ��Ӧ���ݿ�������
	 * @param value Ҫ���µ�ֵ
	 */
	@Override
	public void editUserFile(String field, UserFileInfo uf, ChangeRecord cr) {
		ufDao.updateUserFile(field, uf);
		crDao.insertChangeRecord(cr);
	}


	@Override
	public void addUserFile(UserFileInfo uf, ChangeRecord cr) {
		int sid = ufDao.insertUserFile(uf);
		
		// ����userFlile���ܻ��������ˮ�ţ������ｫ�����ý���ChangeRecord���棬�Ա����
		UserFileInfo userFile = new UserFileInfo();
		userFile.setUserSerialId(sid);
		cr.setUserFile(userFile);
		
		// ��Ϊ�ǲ��룬���Բ���ǰ��ֵ���ǿյ�
		cr.setcBeforeValue("");
		
		// �ֱ�Ը������Բ�������¼
		cr.setcField("username");
		cr.setcAfterValue(uf.getUserName());
		crDao.insertChangeRecord(cr);
		
		cr.setcField("address");
		cr.setcAfterValue(uf.getAddress());
		crDao.insertChangeRecord(cr);
	}

	/**
	 * ��ҳ��ѯ��userfile�б�
	 */
	@Override
	public PagerModel<UserFileInfo> getUserFiles(SearchFileForm sff, int recordNo,
			int pageSize) {
		return ufDao.getPagedUserFile(sff, recordNo, pageSize);
	}
	
	//hjm
	@Override
	public UserFileInfo searchByUserSerialId(int userSerialId) {
		UserFileDao ufd = new UserFileDaoImpl();
		UserFileInfo ufi = ufd.searchByUserSerialId(userSerialId);
		return ufi;
	}

}
