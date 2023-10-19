package Chap3;

public class Test22 {
	public static void main(String[] args) {
		int a = 14;
		int b = 2;
		char op = 'ㅅ';
		switch(op) {
		case '+':
			System.out.println(a+b);
			break;
		case '-':
			System.out.println(a-b);
			break;
		case '*':
			System.out.println(a*b);
			break;
		case '/':
			System.out.println(a/b);
			break;
		default:
			System.out.println("부적합연산자");
		}

	}

}
