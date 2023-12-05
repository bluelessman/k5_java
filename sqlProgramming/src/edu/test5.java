package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			
			con = DriverManager.getConnection(url,username,password);
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from city where countrycode = \"KOR\" and population>=1000000");
			printSQL pt = new printSQL(rs);
			System.out.println("국가코드가 한국이면서 인구가 100만 이상인 도시");
			pt.print();
			rs = st.executeQuery("select * from city where countrycode = \"KOR\" limit 10");
			pt.setRs(rs);
			System.out.println("국가코드가 한국인 도시 중 인구수 top10");
			pt.print();
			rs = st.executeQuery("select * from city where countrycode = \"KOR\" and population between 1000000 and 5000000");
			pt.setRs(rs);
			System.out.println("국가코드가 한국인 도시 중 인구수가 100만 이상 500만 이하인 도시");
			pt.print();
			rs.close();
			st.close();
			con.close();
		}catch (Exception e) {
			System.out.println("연결 실패"+e);
		}
	}

}
