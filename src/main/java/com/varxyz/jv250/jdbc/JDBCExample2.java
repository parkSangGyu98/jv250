package com.varxyz.jv250.jdbc;

import java.sql.*;
/**
 * PreparedStatement 사용하여 JDBCExample class와 같은 결과 도출
 * 
 * @author Administrator
 *
 */
public class JDBCExample2 {
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
			
			String sql = "SELECT * FROM Customer WHERE name = ?";
			PreparedStatement stmt = con.prepareStatement(sql);	
			stmt.setString(1, "유비");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				long cid = rs.getLong("cid");
				String customerId = rs.getString("customerId");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				System.out.println(cid);
				System.out.println(customerId);
				System.out.println(name);
				System.out.println(phone);
				System.out.println("--------------------------------");
			}
			stmt.close();
			con.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
	}
}
