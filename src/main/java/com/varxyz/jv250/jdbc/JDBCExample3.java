package com.varxyz.jv250.jdbc;

import java.sql.*;
/**
 * 
 * java를 이용한 DB Customer table에 insert 기능 사용
 * 
 * @author Administrator
 *
 */
public class JDBCExample3 {
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
			
			String sql = "INSERT INTO Customer(name, ssn, phone, customerId, passwd) " 
						 + "VALUES(?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);	
			stmt.setString(1, "조조");
			stmt.setString(2, "980618-1234567");
			stmt.setString(3, "010-3490-3180");
			stmt.setString(4, "sql");
			stmt.setString(5, "1111");
			stmt.executeUpdate();
			
			System.out.println("INSERTED...");
			stmt.close();
			con.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
