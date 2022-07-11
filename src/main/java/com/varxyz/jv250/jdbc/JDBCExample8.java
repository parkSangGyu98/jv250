package com.varxyz.jv250.jdbc;

import java.sql.*;
/**
 * 
 * java에서 update를 이용한 DB account table 정보 업데이트하기
 * 
 * @author Administrator
 *
 */
public class JDBCExample8 {
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
			
			String sql = "UPDATE Account SET overdraft=?, balance=? WHERE aid=?";
			PreparedStatement stmt = con.prepareStatement(sql);	
			stmt.setDouble(1, 10000.0);
			stmt.setDouble(2, 44444.1);
			stmt.setLong(3, 3006);
			stmt.executeUpdate();
			
			System.out.println("UPDATED...");
			stmt.close();
			con.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
