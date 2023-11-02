package Chap10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list.add("서울");
		list.add("북경");
		list.add("상해");
		list.add("서울");
		list.add("도쿄");
		list.add("뉴욕");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		list.forEach(s->System.out.println("fe:"+s));
		list.add("런던");
		list.add("로마");
		list.add("방콕");
		list.add("북경");
		list.add("도쿄");
		list.add("서울");
		System.out.println("1 : "+list.toString());
		System.out.println("1-1 : "+list);
//		Object arr[] = new Object[10];
//		String s = "java";
//		Integer i = 123;
//		arr[0]=s;
//		arr[1]=i;
//		int len = arr[0].length();
		list.add(1,"LA");
		print(2,list);
		System.out.println("3 : "+list.indexOf("서울"));
		System.out.println("4 : "+list.lastIndexOf("서울"));
		list.remove("LA"); print(5,list);
		list.remove(2); print(6,list);
		System.out.println("7 : "+list.contains("LA"));
		Object obj[] = list.toArray();
		System.out.println("8 : " + Arrays.toString(obj));
		String cities[] = new String[0];
		cities = list.toArray(cities);
		System.out.println("9 : "+Arrays.toString(cities));
		System.out.println("9-1 : "+cities.toString());
		System.out.println("9-2 : "+cities);
		list.clear(); print(10,list);
		System.out.println("11 : "+list.isEmpty());
		list.add("파리");list.add("방콕");list.add("LA");
		List<String> list2 = Arrays.asList("서울","뉴욕","상해");
		print(12,list2);
		list.addAll(list2); print(13,list);
		System.out.println("14 : "+list.containsAll(list2));
		list.retainAll(list2); print(15,list);
		list.removeAll(list2); print(16,list);
		
		

	}

	private static void print(int n, List<String> list) {
		// TODO Auto-generated method stub
		System.out.println(n+" : "+list);
	}

}
