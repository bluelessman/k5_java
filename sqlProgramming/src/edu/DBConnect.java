package edu;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,username,password);
			System.out.println("연결 성공");
			con.close();
		}catch(Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
	}

}
