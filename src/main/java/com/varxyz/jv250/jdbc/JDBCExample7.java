package com.varxyz.jv250.jdbc;

import java.sql.*;
/**
 * 
 * java에서 insert를 이용한 DB account table 정보 삽입하기
 * 
 * @author Administrator
 *
 */
public class JDBCExample7 {
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
			
			String sql = "INSERT INTO Account(accountNum, balance, interestRate, overdraft, accountType , customerId) " 
					 + "VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);	
			stmt.setString(1, "777-77-7777");
			stmt.setDouble(2, 23000.0);
			stmt.setDouble(3, 0.4);
			stmt.setDouble(4, 10000.0);
			stmt.setString(5, "S");
			stmt.setLong(6, 1011);
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
