package com.one.longshine.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 连接数据库
 */
public class DBLink {
	/**
	 * 得到连接
	 * @param driver
	 * @param url
	 * @param user
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static Connection getConn(String driver, String url,
			String user, String password) {
		
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	/**
	 * 得到连接
	 * @return
	 * @throws Exception
	 */
	public static Connection getConn() {
		String driver="oracle.jdbc.driver.OracleDriver"; 
		String url="jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
		String user="scott";
		String password="tiger";
		return getConn(driver, url, user, password);
	}
	
	
	/**
	 * 关闭连接
	 * @param conn
	 */
	public  static  void  closeConn(Connection conn){
		try{
			if(null!=conn) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
