package chap2;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A1 = 10;
		int A2 = -A1;
		A2 += 10;
		//A1++;
		int A3 = A1++ + A2++;
		System.out.println(A3);
		System.out.println("A1 = " + A1 + " A2 = " + A2);
		System.out.println(A1 == A2);
		char gender = 'M';
		int balance = 100;
		System.out.println(gender == 'F' & balance > 10);

	}

}
