package matrixTest;
//sort와 random을 위한 호출
import java.util.Arrays;
import java.util.Random;

public class test231115 {
	//자체 배열 출력 메서드
	public static void printArray(int[] array) {
		String result = "[ ";
		for (int i : array) {
			result +=i + " ";
		}
		result += "]";
		System.out.println("자체 메서드 출력 ; " + result);
	}
	//자체 배열 정렬 메서드
	public static void sortArray(int[] array) {
		int temp;
		for(int i = 0;i<array.length;i++) {
			for(int j = i;j<array.length;j++) {
				if(array[i]>array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		// 배열 선언
		int[] array = new int[24];
		// 랜덤 변수 선언
		Random rd = new Random();

		// 배열에 랜덤값 입력
		for (int i = 0; i < array.length; i++) {
			array[i] = rd.nextInt(101);
//			array[i] = i;
		}
		
		// 배열 출력
		printArray(array);
		System.out.println("배열 출력 : "+Arrays.toString(array));
		System.out.println("=".repeat(100));
		
		// 오름차순 정렬한 배열 저장할 새 배열 선언해 다른 주소로 같은 값 저장(deep copy)
		int[] array2 = array.clone();

		// 정렬
		Arrays.sort(array2);

		// 오름차순 배열 출력
		sortArray(array);
		printArray(array);
		System.out.println("정렬된 배열 출력 : "+Arrays.toString(array2));
		System.out.println("=".repeat(100));
		
		//행렬 A, B 생성 및 출력
		Matrix mA = new Matrix(array, 0, 3, 4);
		System.out.println("\n행렬 A를 출력합니다.");
		mA.print();
		Matrix mB = new Matrix(array, 12, 3, 4);
		System.out.println("\n행렬 B를 출력합니다.");
		mB.print();
		
		//합행렬 C 계산 및 출력
		System.out.println("\n행렬 A와 행렬 B의 합을 출력합니다.");
		Matrix mC = Matrix.sum(mA, mB);
		mC.print();
		
		//곱행렬을 위한 새 행렬 D 생성 및 출력
		Matrix mD = new Matrix(array, 0, 4, 3);
		System.out.println("\n행렬 D를 출력합니다.");
		mD.print();
		
		//곱행렬 D 계산 및 출력
		System.out.println("\n행렬 A와 행렬 D의 곱을 출력합니다.");
		Matrix mE = Matrix.cross(mA, mD);
		mE.print();

	}
}
