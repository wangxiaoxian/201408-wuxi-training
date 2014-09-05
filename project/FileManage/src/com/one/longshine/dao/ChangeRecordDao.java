package com.one.longshine.dao;

import java.util.List;

import com.one.longshine.entity.ChangeRecord;
import com.one.longshine.entity.ChangeRecordFenye;

public interface ChangeRecordDao {

	void insertChangeRecord(ChangeRecord cr);
	
	/**
	 * ��ѯ�û�����ʷ��Ϣ�����¼
	 * @param userId
	 * @return
	 */
	List<ChangeRecord> getChangeRecords(String userId);
	
	/**��ҳ��ѯ*/
	ChangeRecordFenye  getChangeRecords(String userId,int currPage,int pageSize);
	
	/**
	 * ��ӵ��������¼
	 * @param cr
	 * @return
	 */
	boolean LogOff(ChangeRecord cr,int userSerialId);
	
	
//	/**
//	 * ���ӱ����¼
//	 * hjm
//	 */
//	boolean addChangeRecord(ChangeRecord cr);

}
