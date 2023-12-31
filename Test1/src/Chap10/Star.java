package Chap10;
import java.util.ArrayList;
import java.util.List;
public class Star {
	public static void main(String[] args) {
		print_star(10);
		print_star2(10);
	}
	
public static void print_star(int n) {
	List<String> L = new ArrayList<>();
	String star = null;
	for(int i = 0;i<n;i++) {
		star = "";
		for(int j=0;j<=i;j++) {
			star += "*";
		}
		L.add(star);
	}
	for(int i =0;i<L.size();i++) {
		System.out.println(L.get(i));
	}
}

public static void print_star2(int n) {
	List<String> L = new ArrayList<>();
	for(int i = 0;i<n;i++) {
		L.add("*".repeat(i+1));
	}
	L.forEach(s->System.out.println(s));
	}
}