package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.dto.Tel;

public class TelSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Tel> list = new ArrayList<Tel>();
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			
			con = DriverManager.getConnection(url,username,password);
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from tel");
			while(rs.next()) {
				Tel t = new Tel();
				t.setID(rs.getInt("ID"));
				t.setAddress(rs.getString("address"));
				t.setCate(rs.getString("cate"));
				t.setEmail(rs.getString("email"));
				t.setHP(rs.getString("hp"));
				t.setJP(rs.getString("jp"));
				t.setMP(rs.getString("mp"));
				t.setName(rs.getString("name"));
				list.add(t);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		for (Tel tel : list) {
			System.out.println(tel);
		}

	}

}
