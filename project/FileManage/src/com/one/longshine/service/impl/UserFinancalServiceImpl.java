package com.one.longshine.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.one.longshine.dao.ChangeRecordDao;
import com.one.longshine.dao.UserFinancalDao;
import com.one.longshine.dao.impl.ChangeRecordDaoImpl;
import com.one.longshine.dao.impl.UserFinancalImpl;
import com.one.longshine.entity.ChangeRecord;
import com.one.longshine.entity.UserFileInfo;
import com.one.longshine.entity.UserFinancalInfo;
import com.one.longshine.service.UserFinancalService;

public class UserFinancalServiceImpl implements UserFinancalService{
	private 	UserFinancalInfo ufn = new UserFinancalInfo();
	private 	UserFinancalDao ufnd = new UserFinancalImpl();
	/**
	 * 查找指定流水号的用户的账务信息
	 */
	@Override
	public List<UserFinancalInfo> searchByUserSerialId(int userSerialId) {
		List<UserFinancalInfo> list = new ArrayList<UserFinancalInfo>();
		list = ufnd.searchByUserSerialId(userSerialId);
		return list;
	}
	/**
	 * 查找指定账务流水号的账务信息
	 */
	@Override
	public UserFinancalInfo searchByFinancalserialid(int financalserialid) {
		return ufnd.searchByFinancalSerialId(financalserialid);
	}
	
	/**
	 * 更新指定账务流水号的账务的相关信息
	 */
	@Override
	public boolean updateFinancal(int ufnid,
			ChangeRecord cr) {
		//更新账务
		return ufnd.updateFinancal(ufnid,cr.getcField(), cr.getcAfterValue(),cr);
	}
	
	/**
	 * 增加账务信息
	 */
	@Override
	public boolean addFinancal(int uid, String bank, String account) {
		//获得当前数据库表的下一个ID
		int fid = ufnd.getNextId();
		//插入联系信息
		
		UserFileInfo ufi = new UserFileInfo();
		ufi.setUserSerialId(uid);
		
		ufn.setUserFile(ufi);
		ufn.setOpeningBank(bank);
		ufn.setAccount(account);
		ufn.setFinancalSerialId(fid);
		boolean b = ufnd.addUserFinancalInfo(ufn);
				
				
		//插入记录
		ChangeRecord cr = new ChangeRecord();
		cr.setcAfterValue(bank);
		cr.setcContent("新增");
		cr.setcField("openingbank");
		cr.setcTable("user_financal_info");
		cr.setcTableSerialId(fid);
		cr.setHandler("admin");
		cr.setHandleTime(new Date());
		cr.setUserFile(ufi);
		cr.setcBeforeValue("无");
		cr.setcReason("新增");
		ChangeRecordDao crd = new ChangeRecordDaoImpl();
		crd.insertChangeRecord(cr);
		
		
		ChangeRecord cr2 = new ChangeRecord();
		cr2.setcAfterValue(account);
		cr2.setcContent("新增");
		cr2.setcField("account");
		cr2.setcTable("user_financal_info");
		cr2.setcTableSerialId(fid);
		cr2.setHandler("admin");
		cr2.setHandleTime(new Date());
		cr2.setUserFile(ufi);
		cr2.setcBeforeValue("无");
		cr2.setcReason("新增");
		crd.insertChangeRecord(cr2);
		if(b){
			return true;
		}
		return false;
	}
	/**
	 * 删除账务信息
	 */
	@Override
	public boolean delFinancal(int uid, int fid) {
		boolean b = ufnd.delUserFinancalInfo(fid);
		if(b){
			//插入记录
			ChangeRecord cr = new ChangeRecord();
			UserFileInfo ufi = new UserFileInfo();
			ufi.setUserSerialId(uid);
			
			cr.setcAfterValue("无");
			cr.setcContent("删除");
			cr.setcField("无");
			cr.setcTable("user_financal_info");
			cr.setcTableSerialId(fid);
			cr.setHandler("admin");
			cr.setHandleTime(new Date());
			cr.setUserFile(ufi);
			cr.setcBeforeValue("无");
			cr.setcReason("删除");
			ChangeRecordDao crd = new ChangeRecordDaoImpl();
			crd.insertChangeRecord(cr);
			return true;
		}
		else{
			return false;
	}
}
	/**
	 * 通过开户行与账号查找账务信息
	 */
	@Override
	public boolean searchByBankAccount(String bank, String account) {
		return ufnd.searchByBankAccount(bank, account);
	}
}
