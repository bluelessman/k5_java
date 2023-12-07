package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.util.Scanner;



public class TelInsert {
	public static String[] data() {
		String[] output = new String[7];
		String[] index = { "Name", "Address", "MP", "JP", "HP", "Email", "Cate" };
		int count = 0;
		Scanner sc = new Scanner(System.in);
		for (String string : index) {
			System.out.print(string + ": ");
			output[count++] = sc.next();
		}
		sc.close();
		return output;
	}

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
			
			PreparedStatement pt = con.prepareStatement("INSERT INTO `world`.`tel`(`Name`,`Address`,`MP`,`JP`,`HP`,`Email`,`Cate`)VALUES(?,?,?,?,?,?,?)");
			String[] data = data();
			int count = 1;
			for (String string : data) {
				pt.setString(count++, string);
			}
			int eu = pt.executeUpdate();
			System.out.println(eu);
			pt.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
