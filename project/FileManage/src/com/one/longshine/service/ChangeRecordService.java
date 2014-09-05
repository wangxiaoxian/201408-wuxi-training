package com.one.longshine.service;

import java.util.List;

import com.one.longshine.entity.ChangeRecord;
import com.one.longshine.entity.ChangeRecordFenye;

public interface ChangeRecordService {
	
	/**
	 * ��ѯ�û�����ʷ��Ϣ�����¼
	 * @param userId
	 * @return
	 */
	public List<ChangeRecord> getChangeRecords(String userId);
	
	/**
	 * ��ҳ��ѯ��ʷ�����¼
	 * @param userId
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	ChangeRecordFenye getChangeRecords(String userId, int currPage,
			int pageSize);
	
	/**
	 * ��ӵ��������¼
	 * @param cr
	 * @return
	 */
	public boolean LogOff(ChangeRecord cr,int userSerialId);

}
