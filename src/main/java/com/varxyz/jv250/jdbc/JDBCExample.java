package com.varxyz.jv250.jdbc;

import java.sql.*;
/**
 * java에서 select를 이용해 DB Customer table 불러오기
 * 
 * @author Administrator
 *
 */
public class JDBCExample {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
		String id = "jv250";
		String passwd = "jv250";
		
		
		try {
			try {
				Class.forName(driver);
				System.out.println("LOADED DRIVER ---> " + driver);
				
				Connection con = DriverManager.getConnection(url, id, passwd);
				System.out.println("CONNECTED TO ---> " + url);
				
				String sql = "SELECT * FROM Customer WHERE name = '유비'";
				Statement stmt = con.createStatement();			
				ResultSet rs = stmt.executeQuery(sql); //ResultSet -> 실행해서 받아온 결과 //executeQuery -> 쿼리 실행
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
				rs.close();
				stmt.close();
				con.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
