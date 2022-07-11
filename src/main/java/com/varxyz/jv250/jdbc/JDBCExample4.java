package com.varxyz.jv250.jdbc;

import java.sql.*;
/**
 * 
 * java를 이용한 DB Customer table에 update 기능 사용
 * 
 * @author Administrator
 *
 */
public class JDBCExample4 {
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
			
			String sql = "UPDATE Customer SET phone=?, customerId=? WHERE cid=?";
			PreparedStatement stmt = con.prepareStatement(sql);	
			stmt.setString(1, "010-3490-3180");
			stmt.setString(2, "mysql");
			stmt.setLong(3, 1008);
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
