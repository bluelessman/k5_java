package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.dto.City;

public class Test5_useO {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		List<City> list = new ArrayList<City>();
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			
			con = DriverManager.getConnection(url,username,password);
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from city where countrycode = \"KOR\" and population>=1000000");


			while(rs.next()) {
				City c = new City();
				c.setID(rs.getInt("id"));
				c.setCountryCode(rs.getString("countrycode"));
				c.setDistrict(rs.getString("district"));
				c.setName(rs.getString("name"));
				c.setPopulation(rs.getInt("population"));
				list.add(c);
			}
			rs = st.executeQuery("select * from city where countrycode = \"KOR\" limit 10");
			while(rs.next()) {
				City c = new City();
				c.setID(rs.getInt("id"));
				c.setCountryCode(rs.getString("countrycode"));
				c.setDistrict(rs.getString("district"));
				c.setName(rs.getString("name"));
				c.setPopulation(rs.getInt("population"));
				list.add(c);
			}
			
			rs = st.executeQuery("select * from city where countrycode = \"KOR\" and population between 1000000 and 5000000");
			while(rs.next()) {
				City c = new City();
				c.setID(rs.getInt("id"));
				c.setCountryCode(rs.getString("countrycode"));
				c.setDistrict(rs.getString("district"));
				c.setName(rs.getString("name"));
				c.setPopulation(rs.getInt("population"));
				list.add(c);
			}

			rs.close();
			st.close();
			con.close();
		}catch (Exception e) {
			System.out.println("연결 실패"+e.getMessage());
		}
		for (City city:list) System.out.println(city);
	}

}
