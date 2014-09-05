package com.one.longshine.dao;

import java.util.List;

import com.one.longshine.entity.ChangeRecord;
import com.one.longshine.entity.ChangeRecordFenye;

public interface ChangeRecordDao {

	void insertChangeRecord(ChangeRecord cr);
	
	/**
	 * 查询用户的历史信息变更记录
	 * @param userId
	 * @return
	 */
	List<ChangeRecord> getChangeRecords(String userId);
	
	/**分页查询*/
	ChangeRecordFenye  getChangeRecords(String userId,int currPage,int pageSize);
	
	/**
	 * 添加档案变更记录
	 * @param cr
	 * @return
	 */
	boolean LogOff(ChangeRecord cr,int userSerialId);
	
	
//	/**
//	 * 增加变更记录
//	 * hjm
//	 */
//	boolean addChangeRecord(ChangeRecord cr);

}
