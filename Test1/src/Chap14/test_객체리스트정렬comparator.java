package Chap14;

import java.util.ArrayList;
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
import java.util.List;
import java.util.Random;
class Student2 {
	String sno;
	String sname;
	public Student2(String sno, String sname) {
		this.sno = sno;
		this.sname = sname;
	}

	public String toString() {
		return "{" + sno + ", " + sname + "}";
	}

}
public class test_객체리스트정렬comparator {
	static void sortStudent(List<Student2> data, Comparator<Student2> comp) {
		Student2 temp;
		for (int i = 0; i < data.size();i++) 
			for (int j = i + 1; j < data.size(); j++)
			{
				//if (data[i] < data[j] ) {//문제가 발생 :: 객체 비교가 안된다 
				//if (data[i].compareTo(data[j])>0) {
				//if (Integer.parseInt(data[i].sno) > Integer.parseInt(data[j].sno)) {
				if (comp.compare(data.get(i),data.get(j))>0){
					temp = data.get(i);
					data.set(i, data.get(j));
					data.set(j, temp);
				}
		
			}
	}
	
	public static void main(String[] args) {
		Comparator<Student2> compSno = new Comparator<Student2>(){
			@Override
			public int compare(Student2 s1, Student2 s2) {
				return Integer.parseInt(s1.sno) - Integer.parseInt(s2.sno);
			}
		};
		Comparator<Student2> compName = new Comparator<Student2>(){
			@Override
			public int compare(Student2 s1, Student2 s2) {
				return s1.sname.compareTo(s2.sname);
			}
		};

		ArrayList<Student2> al = new ArrayList<>();
		al.add(new Student2("12", "홍길동"));
		al.add(new Student2("121", "홍길순"));
		al.add(new Student2("321", "김길순"));
		al.add(new Student2("213", "홍길춘"));
		al.add(new Student2("9", "홍길홍"));
		
		System.out.println("정렬 전 데이터");
		for (Student2 st: al)
			System.out.print(" " + st);
		//sortStudent(al, compName);
		//Arrays.sort(data, compName);//이게 문제가 있어서 sortStudent()를 구현
		//Collections.sort(al, compName);
		Collections.sort(al, new Comparator<Student2>() {

			@Override
			public int compare(Student2 s1, Student2 s2) {
				// TODO Auto-generated method stub
				return Integer.parseInt(s1.sno) - Integer.parseInt(s2.sno);
			}
			
		});
		//Collections.sort(al, (s1, s2) -> Integer.parseInt(s1.sno) - Integer.parseInt(s2.sno));
		
//		Arrays.sort(data, new Comparator<Student>() {
//			
//		});

		System.out.printf("\n선언 생성 호출을 동시에 처리해 sno로 정렬\n");
		for (Student2 st: al)
			System.out.print(" " + st);
		System.out.printf("\n메서드로 구현해 sname으로 정렬\n");
		sortStudent(al, compName);
		for (Student2 st: al)
			System.out.print(" " + st);
		System.out.printf("\n메서드로 구현해 sno로 정렬\n");
		sortStudent(al, compSno);
		for (Student2 st: al)
			System.out.print(" " + st);
	}

}
