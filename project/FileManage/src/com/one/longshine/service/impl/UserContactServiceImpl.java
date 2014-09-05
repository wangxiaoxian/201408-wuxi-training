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
	 * ����ָ����ˮ�ŵ��û�����ϵ��Ϣ
	 */
	@Override
	public List<UserContactInfo> searchByUserSerialId(int uid) {
		List<UserContactInfo> list = new ArrayList<UserContactInfo>();
		UserContactDao ucd = new UserContactImpl();
		list = ucd.searchByUserSerialId(uid);
		return list;
	}

	/**
	 * ����ָ����ϵ��ˮ�ŵ���ϵ��Ϣ
	 */
	@Override
	public UserContactInfo searchByContactserialid(int fid) {
		UserContactInfo uci = new UserContactInfo();
		UserContactDao ucd = new UserContactImpl();
		uci = ucd.searchByContactSerialId(fid);
		return uci;
	}

	/**
	 * ����ָ����ϵ��ˮ�ŵ���ϵ�����Ϣ
	 */
	@Override
	public boolean updateContact(int cid, ChangeRecord cr) {
		// ��������
		UserContactDao ucd = new UserContactImpl();
		boolean b = ucd.updateContact(cid, cr.getcField(),
				cr.getcAfterValue());
		// ���Ӽ�¼
		ChangeRecordDao crd = new ChangeRecordDaoImpl();
		crd.insertChangeRecord(cr);
		return b;
	}
	/**
	 * ������ϵ��Ϣ
	 */
	@Override
	public boolean addContact(int uid, String type, String detail) {
		//��õ�ǰ���ݿ�����һ��ID
		UserContactDao ucd = new UserContactImpl();
		int nid = ucd.getNextId();
		
		//������ϵ��Ϣ
		UserFileInfo ufi = new UserFileInfo();
		ufi.setUserSerialId(uid);
		
		UserContactInfo uci = new UserContactInfo();
		uci.setUserFile(ufi);
		uci.setContactType(type);
		uci.setContactDetails(detail);
		uci.setContactSerialId(nid);
		boolean b = ucd.addUserContactInfo(uci);
		
		
		//�����¼
		ChangeRecord cr = new ChangeRecord();
		cr.setcAfterValue(type);
		cr.setcContent("����");
		cr.setcField("contacttype");
		cr.setcTable("user_contact_info");
		cr.setcTableSerialId(nid);
		cr.setHandler("admin");
		cr.setHandleTime(new Date());
		cr.setUserFile(ufi);
		cr.setcBeforeValue("��");
		cr.setcReason("����");
		ChangeRecordDao crd = new ChangeRecordDaoImpl();
		crd.insertChangeRecord(cr);
		
		
		ChangeRecord cr2 = new ChangeRecord();
		cr2.setcAfterValue(detail);
		cr2.setcContent("����");
		cr2.setcField("contactdetails");
		cr2.setcTable("user_contact_info");
		cr2.setcTableSerialId(nid);
		cr2.setHandler("admin");
		cr2.setHandleTime(new Date());
		cr2.setUserFile(ufi);
		cr2.setcBeforeValue("��");
		cr2.setcReason("����");
		crd.insertChangeRecord(cr2);
		return b;
	}

	/**
	 * ɾ����ϵ��Ϣ
	 */
	@Override
	public boolean delContact(int cid,int uid) {
		UserContactDao ucd = new UserContactImpl();
		boolean b = ucd.delUserContactInfo(cid);
		//�����¼
		ChangeRecord cr = new ChangeRecord();
		UserFileInfo ufi = new UserFileInfo();
		ufi.setUserSerialId(uid);
		cr.setcAfterValue("��");
		cr.setcContent("ɾ��");
		cr.setcField("��");
		cr.setcTable("user_contact_info");
		cr.setcTableSerialId(cid);
		cr.setHandler("admin");
		cr.setHandleTime(new Date());
		cr.setUserFile(ufi);
		cr.setcBeforeValue("��");
		cr.setcReason("ɾ��");
		ChangeRecordDao crd = new ChangeRecordDaoImpl();
		crd.insertChangeRecord(cr);
		return b;
	}

	/**
	 * ͨ����ϵ��ʽ�����ݲ�����ϵ��Ϣ
	 */
	@Override
	public boolean searchByTypeDetail(String type, String detail) {
		UserContactDao ucd = new UserContactImpl();
		return ucd.searchByTypeDetail(type, detail);
	}

}
