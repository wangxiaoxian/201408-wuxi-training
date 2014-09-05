package com.one.longshine.service;

import java.util.List;

import com.one.longshine.entity.ChangeRecord;
import com.one.longshine.entity.ChangeRecordFenye;

public interface ChangeRecordService {
	
	/**
	 * 查询用户的历史信息变更记录
	 * @param userId
	 * @return
	 */
	public List<ChangeRecord> getChangeRecords(String userId);
	
	/**
	 * 分页查询历史变更记录
	 * @param userId
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	ChangeRecordFenye getChangeRecords(String userId, int currPage,
			int pageSize);
	
	/**
	 * 添加档案变更记录
	 * @param cr
	 * @return
	 */
	public boolean LogOff(ChangeRecord cr,int userSerialId);

}
