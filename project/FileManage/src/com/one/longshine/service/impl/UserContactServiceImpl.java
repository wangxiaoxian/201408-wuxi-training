package com.one.longshine.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.one.longshine.dao.ChangeRecordDao;
import com.one.longshine.dao.UserContactDao;
import com.one.longshine.dao.impl.ChangeRecordDaoImpl;
import com.one.longshine.dao.impl.UserContactImpl;
import com.one.longshine.entity.ChangeRecord;
import com.one.longshine.entity.UserContactInfo;
import com.one.longshine.entity.UserFileInfo;
import com.one.longshine.service.UserContactService;

public class UserContactServiceImpl implements UserContactService {

	/**
	 * 查找指定流水号的用户的联系信息
	 */
	@Override
	public List<UserContactInfo> searchByUserSerialId(int uid) {
		List<UserContactInfo> list = new ArrayList<UserContactInfo>();
		UserContactDao ucd = new UserContactImpl();
		list = ucd.searchByUserSerialId(uid);
		return list;
	}

	/**
	 * 查找指定联系流水号的联系信息
	 */
	@Override
	public UserContactInfo searchByContactserialid(int fid) {
		UserContactInfo uci = new UserContactInfo();
		UserContactDao ucd = new UserContactImpl();
		uci = ucd.searchByContactSerialId(fid);
		return uci;
	}

	/**
	 * 更新指定联系流水号的联系相关信息
	 */
	@Override
	public boolean updateContact(int cid, ChangeRecord cr) {
		// 更新账务
		UserContactDao ucd = new UserContactImpl();
		boolean b = ucd.updateContact(cid, cr.getcField(),
				cr.getcAfterValue());
		// 增加记录
		ChangeRecordDao crd = new ChangeRecordDaoImpl();
		crd.insertChangeRecord(cr);
		return b;
	}
	/**
	 * 增加联系信息
	 */
	@Override
	public boolean addContact(int uid, String type, String detail) {
		//获得当前数据库表的下一个ID
		UserContactDao ucd = new UserContactImpl();
		int nid = ucd.getNextId();
		
		//插入联系信息
		UserFileInfo ufi = new UserFileInfo();
		ufi.setUserSerialId(uid);
		
		UserContactInfo uci = new UserContactInfo();
		uci.setUserFile(ufi);
		uci.setContactType(type);
		uci.setContactDetails(detail);
		uci.setContactSerialId(nid);
		boolean b = ucd.addUserContactInfo(uci);
		
		
		//插入记录
		ChangeRecord cr = new ChangeRecord();
		cr.setcAfterValue(type);
		cr.setcContent("新增");
		cr.setcField("contacttype");
		cr.setcTable("user_contact_info");
		cr.setcTableSerialId(nid);
		cr.setHandler("admin");
		cr.setHandleTime(new Date());
		cr.setUserFile(ufi);
		cr.setcBeforeValue("无");
		cr.setcReason("新增");
		ChangeRecordDao crd = new ChangeRecordDaoImpl();
		crd.insertChangeRecord(cr);
		
		
		ChangeRecord cr2 = new ChangeRecord();
		cr2.setcAfterValue(detail);
		cr2.setcContent("新增");
		cr2.setcField("contactdetails");
		cr2.setcTable("user_contact_info");
		cr2.setcTableSerialId(nid);
		cr2.setHandler("admin");
		cr2.setHandleTime(new Date());
		cr2.setUserFile(ufi);
		cr2.setcBeforeValue("无");
		cr2.setcReason("新增");
		crd.insertChangeRecord(cr2);
		return b;
	}

	/**
	 * 删除联系信息
	 */
	@Override
	public boolean delContact(int cid,int uid) {
		UserContactDao ucd = new UserContactImpl();
		boolean b = ucd.delUserContactInfo(cid);
		//插入记录
		ChangeRecord cr = new ChangeRecord();
		UserFileInfo ufi = new UserFileInfo();
		ufi.setUserSerialId(uid);
		cr.setcAfterValue("无");
		cr.setcContent("删除");
		cr.setcField("无");
		cr.setcTable("user_contact_info");
		cr.setcTableSerialId(cid);
		cr.setHandler("admin");
		cr.setHandleTime(new Date());
		cr.setUserFile(ufi);
		cr.setcBeforeValue("无");
		cr.setcReason("删除");
		ChangeRecordDao crd = new ChangeRecordDaoImpl();
		crd.insertChangeRecord(cr);
		return b;
	}

	/**
	 * 通过联系方式与内容查找联系信息
	 */
	@Override
	public boolean searchByTypeDetail(String type, String detail) {
		UserContactDao ucd = new UserContactImpl();
		return ucd.searchByTypeDetail(type, detail);
	}

}
