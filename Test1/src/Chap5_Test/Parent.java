package Chap5_Test;

public class Parent {
	private String name;
	public Parent() {
		name = "홍길동";
		System.out.println("Parent()");
	}
	public Parent(String name) {
		this.name = name;
		System.out.println("Parent(String)");
	}
	public String getName() {
		return name;
	}
}
