package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class Phone {
	private int ID;
	private String Name;
	private String Address;
	private String MP;
	private String JP;
	private String HP;
	private String Email;
	@Override
	public String toString() {
		return "Tel [ID=" + ID + ", Name=" + Name + ", Address=" + Address + ", MP=" + MP + ", JP=" + JP + ", HP=" + HP
				+ ", Email=" + Email + ", Cate=" + Cate + "]";
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getMP() {
		return MP;
	}
	public void setMP(String mP) {
		MP = mP;
	}
	public String getJP() {
		return JP;
	}
	public void setJP(String jP) {
		JP = jP;
	}
	public String getHP() {
		return HP;
	}
	public void setHP(String hP) {
		HP = hP;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCate() {
		return Cate;
	}
	public void setCate(String cate) {
		Cate = cate;
	}
	private String Cate;
	
}


public class PhoneBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con = connetDB();
			Statement st = con.createStatement();
			selectData(st);
			insertData(st);
			selectData(st);
			updateData(st);
			selectData(st);
			deleteData(st);
			selectData(st);
			con.close();
			st.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}	
			System.out.println("End");
	}





	private static void deleteData(Statement st) throws SQLException {
		// TODO Auto-generated method stub
		String sql =String.format("delete from  tel where id=%d",15);
		st.executeUpdate(sql);
		System.out.println("데이터 삭제 완료");
	}


	private static void updateData(Statement st) throws SQLException {
		// TODO Auto-generated method stub
		String sql =String.format("update tel set name='%s' where id=%d","홍길동",1);
		st.executeUpdate(sql);
		System.out.println("데이터 변경 완료");
	}


	private static void selectData(Statement st) throws SQLException {
		// TODO Auto-generated method stub
		List<Phone> list = new ArrayList<Phone>();
		ResultSet rs = st.executeQuery("select * from tel");
		while(rs.next()) {
			Phone t = new Phone();
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
		for (Phone tel : list) {
			System.out.println(tel);
		}
		System.out.println("출력 완료");
	}



	private static void insertData(Statement st) throws SQLException {
		// TODO Auto-generated method stub
		for(int i =0;i<10;i++) {
		String sql =String.format("INSERT INTO `world`.`tel`(`Name`,`Address`,`MP`,`JP`,`HP`,`Email`,`Cate`) "
		+ "VALUES('홍%d','부%d','0%d','1%d','2%d','m@%d','%d')",i,i,i,i,i,i,i);
		st.executeUpdate(sql);
		}
		System.out.println("데이터 입력 완료");
	}

	private static Connection connetDB() throws Exception {
		// TODO Auto-generated method stub
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/world";
		String username = "scott";
		String password = "tiger";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		
		System.out.println("연결 성공");
		
		return con;
	}

}
