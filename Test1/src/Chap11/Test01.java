package Chap11;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[3];
		try {
			arr[4]=30;
			System.out.println("OK");
		}catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("잘못된 배열의 인덱스 사용"+e.getMessage());
		}
		System.out.println("GOOD");
		arr[3] = 30;
		System.out.println("OK");
	}

}
