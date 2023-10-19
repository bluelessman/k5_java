package Chap4;

public class Test38 {
	public static void main(String[] args) {
		// 5*5 배열 설정
		int[][] arr = new int[5][5];
		int num = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = num++;
			}
		}
		// 5*5 배열 출력
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
		// 배열의 오른쪽 대각 합 출력
		int sum = 0;

		for (int i = 0; i < arr.length && i < arr[0].length; i++) {
			sum += arr[i][i];
		}
		System.out.println("=".repeat(30));
		System.out.println(sum);
		
		//배열의 왼쪽 삼각형 순회
		int sum2 = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i+1; j++) {
				System.out.print(arr[i][j]);
				System.out.print("\t");
				sum2 += arr[i][j];
			}
			System.out.println("\n");
		}
		System.out.println("=".repeat(30));
		System.out.println(sum2);
	}
}
