package matrixTest;
//행렬 객체를 만드는 matrix class
public class Matrix {
	//행렬을 저장할 2차원 배열 선언
	private int[][] matrix;
	//행렬의 행을 저장할 정수 변수 선언
	private int row;
	//행렬의 열을 저장할 정수 변수 선언
	private int column;

	//배열, 배열의 인덱스, 행, 열이 주어진 생성자
	public Matrix(int[] array, int index, int row, int column) {
		//변수에 주어진 값 저장
		this.row = row;
		this.column = column;
		this.matrix = new int[row][column];
		
		//주어진 인덱스부터 차례대로 행렬에 값 저장
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				matrix[i][j] = array[index++];
			}
		}
	}

	//주어진 행렬에 대한 Matrix 객체를 만드는 생성자(sum,cross 용)
	public Matrix(int[][] matrix) {
		//매개변수로 받은 행렬과 그 행렬의 행, 열을 객체에 저장
		this.matrix = matrix;
		this.row = matrix.length;
		this.column = matrix[0].length;
	}

	//객체에 주어진 행렬을 출력하는 메서드
	public void print() {
		System.out.println("=".repeat(30) + "\n");
		
		//주어진 행렬을 각 행의 모든 열을 순서대로 순회하면서 출력
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			//한 행의 모든 열을 순회했으면 다음 행으로 넘어감
			System.out.println("\n");
		}
		System.out.println("=".repeat(30));
	}

	//객체의 행 반환
	public int row() {
		return this.row;
	}
	//객체의 열 반환
	public int column() {
		return this.column;
	}
	
	//객체의 행렬(2차원 배열) 반환
	public int[][] getMatrix() {
		return this.matrix;
	}

	//두 객체의 행렬의 행렬합을 가진 객체를 반환하는 행렬합 메서드
	public static Matrix sum(Matrix a, Matrix b) {
		//행렬합을 저장할 2차원 배열 선언
		int[][] sumMatrix = new int[a.row()][a.column()];
		//매개변수로 받은 두 객체의 행렬을 변수에 저장
		int[][] aMatrix = a.getMatrix();
		int[][] bMatrix = b.getMatrix();
		//sumMatrix의 각 좌표에 그 좌표의 a행렬과 b행렬의 값의 합 저장
		for (int i = 0; i < a.row(); i++) {
			for (int j = 0; j < a.column(); j++) {
				sumMatrix[i][j] = aMatrix[i][j] + bMatrix[i][j];
			}
		}
		//계산된 행렬합을 가지는 새 객체 생성
		Matrix newMatrix = new Matrix(sumMatrix);
		//생성된 객체를 반환
		return newMatrix;
	}

	//두 객체의 행렬의 행렬곱을 가진 객체를 반환하는 행렬곱 메서드
	public static Matrix cross(Matrix a, Matrix b) {
		//행렬곱을 저장할 2차원 배열 선언
		int[][] crossMatrix = new int[a.row()][b.column()];
		//매개변수로 받은 두 객체의 행렬을 변수에 저장
		int[][] aMatrix = a.getMatrix();
		int[][] bMatrix = b.getMatrix();
		//행렬곱 계산해서 행렬곱 배열에 저장
		for (int i = 0; i < a.row(); i++) {
			for (int j = 0; j < b.column(); j++) {
				int sum = 0;
				for (int k = 0; k < b.row(); k++) {
					sum += (aMatrix[i][k] * bMatrix[k][j]);
				}
				crossMatrix[i][j] = sum;
			}
		}
		//계산된 행렬곱을 가지는 새 객체 생성
		Matrix newMatrix = new Matrix(crossMatrix);
		//생성된 객체를 반환
		return newMatrix;
	}

}
