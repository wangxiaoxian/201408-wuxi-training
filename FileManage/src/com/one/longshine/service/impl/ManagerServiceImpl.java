package com.one.longshine.service.impl;

import com.one.longshine.dao.ManagerDAO;
import com.one.longshine.dao.impl.ManagerDaoImp;
import com.one.longshine.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {

	private ManagerDAO mgrDao = new ManagerDaoImp();

	/**
	 * ҵ��Ա��½
	 */
	@Override
	public boolean login(String name, String password) {
		return mgrDao.login(name, password);
	}
}
