
package com.ruby.java.ch13.generic;

import java.util.Arrays;
import java.util.Random;
class Student implements Comparable<Student>{
	String sno;
	String sname;
	
	public String toString() {
		
	}
	@Override
	public int compareTo(Student s) {
		
	}
}
public class test_객체배열정렬소스 {

	static void sortStudent(Student[]data) {
		Student temp;
		for (int i = 0; i < data.length;i++) 
			for (int j = i + 1; j < data.length; j++)
			{
				
			}
	}
	
	public static void main(String[] args) {
		Student [] data = {
				new Student("12", "홍길동"),
				new Student("121", "홍길순"),
				new Student("213", "홍길춘"),
				new Student("9", "홍길홍")
		};
		sortStudent(data);
		//Arrays.sort(data);//이게 문제가 있어서 sortStudent()를 구현
		for (Student st: data)
			System.out.print(" " + st);
	}

}
