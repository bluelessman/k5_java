package edu.dto;

public class Tel {
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
