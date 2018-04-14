package com.login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mobi.dao.util.*;
public class LoginTest {
	public static void main(String[] args) {
		String sql="select * from t_sys_user where t_sys_user.\"id\"=?";
		Connection con = DBConnection.getConneation();
		 PreparedStatement pstmt=null;
         ResultSet rs =null;
         try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "1");
			rs=pstmt.executeQuery();
			 while(rs.next()){
                 String name = rs.getString("name");
                 System.out.println(name);
           }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
}
