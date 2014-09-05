package com.one.longshine.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.one.longshine.dao.UserFileDao;
import com.one.longshine.dao.util.DBLink;
import com.one.longshine.entity.PagerModel;
import com.one.longshine.entity.UserFileInfo;
import com.one.longshine.form.SearchFileForm;

public class UserFileDaoImpl implements UserFileDao {

	/**
	 * 获取所有的用户档案
	 */
	@Override
	public List<UserFileInfo> getAllUserFile() {
		List<UserFileInfo> ufis = new ArrayList<UserFileInfo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			String getDatasSql = "select "
					+ "USERSERIALID, "
					+ "USERID, "
					+ "USERNAME, "
					+ "CREATEDATE, "
					+ "ADDRESS, "
					+ "STATE, "
					+ "LOGOUTDATE "
					+ "from USER_FILE_INFO "
					+ "order by USERSERIALID";
			
			conn = DBLink.getConn();
			pstmt = conn.prepareStatement(getDatasSql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				UserFileInfo ufi = new UserFileInfo();
				ufi.setUserSerialId(rs.getInt("USERSERIALID"));;
				ufi.setUserId(rs.getString("USERID"));
				ufi.setUserName(rs.getString("USERNAME"));
				ufi.setCreateDate(new Date(rs.getTimestamp("CREATEDATE").getTime()));
				ufi.setAddress(rs.getString("ADDRESS"));
				ufi.setState(rs.getString("STATE"));
				if (rs.getTimestamp("LOGOUTDATE") != null) {
					ufi.setLogoutDate(new Date(rs.getTimestamp("LOGOUTDATE").getTime()));
				}
				ufis.add(ufi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ufis;
	}

	/**
	 * 按照sid获取指定的用户档案
	 */
	@Override
	public UserFileInfo getUserFile(int sid) {
		UserFileInfo ufi = new UserFileInfo();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			String getDatasSql = "select "
					+ "USERSERIALID, "
					+ "USERID, "
					+ "USERNAME, "
					+ "CREATEDATE, "
					+ "ADDRESS, "
					+ "STATE, "
					+ "LOGOUTDATE "
					+ "from USER_FILE_INFO "
					+ "where USERSERIALID=?";
			
			conn = DBLink.getConn();
			pstmt = conn.prepareStatement(getDatasSql);
			
			pstmt.setInt(1, sid);
			rs = pstmt.executeQuery();
			
			rs.next();
			ufi.setUserSerialId(rs.getInt("USERSERIALID"));;
			ufi.setUserId(rs.getString("USERID"));
			ufi.setUserName(rs.getString("USERNAME"));
			ufi.setCreateDate(new Date(rs.getTimestamp("CREATEDATE").getTime()));
			ufi.setAddress(rs.getString("ADDRESS"));
			ufi.setState(rs.getString("STATE"));
			if (rs.getTimestamp("LOGOUTDATE") != null) {
				ufi.setLogoutDate(new Date(rs.getTimestamp("LOGOUTDATE").getTime()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ufi;
	}

	/**
	 * 更新用户档案
	 */
	@Override
	public void updateUserFile(String field, UserFileInfo uf) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBLink.getConn();
			
			String sql = "";
			// 判断要对哪个列进行修改
			if ("username".equals(field.toLowerCase())) {
				sql = "update USER_FILE_INFO set "
						+ "USERNAME=? "
						+ "where USERSERIALID=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, uf.getUserName());
				pstmt.setInt(2, uf.getUserSerialId());
				
			} else if ("address".equals(field.toLowerCase())) {
				sql = "update USER_FILE_INFO set "
						+ "ADDRESS=? "
						+ "where USERSERIALID=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, uf.getAddress());
				pstmt.setInt(2, uf.getUserSerialId());
				
			} else {
				sql = "update USER_FILE_INFO set "
						+ "STATE=?,"
						+ "LOGOUTDATE=? "
						+ "where USERSERIALID=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, uf.getState());
				pstmt.setDate(2, new java.sql.Date(new Date().getTime()));
				pstmt.setInt(3, uf.getUserSerialId());
			}
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 插入用户档案
	 */
	@Override
	public int insertUserFile(UserFileInfo uf) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sid = "";
		try {
			conn = DBLink.getConn();
			
			// 先获取序列的值，以便下面拼凑用户编号userid
			String getSeq = "select seq_ufi.nextval sid from dual";
			pstmt  = conn.prepareStatement(getSeq);
			rs = pstmt.executeQuery();
			rs.next();
			sid = rs.getString(1);
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			
			// 将获取的序列值插入流水号，并将拼凑好的用户编号userid插入
			String sql = "insert into USER_FILE_INFO ("
					+ "USERSERIALID,"
					+ "USERID,"
					+ "USERNAME,"
					+ "CREATEDATE,"
					+ "ADDRESS,"
					+ "STATE"
					+ ") values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(sid));
			
			String num = new SimpleDateFormat("MMdd").format(new Date()) 
					+ String.format("%05d", Integer.parseInt(sid));
			pstmt.setString(2, num);
			pstmt.setString(3, uf.getUserName());
			pstmt.setTimestamp(4, new Timestamp(new Date().getTime()));
			pstmt.setString(5, uf.getAddress());
			pstmt.setString(6, uf.getState());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return Integer.parseInt(sid);
	}

	/**
	 * 分页获取用户档案列表
	 */
	@Override
	public PagerModel<UserFileInfo> getPagedUserFile(SearchFileForm sff, int recordNo,
			int pageSize) {
		PagerModel<UserFileInfo> ufPager = new PagerModel<UserFileInfo>();
		List<UserFileInfo> ufis = new ArrayList<UserFileInfo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 组合查询，拼接where查询条件
		StringBuffer whereSql = new StringBuffer("where 1=1 ");
		if (!"".equals(sff.getUserId())) {
			whereSql.append(" and userid like '%").append(sff.getUserId()).append("%' ");
		} else if (!"".equals(sff.getUserName())) {
			whereSql.append(" and username like '%").append(sff.getUserName()).append("%' ");
		}
		try {
			
			String getDatasSql = "SELECT * FROM "
							+ "(SELECT ROW_.*, ROWNUM ROWNUM_ FROM "
							+ "(select "
							+ "USERSERIALID, "
							+ "USERID, "
							+ "USERNAME, "
							+ "CREATEDATE, "
							+ "ADDRESS, "
							+ "STATE, "
							+ "LOGOUTDATE "
							+ "from USER_FILE_INFO "
							+ whereSql.toString()
							+ "order by USERSERIALID "
							+ ") ROW_ "
							+ "WHERE ROWNUM <= ?) "
							+ "WHERE ROWNUM_ >= ?";
			
			conn = DBLink.getConn();
			pstmt = conn.prepareStatement(getDatasSql);
			
			pstmt.setInt(1, recordNo + pageSize - 1);
			pstmt.setInt(2, recordNo);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				UserFileInfo ufi = new UserFileInfo();
				ufi.setUserSerialId(rs.getInt("USERSERIALID"));;
				ufi.setUserId(rs.getString("USERID"));
				ufi.setUserName(rs.getString("USERNAME"));
				ufi.setCreateDate(new Date(rs.getTimestamp("CREATEDATE").getTime()));
				ufi.setAddress(rs.getString("ADDRESS"));
				ufi.setState(rs.getString("STATE"));
				if (rs.getTimestamp("LOGOUTDATE") != null) {
					ufi.setLogoutDate(new Date(rs.getTimestamp("LOGOUTDATE").getTime()));
				}
				ufis.add(ufi);
			}
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			
			// 获取总记录数
			pstmt = conn.prepareStatement("select count(*) ct from USER_FILE_INFO " + whereSql);
			
			rs = pstmt.executeQuery();
			rs.next();
			int count = rs.getInt("ct");
			
			ufPager.setDatas(ufis);
			ufPager.setPageSize(pageSize);
			ufPager.setRecodeNo(recordNo);
			ufPager.setRowsCount(count);
			ufPager.setPageCount(count%pageSize == 0 ? count/pageSize : count/pageSize+1);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ufPager;
	}
	
	
	/**
	 * 根据用户档案流水号，获取一个用户档案对象
	 */
	@Override
	public UserFileInfo searchByUserSerialId(int userSerialId) {
		UserFileInfo ufi = new UserFileInfo();
		String sql = "select * from user_file_info where USERSERIALID=?";
		Connection conn = null;
		try {
			conn = DBLink.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userSerialId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ufi.setUserSerialId(rs.getInt("userserialid"));
				ufi.setUserId(rs.getString("userid"));
				ufi.setUserName(rs.getString("username"));
				ufi.setAddress(rs.getString("address"));
			}

			if (null != ps)
				ps.close();
			if (null != rs)
				rs.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询指定流水号的用户信息出错！");
		} finally {
			DBLink.closeConn(conn);
		}
		return ufi;
	}
}
