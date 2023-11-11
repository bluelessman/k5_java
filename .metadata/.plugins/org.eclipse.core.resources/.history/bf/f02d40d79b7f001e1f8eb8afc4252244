package com.ruby.java.ch14.람다식;

/*
 * public interface Comparator<T>{
 *    int compare(T 01, T 02);
 *    }
 *    
 * public interface Comparable<T> {
 *   public int compareTo(T o);
 *   }   
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
class Student {
	String sno;
	String sname;
	public Student(String sno, String sname) {
		this.sno = sno; this.sname = sname;
	}
	public String toString() {
		return "[" + sno + ", " + sname+"]";
	}

}
public class test_객체배열정렬comparator {
	static void sortStudent(Student[]data, Comparator<Student> comp) {
		Student temp;
		for (int i = 0; i < data.length;i++) 
			for (int j = i + 1; j < data.length; j++)
			{

			}
	}
	
	public static void main(String[] args) {
		Comparator<Student> comp = new Comparator<Student>(){
			@Override
			public int compare(Student s1, Student s2) {

		};
		Student [] data = {
				new Student("12", "홍길동"),
				new Student("121", "홍길순"),
				new Student("213", "홍길춘"),
				new Student("9", "홍길홍")
		};
		sortStudent(data, comp);
		//Arrays.sort(data, comp);//이게 문제가 있어서 sortStudent()를 구현
		//Collections.sort(data, comp);
		/*
		Arrays.sort(data, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {

		});
		*/
		for (Student st: data)
			System.out.print(" " + st);
	}

}
