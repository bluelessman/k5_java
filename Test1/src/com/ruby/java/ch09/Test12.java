package com.ruby.java.ch09;

public class Test12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1 = 10;
		Integer obj1 = n1;
		Integer obj2 = Integer.valueOf("20");
		int n2 = obj2;
		
		Integer obj3 = 30;
		int n3 = obj3 + 40;
		int n4 = Integer.parseInt("123");
		n4 -= 15;
		System.out.println(n1+" : "+obj1);
		System.out.println(obj2+" : "+n2);
		System.out.println(n3);
		System.out.println(n4);
		String s1 = "9";
		String s2 = "21";
		if(s1.compareTo(s2)<0) {
			System.out.println("9<21");
		}else {
			System.out.println("9>21");
		}
		int ns1 = Integer.parseInt(s1);
		int ns2 = Integer.parseInt(s2);
		if(ns2>ns1) {
			System.out.println("9<21");
		}else {
			System.out.println("9>21");
		}
	}

}
