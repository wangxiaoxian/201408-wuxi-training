package com.one.longshine.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.one.longshine.dao.ManagerDAO;
import com.one.longshine.dao.util.DBLink;



public class ManagerDaoImp implements ManagerDAO{

	/**
	 * ÒµÎñÔ±µÇÂ½
	 */
	@Override
	public boolean login(String uaserName, String password) {
	
		Connection connection=null;
		String  sql="select * from Manager where username=? and password=?";
		try {
			connection = DBLink.getConn();
			PreparedStatement pr = connection.prepareStatement(sql);
			
			pr.setString(1, uaserName);
			pr.setString(2, password);
			
			ResultSet rs=pr.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
			DBLink.closeConn(connection);
		}
		return false;
	}

}

