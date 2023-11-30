package Chap5_Recursive;

import java.util.Scanner;

public class euclid {
	static int gcd(int x, int y) {
		if(y==0) {
			return x;
		}else {
			return gcd(y, x%y);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner stdIn = new Scanner(System.in);
		System.out.println("두 정수의 최대공약수를 구합니다.");
		System.out.println("정수 A를 입력하세요: ");
		int a = stdIn.nextInt();
		System.out.println("정수 B를 입력하세요: ");
		int b = stdIn.nextInt();
		System.out.println("최대공약수는 "+gcd(a,b)+"입니다.");
		stdIn.close();
	}

}
