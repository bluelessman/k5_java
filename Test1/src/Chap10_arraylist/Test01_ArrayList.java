package Chap10_arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Test01_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> list = new ArrayList<>();
		
		Professor p1 = new Professor("교수1",40,"자바");
		list.add(p1);
		
		Professor p2 = new Professor("교수2",50,"파이썬");
		list.add(p2);
		
		Random rd = new Random();
		for(int i = 1;i<=10;i++) {
			Student s = new Student("학생"+i,rd.nextInt(20,30),"컴공과");
			list.add(s);
		}
//		System.out.println(list);
		list.forEach(p->System.out.println(p));
	}

}
