package Chap4;

public class rowcolumncross {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 행렬 A 선언
		int[][] A = new int[2][3];
		int numA = 1;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				A[i][j] = numA++;
			}
		}
		// 행렬 B 선언
		int[][] B = new int[3][2];
		int numB = 1;
		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < B[i].length; j++) {
				B[i][j] = numB++;
			}
		}
		// 행렬곱 계산
		for (int i = 0; i < A.length; i++) {
			for(int j =0;j<B[0].length;j++) {
				int sum = 0;
				for(int k =0; k<B.length;k++) {
					sum += (A[i][k]*B[k][j]);
				}
				System.out.print(sum+"\t");
			}
			System.out.println("\n");
	}

}
}