package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TelUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			
			PreparedStatement pt = con.prepareStatement("update tel set MP=? where ID=?");
			pt.setString(1, "051-333-3456");
			pt.setInt(2, 2);
			int eu = pt.executeUpdate();
			System.out.println(eu);
			pt.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	}


