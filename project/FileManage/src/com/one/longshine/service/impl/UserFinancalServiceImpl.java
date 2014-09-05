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
	 * ����ָ����ˮ�ŵ��û���������Ϣ
	 */
	@Override
	public List<UserFinancalInfo> searchByUserSerialId(int userSerialId) {
		List<UserFinancalInfo> list = new ArrayList<UserFinancalInfo>();
		list = ufnd.searchByUserSerialId(userSerialId);
		return list;
	}
	/**
	 * ����ָ��������ˮ�ŵ�������Ϣ
	 */
	@Override
	public UserFinancalInfo searchByFinancalserialid(int financalserialid) {
		return ufnd.searchByFinancalSerialId(financalserialid);
	}
	
	/**
	 * ����ָ��������ˮ�ŵ�����������Ϣ
	 */
	@Override
	public boolean updateFinancal(int ufnid,
			ChangeRecord cr) {
		//��������
		return ufnd.updateFinancal(ufnid,cr.getcField(), cr.getcAfterValue(),cr);
	}
	
	/**
	 * ����������Ϣ
	 */
	@Override
	public boolean addFinancal(int uid, String bank, String account) {
		//��õ�ǰ���ݿ�����һ��ID
		int fid = ufnd.getNextId();
		//������ϵ��Ϣ
		
		UserFileInfo ufi = new UserFileInfo();
		ufi.setUserSerialId(uid);
		
		ufn.setUserFile(ufi);
		ufn.setOpeningBank(bank);
		ufn.setAccount(account);
		ufn.setFinancalSerialId(fid);
		boolean b = ufnd.addUserFinancalInfo(ufn);
				
				
		//�����¼
		ChangeRecord cr = new ChangeRecord();
		cr.setcAfterValue(bank);
		cr.setcContent("����");
		cr.setcField("openingbank");
		cr.setcTable("user_financal_info");
		cr.setcTableSerialId(fid);
		cr.setHandler("admin");
		cr.setHandleTime(new Date());
		cr.setUserFile(ufi);
		cr.setcBeforeValue("��");
		cr.setcReason("����");
		ChangeRecordDao crd = new ChangeRecordDaoImpl();
		crd.insertChangeRecord(cr);
		
		
		ChangeRecord cr2 = new ChangeRecord();
		cr2.setcAfterValue(account);
		cr2.setcContent("����");
		cr2.setcField("account");
		cr2.setcTable("user_financal_info");
		cr2.setcTableSerialId(fid);
		cr2.setHandler("admin");
		cr2.setHandleTime(new Date());
		cr2.setUserFile(ufi);
		cr2.setcBeforeValue("��");
		cr2.setcReason("����");
		crd.insertChangeRecord(cr2);
		if(b){
			return true;
		}
		return false;
	}
	/**
	 * ɾ��������Ϣ
	 */
	@Override
	public boolean delFinancal(int uid, int fid) {
		boolean b = ufnd.delUserFinancalInfo(fid);
		if(b){
			//�����¼
			ChangeRecord cr = new ChangeRecord();
			UserFileInfo ufi = new UserFileInfo();
			ufi.setUserSerialId(uid);
			
			cr.setcAfterValue("��");
			cr.setcContent("ɾ��");
			cr.setcField("��");
			cr.setcTable("user_financal_info");
			cr.setcTableSerialId(fid);
			cr.setHandler("admin");
			cr.setHandleTime(new Date());
			cr.setUserFile(ufi);
			cr.setcBeforeValue("��");
			cr.setcReason("ɾ��");
			ChangeRecordDao crd = new ChangeRecordDaoImpl();
			crd.insertChangeRecord(cr);
			return true;
		}
		else{
			return false;
	}
}
	/**
	 * ͨ�����������˺Ų���������Ϣ
	 */
	@Override
	public boolean searchByBankAccount(String bank, String account) {
		return ufnd.searchByBankAccount(bank, account);
	}
}
