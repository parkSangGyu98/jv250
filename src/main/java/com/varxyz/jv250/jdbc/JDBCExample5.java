package com.varxyz.jv250.jdbc;

import java.sql.*;
/**
 * 
 * java를 이용한 DB Customer table에 delete 기능 사용
 * 
 * @author Administrator
 *
 */
public class JDBCExample5 {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
		String id = "jv250";
		String passwd = "jv250";
		
		try {
			Class.forName(driver);
			System.out.println("LOADED DRIVER ---> " + driver);
			
			Connection con = DriverManager.getConnection(url, id, passwd);
			System.out.println("CONNECTED TO ---> " + url);
			
			String sql = "DELETE FROM Customer WHERE cid = 1008";
			PreparedStatement stmt = con.prepareStatement(sql);	
			stmt.executeUpdate();
			
			System.out.println("DELETED...");
			stmt.close();
			con.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
