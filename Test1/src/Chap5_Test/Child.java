package Chap5_Test;

public class Child extends Parent {
	public Child() {
		System.out.println("Child()");
	}
	public Child(String name) {
		// TODO Auto-generated method stub
		super(name);
		System.out.println("Child(String name)");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName();
	}
}
