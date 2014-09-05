package com.one.longshine.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.one.longshine.dao.UserFinancalDao;
import com.one.longshine.dao.util.DBLink;
import com.one.longshine.entity.ChangeRecord;
import com.one.longshine.entity.UserFileInfo;
import com.one.longshine.entity.UserFinancalInfo;

public class UserFinancalImpl implements UserFinancalDao{
	
	/**
	 * 通过用户流水号查找用户账务信息
	 */
	@Override
	public List<UserFinancalInfo> searchByUserSerialId(int userSerialId) {
		UserFinancalInfo ufn;
		UserFileInfo ufi;
		String sql = "select * from user_financal_info where userserialid=?";
		List<UserFinancalInfo> list = new ArrayList<UserFinancalInfo>();
		Connection conn = null;
		try {
			conn = DBLink.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userSerialId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ufn = new UserFinancalInfo();
				ufi = new UserFileInfo();
				ufi.setUserSerialId(rs.getInt("userserialid"));
				ufn.setUserFile(ufi);
				ufn.setFinancalSerialId(rs.getInt("financalserialid"));
				ufn.setAccount(rs.getString("account"));
				ufn.setOpeningBank(rs.getString("openingbank"));
				list.add(ufn);
			}

			if (null != ps)
				ps.close();
			if (null != rs)
				rs.close();

		} catch (Exception e) {
			return null;
		} finally {
			DBLink.closeConn(conn);
		}

		return list;
		
		
	}
	
	
	
	/**
	 * 通过账务流水号查找用户账务信息
	 */
	@Override
	public UserFinancalInfo searchByFinancalSerialId(int financalSerialId) {
		
		UserFinancalInfo ufn = new UserFinancalInfo();;
		UserFileInfo ufi;
		String sql = "select * from user_financal_info where financalserialid=?";
		Connection conn = null;
		try {
			conn = DBLink.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, financalSerialId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ufi = new UserFileInfo();
				ufi.setUserSerialId(rs.getInt("userserialid"));
				ufn.setUserFile(ufi);
				ufn.setFinancalSerialId(rs.getInt("financalserialid"));
				ufn.setAccount(rs.getString("account"));
				ufn.setOpeningBank(rs.getString("openingbank"));
			}

			if (null != ps)
				ps.close();
			if (null != rs)
				rs.close();

		} catch (Exception e) {
			return null;
		} finally {
			DBLink.closeConn(conn);
		}

		return ufn;
	}

	/**
	 * 更新用户账务信息
	 */
	@Override
	public boolean updateFinancal(int fid,String field,String value,ChangeRecord cr) {
		String sql = "update  user_financal_info set "+field+"=? where financalserialid=?";
		Connection conn = null;
		
		String sql2="insert into file_change_record(changeserialid,ctable,"
				+ " ctableserialid,userserialid,cfield,cbeforevalue,caftervalue,"
				+ " creason,ccontent,handler,handletime) values(seq_fcr.nextval,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn=DBLink.getConn();
			conn.setAutoCommit(false);
			PreparedStatement ps=conn.prepareStatement(sql2);
			ps.setString(1, cr.getcTable());
			ps.setInt(2, cr.getcTableSerialId());
			ps.setInt(3, cr.getUserFile().getUserSerialId());
			ps.setString(4, cr.getcField());
			ps.setString(5, cr.getcBeforeValue());
			ps.setString(6, cr.getcAfterValue());
			ps.setString(7, cr.getcReason());
			ps.setString(8, cr.getcContent());
			ps.setString(9, cr.getHandler());
			ps.setDate(10, new java.sql.Date(cr.getHandleTime().getTime()));
			
			PreparedStatement p = conn.prepareStatement(sql);
			p.setString(1, value);
			p.setInt(2, fid);
			int i = p.executeUpdate();
			int i2=ps.executeUpdate();
			conn.commit();
			return (i>0&&i2>0);
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				return false;
			}
			return false;
		} finally {
			DBLink.closeConn(conn);
		}
		
	}

	/**
	 * 通过账务类增加账务信息
	 */
	@Override
	public boolean addUserFinancalInfo(UserFinancalInfo ufn) {
		String sql = "insert into user_financal_info values(?,?,?,?)";
		Connection conn = null;
		try {
			conn = DBLink.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ufn.getFinancalSerialId());
			ps.setInt(2, ufn.getUserFile().getUserSerialId());
			ps.setString(3,ufn.getOpeningBank());
			ps.setString(4, ufn.getAccount());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		} finally {
			DBLink.closeConn(conn);
		}
	}


	/**
	 * 获取下一个ID
	 */
	@Override
	public int getNextId() {
		String sql = "select seq_ufni.nextval id from dual";
		Connection conn = null;
		int id = 0 ;
		try {
			conn = DBLink.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt("id");
				return id;
			}

			if (null != ps)
				ps.close();
			if (null != rs)
				rs.close();;
		} catch (Exception e) {
			return 0;
		} finally {
			DBLink.closeConn(conn);
		}

		return 0;
	}


	/**
	 * 通过用户账务ID删除用户账务信息
	 */
	@Override
	public boolean delUserFinancalInfo(int fid) {
		String sql = "delete from user_financal_info where financalserialid=?";
		Connection conn = null;
		try {
			conn = DBLink.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, fid);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		} finally {
			DBLink.closeConn(conn);
		}
	}


	/**
	 * 通过开户行与账号查找账务信息
	 */
	@Override
	public boolean searchByBankAccount(String bank, String account) {
		String sql = "select * from user_financal_info where openingbank=? and account=?";
		Connection conn = null;
		try {
			conn = DBLink.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bank);
			ps.setString(2, account);
			return  ps.executeUpdate()>0;
		} catch (Exception e) {
			return false;
		} finally {
			DBLink.closeConn(conn);
		}
	}

}
