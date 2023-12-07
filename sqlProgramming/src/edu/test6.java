package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import edu.dto.City;

public class test6 {
	public static void main(String[] args) {
		Connection con = null;
		List<City> list = new ArrayList<City>();
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			
			PreparedStatement pt = con.prepareStatement("select * from city where name=?");
			pt.setString(1, "seoul");
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {
				City c = new City();
				c.setID(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setDistrict(rs.getString("district"));
				c.setCountryCode(rs.getString("countrycode"));
				c.setPopulation(rs.getInt("population"));
				list.add(c);
			}
			
			rs.close();
			pt.close();
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("연결 실패"+e.getMessage());
		}
		for (City city : list) {
			System.out.println(city);
		}
	}
}
