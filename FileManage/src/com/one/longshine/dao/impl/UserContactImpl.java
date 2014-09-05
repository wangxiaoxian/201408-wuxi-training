package com.one.longshine.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.one.longshine.dao.UserContactDao;
import com.one.longshine.dao.util.DBLink;
import com.one.longshine.entity.UserContactInfo;
import com.one.longshine.entity.UserFileInfo;
import com.one.longshine.entity.UserFinancalInfo;

public class UserContactImpl implements UserContactDao{
	
	/**
	 * 通过用户档案类增加用户联系信息
	 */
	@Override
	public boolean addUserContactInfo(UserContactInfo ufi) {
		String sql = "insert into user_contact_info values(?,?,?,?)";
		Connection conn = null;
		try {
			conn = DBLink.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ufi.getContactSerialId());
			ps.setInt(2, ufi.getUserFile().getUserSerialId());
			ps.setString(3,ufi.getContactType());
			ps.setString(4, ufi.getContactDetails());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		} finally {
			DBLink.closeConn(conn);
		}
	}
	/**
	 * 通过用户流水号查找用户联系信息
	 */
	@Override
	public List<UserContactInfo> searchByUserSerialId(int uid) {
		UserContactInfo uci;
		UserFileInfo ufi;
		String sql = "select * from user_contact_info where userserialid=?";
		List<UserContactInfo> list = new ArrayList<UserContactInfo>();
		Connection conn = null;
		try {
			conn = DBLink.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				uci = new UserContactInfo();
				ufi = new UserFileInfo();
				ufi.setUserSerialId(rs.getInt("userserialid"));
				uci.setUserFile(ufi);
				uci.setContactType(rs.getString("contacttype"));
				uci.setContactDetails(rs.getString("contactdetails"));
				uci.setContactSerialId(rs.getInt("contactserialid"));
				list.add(uci);
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
	 * 通过联系流水号查找联系信息
	 */
	@Override
	public UserContactInfo searchByContactSerialId(int cid) {
		UserContactInfo uci = new UserContactInfo();;
		UserFileInfo ufi;
		String sql = "select * from user_contact_info where contactserialid=?";
		Connection conn = null;
		try {
			conn = DBLink.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ufi = new UserFileInfo();
				ufi.setUserSerialId(rs.getInt("userserialid"));
				uci.setUserFile(ufi);
				uci.setContactType(rs.getString("contacttype"));
				uci.setContactDetails(rs.getString("contactdetails"));
				uci.setContactSerialId(rs.getInt("contactserialid"));
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
		return uci;
	}
	
	/**
	 * 更新用户账务信息
	 */
	@Override
	public boolean updateContact(int cid, String field, String value) {
		String sql = "update  user_contact_info set "+field+"=? where contactserialid=?";
		Connection conn = null;
		try {
			conn = DBLink.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, value);
			ps.setInt(2, cid);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		} finally {
			DBLink.closeConn(conn);
		}
	}
	
	/**
	 * 获取用户联系表的下一个ID
	 */
	@Override
	public int getNextId() {
		String sql = "select seq_ufi.nextval cid from dual";
		Connection conn = null;
		int cid = 0 ;
		try {
			conn = DBLink.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cid = rs.getInt("cid");
				return cid;
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
	 * 通过用户联系ID删除用户联系信息
	 */
	@Override
	public boolean delUserContactInfo(int cid) {
		String sql = "delete from user_contact_info where contactserialid=?";
		Connection conn = null;
		try {
			conn = DBLink.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		} finally {
			DBLink.closeConn(conn);
		}
	}
	
	/**
	 * 通过联系方式与联系内容查找联系信息
	 */
	@Override
	public boolean searchByTypeDetail(String type, String detail) {
		String sql = "select * from user_contact_info where contacttype=? and contactdetails=?";
		Connection conn = null;
		try {
			conn = DBLink.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, type);
			ps.setString(2, detail);
			return  ps.executeUpdate()>0;
		} catch (Exception e) {
			return false;
		} finally {
			DBLink.closeConn(conn);
		}
		
	}
}
