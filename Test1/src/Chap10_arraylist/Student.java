package Chap10_arraylist;

public class Student extends Person {
	private String major;

	Student(String name, int age, String major) {
		super(name,age);
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ":" + major;
	}
}
