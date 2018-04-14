package com.mobi.dao.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * ���ݿ����Ӳ�����
 * @author zhangJ
 *
 */
public class DBConnection {
	public static Connection con=null;
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 */
	public static Connection getConneation() {
		Properties prop=new Properties();
		String driver=null;
		String url=null;
		String username=null;
		String password=null;
		try {
			prop.load(DBConnection.class.getResourceAsStream("jdbc.properties"));
			driver=prop.getProperty("DRIVER");
			url=prop.getProperty("URL");
			username = prop.getProperty("USER");
			password=prop.getProperty("PASSWD");
			try {
				Class.forName(driver);
				con=DriverManager.getConnection(url, username, password);
				
			} catch (ClassNotFoundException e) {
				//Can not found JDBC driver
				e.printStackTrace();
			}catch (SQLException e) {
				//can not get Conneation
				e.printStackTrace();
			}

		} catch (IOException e) {
			//not found jdbc.properties
			e.printStackTrace();
		}
		return con;
	}
	/**
	 * �ر����ݿ�����
	 * @param pstm
	 * @author zhangJ
	 */
	public static void freeConnection(PreparedStatement pstm) {
		if(pstm!=null) {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void freeConnection(Statement stmt, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
