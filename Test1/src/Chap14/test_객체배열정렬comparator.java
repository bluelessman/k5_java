package Chap14;

/*
 * public interface Comparator<T>{
 *    int compare(T 01, T 02);
 *    }
 *    
 * public interface Comparable<T> {
 *   public int compareTo(T o);
 *   }   
 */
//import java.util.Arrays;
//import java.util.Collections;
import java.util.Comparator;
//import java.util.Random;

class Student {
	String sno;
	String sname;

	public Student(String sno, String sname) {
		this.sno = sno;
		this.sname = sname;
	}

	public String toString() {
		return "[" + sno + ", " + sname + "]";
	}

}

public class test_객체배열정렬comparator {
	public static void sortStudent(Student[] data, Comparator<Student> comp) {
		Student temp;
		for (int i = 0; i < data.length; i++)
			for (int j = i + 1; j < data.length; j++)
				if (comp.compare(data[i], data[j]) > 0) {
					temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}

	}

	public static void main(String[] args) {
		// sno를 이용한 비교
		Comparator<Student> comp = new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return Integer.parseInt(s1.sno) - Integer.parseInt(s2.sno);
			}

		};
		// sname을 이용한 비교
		Comparator<Student> compName = new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s1.sname.compareTo(s2.sname);
			}

		};
		Student[] data = 
			{ 
				new Student("12", "홍길동"), 
				new Student("121", "홍길순"), 
				new Student("213", "홍길춘"),
				new Student("9", "홍길홍") 
				};

		for (Student st : data)
			System.out.print(" " + st);
		System.out.println();
		System.out.println("=".repeat(50));
		sortStudent(data, comp);
		// Arrays.sort(data, comp);//이게 문제가 있어서 sortStudent()를 구현
		// Collections.sort(data, comp);
		/*
		 * Arrays.sort(data, new Comparator<Student>() {
		 * 
		 * @Override public int compare(Student s1, Student s2) {
		 * 
		 * })
		 */
		for (Student st : data)
			System.out.print(" " + st);

		sortStudent(data, compName);
		System.out.println();
		System.out.println("=".repeat(50));
		for (Student st : data)
			System.out.print(" " + st);
	}

}
