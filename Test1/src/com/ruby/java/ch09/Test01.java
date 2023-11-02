package com.ruby.java.ch09;

public class Test01 {
public static void main(String[] args) {
	String s = new String("Kim");
	String s1 = new String("Hong");
	Object obj1 = new Object();
	Object obj2 = new Object();
	Object obj3 = new Object();
	Object obj4 = new Object();
	MyObject obj5 = new MyObject();
//	System.out.println(s.compareTo(s1));
	System.out.println(obj1.hashCode());
	System.out.println(Integer.toHexString(obj1.hashCode()));
//	System.out.println(obj2.hashCode());
//	System.out.println(obj3.hashCode());
//	System.out.println(obj4.hashCode());
	System.out.println(obj1.toString());
	System.out.println(obj1.getClass());
	System.out.println(obj1);
	System.out.println(obj5);
	System.out.println(obj5.toString());
	if(obj1.equals(obj2)) {
		System.out.println("True");
	}else {
		System.out.println("False");
	}
	if(obj1==obj2) {
		System.out.println("True");
	}else {
		System.out.println("False");
	}
}
}
