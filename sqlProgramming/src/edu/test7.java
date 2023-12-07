package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.dto.CountryLanguage;

public class test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		List<CountryLanguage> list = new ArrayList<CountryLanguage>();
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			
			PreparedStatement pt = con.prepareStatement("select * from countrylanguage cl where exists (select c.code from country c where name = ? and c.code = cl.countrycode)");
			System.out.println("exist 사용");
//			PreparedStatement pt = con.prepareStatement("select * from countrylanguage cl join country c on cl.countrycode = c.code where c.name = ?");
//			System.out.println("inner join 사용");
//			PreparedStatement pt = con.prepareStatement("select * from countrylanguage cl,country c where cl.countrycode = c.code and c.name = ?");
//			System.out.println("closs join 사용");
			pt.setString(1, "China");
			ResultSet rs = pt.executeQuery();
			while(rs.next()) {
				CountryLanguage cl = new CountryLanguage();
				cl.setCountryCode(rs.getString("countrycode"));
				cl.setIsOfficial(rs.getString("isofficial"));
				cl.setLanguage(rs.getString("language"));
				cl.setPercentage(rs.getFloat("percentage"));
				list.add(cl);
			}
			rs.close();
			pt.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("오류 발생"+ e.getMessage());
		}
		for (CountryLanguage countryLanguage : list) {
			System.out.println(countryLanguage);
		}
	}

}
