package chap2_기본자료구조;

//3번 실습
//교재 62 - 두 배열의 비교
//교재 79 - 다차원배열
import java.util.Random;

public class Test_실습2_7다차원배열 {
	public static void main(String[] args) {
		int[][] A = new int[2][3];
		int[][] B = new int[3][4];
		int[][] C = new int[2][4];
		int[][] D = new int[2][3];
		inputData(A);
		inputData(B);
		inputData(D);
		System.out.println("A[][]");
		showData(A);
		System.out.println("C[][]");
		showData(C);
		System.out.println("D[][]");
		showData(D);
		System.out.println();
		System.out.println("B[][]");
		showData(B);
		int[][] E = addMatrix(A, D);
		System.out.println("E[][]");
		showData(E);
		int [][]F = multiplyMatrix(A,B);
		System.out.println("F[][]");
		showData(F);
		int [][]G = transposeMatrix(A);
		System.out.println("G[][]");
		showData(G);
		boolean result = equals(A, D);
		System.out.println(" equals(A,D) = " + result);
	}

	static void inputData(int[][] data) {
		Random rd = new Random();
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				data[i][j] = rd.nextInt(10);
//				data[i][j] = i*j;
			}
		}
	}

	static void showData(int[][] items) {
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items[0].length; j++) {
				System.out.print(items[i][j] + "\t");
			}
			System.out.println();
		}
	}

	static boolean equals(int[][] a, int[][] b) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] != b[i][j]) {
					return false;
				}
			}
		}
		return true;

	}

	static int[][] addMatrix(int[][] X, int[][] Y) {
		int[][] m = new int[X.length][X[0].length];
		for (int i = 0; i < X.length; i++) {
			for (int j = 0; j < X[0].length; j++) {
				m[i][j] = X[i][j] + Y[i][j];
			}
		}
		return m;
	}

	static int[][] multiplyMatrix(int[][] X, int[][] Y) {
		int[][] m = new int[X.length][Y[0].length];
		for (int i = 0; i < X.length; i++) {
			for (int j = 0; j < Y[0].length; j++) {
				for (int k = 0; k < X[0].length; k++) {
					m[i][j] += X[i][k] * Y[k][j];
				}
			}
		}
		return m;
	}
	
	static int[][] transposeMatrix(int[][] X){
		int[][] m = new int[X[0].length][X.length];
		for (int i = 0; i < X[0].length; i++) {
			for (int j = 0; j < X.length; j++) {
				m[i][j] = X[j][i];
			}
		}
		return m;
	}
}
