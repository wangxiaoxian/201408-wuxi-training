package com.one.longshine.service.impl;

import java.util.List;

import com.one.longshine.dao.ChangeRecordDao;
import com.one.longshine.dao.UserFileDao;
import com.one.longshine.dao.impl.ChangeRecordDaoImpl;
import com.one.longshine.dao.impl.UserFileDaoImpl;
import com.one.longshine.entity.ChangeRecord;
import com.one.longshine.entity.ChangeRecordFenye;
import com.one.longshine.service.ChangeRecordService;

public class ChangeRecordServiceImpl implements ChangeRecordService {

	/**
	 * ��ѯ�û�����ʷ��Ϣ�����¼
	 */
	@Override
	public List<ChangeRecord> getChangeRecords(String userId) {
		ChangeRecordDao dao=new ChangeRecordDaoImpl();
		return dao.getChangeRecords(userId);
	}
	
	/**
	 * ��ӵ��������¼
	 */
	@Override
	public boolean LogOff(ChangeRecord cr,int userSerialId) {
		ChangeRecordDao recordDao=new ChangeRecordDaoImpl();
		return recordDao.LogOff(cr,userSerialId);
	}

	/**
	 * ��ҳ
	 * ��ѯ�û�����ʷ��Ϣ�����¼
	 */
	@Override
	public ChangeRecordFenye getChangeRecords(String userId, int currPage,
			int pageSize) {
			ChangeRecordDao dao=new ChangeRecordDaoImpl();
		return dao.getChangeRecords(userId, currPage, pageSize);
	}
	
	

	

}
