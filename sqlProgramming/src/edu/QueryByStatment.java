package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryByStatment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//DB와 연결하는 객체
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			
			//드라이버 연결
			Class.forName(driver);
			
			//url의 데이터베이스에 연결
			con = DriverManager.getConnection(url,username,password);
			
			//쿼리를 날리기 위한 객체
			Statement st = con.createStatement();
			
			//쿼리 결과를 저장하는 객체
			ResultSet rs = st.executeQuery("select id,name,countrycode,district,population from city limit 10");
			
			//결과를 출력
			while(rs.next()) {
				System.out.print(rs.getString("id")+", ");
				System.out.print(rs.getString("name")+", ");
				System.out.print(rs.getString("countrycode")+", ");
				System.out.print(rs.getString("district")+", ");
				System.out.println(rs.getString("population"));
			}
			
			rs.close();
			st.close();
			con.close();
			
		}catch(Exception e){
			System.out.println("연결 실패 : " + e.getMessage());
		}
	}

}
