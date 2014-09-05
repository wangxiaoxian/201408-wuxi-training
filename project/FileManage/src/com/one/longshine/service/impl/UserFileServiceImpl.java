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
	 * 根据id和列名，更新数据库表为指定的值
	 * @param id 记录的唯一标识，即流水号
	 * @param field 对应数据库表的列名
	 * @param value 要更新的值
	 */
	@Override
	public void editUserFile(String field, UserFileInfo uf, ChangeRecord cr) {
		ufDao.updateUserFile(field, uf);
		crDao.insertChangeRecord(cr);
	}


	@Override
	public void addUserFile(UserFileInfo uf, ChangeRecord cr) {
		int sid = ufDao.insertUserFile(uf);
		
		// 插入userFlile才能获得他的流水号，在这里将它设置进入ChangeRecord里面，以便插入
		UserFileInfo userFile = new UserFileInfo();
		userFile.setUserSerialId(sid);
		cr.setUserFile(userFile);
		
		// 因为是插入，所以插入前的值都是空的
		cr.setcBeforeValue("");
		
		// 分别对各个属性插入变更记录
		cr.setcField("username");
		cr.setcAfterValue(uf.getUserName());
		crDao.insertChangeRecord(cr);
		
		cr.setcField("address");
		cr.setcAfterValue(uf.getAddress());
		crDao.insertChangeRecord(cr);
	}

	/**
	 * 分页查询出userfile列表
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
