package com.one.longshine.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

import com.one.longshine.dao.ChangeRecordDao;
import com.one.longshine.dao.util.DBLink;
import com.one.longshine.entity.ChangeRecord;
import com.one.longshine.entity.ChangeRecordFenye;
import com.one.longshine.entity.UserFileInfo;

public class ChangeRecordDaoImpl implements ChangeRecordDao {

	/**
	 * ��������¼
	 */
	@Override
	public void insertChangeRecord(ChangeRecord cr) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into FILE_CHANGE_RECORD (CHANGESERIALID, "
					+ "CTABLE, "
					+ "CTABLESERIALID, "
					+ "USERSERIALID, "
					+ "CFIELD, "
					+ "CBEFOREVALUE, "
					+ "CAFTERVALUE, "
					+ "CREASON, "
					+ "CCONTENT, "
					+ "HANDLER, "
					+ "HANDLETIME "
					+ ") values (seq_fcr.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			conn = DBLink.getConn();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cr.getcTable());
			pstmt.setInt(2, cr.getUserFile().getUserSerialId());
			pstmt.setInt(3, cr.getUserFile().getUserSerialId());
			pstmt.setString(4, cr.getcField());
			pstmt.setString(5, cr.getcBeforeValue());
			pstmt.setString(6, cr.getcAfterValue());
			pstmt.setString(7, cr.getcReason());
			pstmt.setString(8, cr.getcContent());
			pstmt.setString(9, "admin");
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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
	 * ��ѯ�û�����ʷ��Ϣ�����¼
	 */
	@Override
	public List<ChangeRecord> getChangeRecords(String userId) {
		List<ChangeRecord> cRlist=new ArrayList<ChangeRecord>();
		Connection conn=null;
		String sql="select changeserialid,c.userserialid,ctableserialid,ctable,cfield,cbeforevalue "
				+ ",caftervalue,creason,ccontent,handler,handletime from file_change_record c,user_file_info f "
				+ " where c.userserialid=f.userserialid and f.userid like ? ";
		try {
			conn=DBLink.getConn();
			PreparedStatement pr=conn.prepareStatement(sql);
			pr.setString(1, "%"+userId+"%");
			ResultSet rs=pr.executeQuery();
			
			while (rs.next()) {
				ChangeRecord cRecord=new ChangeRecord();
				cRecord.setChangeSerialId(rs.getInt("changeserialid"));
				UserFileInfo  userFile=new UserFileInfo();
				userFile.setUserSerialId(rs.getInt("userserialid"));
				cRecord.setUserFile(userFile);
				cRecord.setcTableSerialId(rs.getInt("ctableserialid"));
				cRecord.setcTable(rs.getString("ctable"));
				cRecord.setcField(rs.getString("cfield"));
				cRecord.setcBeforeValue(rs.getString("cbeforevalue"));
				cRecord.setcAfterValue(rs.getString("caftervalue"));
				cRecord.setcReason(rs.getString("creason"));
				cRecord.setHandler(rs.getString("handler"));
				cRecord.setcContent(rs.getString("ccontent"));
				cRecord.setHandleTime(rs.getDate("handletime"));
				
				//��ӵ�list
				cRlist.add(cRecord);
				
			}
			System.out.println("toImp");
		} catch (Exception e) {
			System.out.println("��ѯ�û�����ʷ��Ϣ�����¼����"+e.getMessage());
	}finally{
		DBLink.closeConn(conn);
	}
		
		return cRlist;
	}

	/**
	 * ��ҳ
	 * ��ѯ�û�����ʷ��Ϣ�����¼
	 */
	@Override
	public ChangeRecordFenye getChangeRecords(String userId, int currPage,
			int pageSize) {
		System.out.println("dao:"+userId);
		ChangeRecordFenye fy=new ChangeRecordFenye();
		fy.setCurrPage(currPage);
		fy.setPageSize(pageSize);
		Connection conn=null;
		try{
			conn=DBLink.getConn();
			
			CallableStatement call=conn.prepareCall("{call changeRecord_fenye(?,?,?,?,?,?)}");
			OracleCallableStatement cs=(OracleCallableStatement)call;
			//�����������
			cs.setInt(1, currPage);
			cs.setInt(2, pageSize);
			cs.setString(3, userId);
			//�����������
			cs.registerOutParameter(4, OracleTypes.NUMBER);
			cs.registerOutParameter(5, OracleTypes.NUMBER);
			cs.registerOutParameter(6, OracleTypes.CURSOR);
			
			//ִ��
			cs.execute();
			
			//ȡֵ
			int pageCount=cs.getInt(4);
			int rowsCount=cs.getInt(5);
			ResultSet rs=cs.getCursor(6);
			
			//������ֵ
			fy.setPageCount(pageCount);
			fy.setRowsCount(rowsCount);
			List<ChangeRecord> list=new ArrayList<ChangeRecord>();
			
			//ѭ��ȡֵ
			while(rs.next()){
				ChangeRecord cRecord=new ChangeRecord();
				cRecord.setChangeSerialId(rs.getInt("changeserialid"));
				UserFileInfo  userFile=new UserFileInfo();
				userFile.setUserSerialId(rs.getInt("userserialid"));
				cRecord.setUserFile(userFile);
				cRecord.setcTableSerialId(rs.getInt("ctableserialid"));
				cRecord.setcTable(rs.getString("ctable"));
				cRecord.setcField(rs.getString("cfield"));
				cRecord.setcBeforeValue(rs.getString("cbeforevalue"));
				cRecord.setcAfterValue(rs.getString("caftervalue"));
				cRecord.setcReason(rs.getString("creason"));
				cRecord.setHandler(rs.getString("handler"));
				cRecord.setcContent(rs.getString("ccontent"));
				cRecord.setHandleTime(new Date(rs.getTimestamp("handletime").getTime()));
				list.add(cRecord);
			}
			
			fy.setChangeRecordlist(list);
			
			
		}catch(Exception e){
			System.out.println("��ҳ��ѯ������:"+e.getMessage());
		}finally{
			DBLink.closeConn(conn);
		}
		return fy;
	}
	
	/**
	 * ��ӵ��������¼
	 */
	@Override
	public boolean LogOff(ChangeRecord cr,int userSerialId) {
		Connection conn=null;
		String sql="insert into FILE_CHANGE_RECORD(changeserialid,ctable,"
				+ " ctableserialid,userserialid,cfield,cbeforevalue,caftervalue,"
				+ " creason,ccontent,handler,handletime) values(seq_fcr.nextval,?,?,?,?,?,?,?,?,?,sysdate)";
		
		String sql1="update USER_FILE_INFO set state='n',logoutdate=sysdate where userserialid=?";
		
		try {
			conn=DBLink.getConn();
			conn.setAutoCommit(false);
			PreparedStatement pr=conn.prepareStatement(sql);
			pr.setString(1, cr.getcTable());
			pr.setInt(2, cr.getcTableSerialId());
			pr.setInt(3, cr.getUserFile().getUserSerialId());
			pr.setString(4, cr.getcField());
			pr.setString(5, cr.getcBeforeValue());
			pr.setString(6, cr.getcAfterValue());
			pr.setString(7, cr.getcReason());
			pr.setString(8, cr.getcContent());
			pr.setString(9, cr.getHandler());
			int i=pr.executeUpdate();
			
			PreparedStatement pr1=conn.prepareStatement(sql1);
			pr1.setInt(1, userSerialId);
			int j=pr1.executeUpdate();
			
			conn.commit();
			
			return i==j;
			
			
		} catch (Exception e) {
			System.out.println("��ӵ�����¼����"+e.getMessage());
		}
		return false;
	}

}
