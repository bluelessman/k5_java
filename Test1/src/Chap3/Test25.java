package Chap3;

public class Test25 {
	public static void main(String[] args) {
		int a = 0;
		int d = 5;

		for (int i = 0; i < 100; i++) {
			a += d;
		}
		System.out.println("a = " + a);

		/*
		 * int i = 0; while(i < 5) { System.out.println("i = " + i + " a= " + a); a +=
		 * d; i++; }
		 */
		int i = 0;
		do {
			System.out.println("i = " + i + " a= " + a);
			a += d;
			i++;
		} while (i < 5);
	}
}
