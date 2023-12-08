package chap6_Sorting;

public class Chap6_Test_Merge배열2 {
//--- 배열 a에 정렬한 결과를 return ---//
	static void merge(int[] a, int left1, int right1, int left2, int right2) {
//{2,4,6,8,11,13}과 {1,3,5,7,9,16,21}을 합병하여 정렬 결과를 만드는 코드를 작성
		int pa = left1;
		int pb = left2;
		int na = right1+1;
		int nb = right2+1;
		int[] c = new int[right2-left1+1];
		int pc = 0;
		System.out.println(pa+" "+na+" "+pb+" "+nb);
		while(pa<na&&pb<nb) c[pc++] = a[pa]>a[pb]?a[pb++]:a[pa++];
		System.out.println(pa+" "+na+" "+pb+" "+nb);
		while(pa<na) c[pc++] = a[pa++];
		while(pb<nb) c[pc++] = a[pb++];
		showData(c);
		a = c.clone();
	}

	static void showData(int[] d) {
		System.out.println();
		for (int i = 0; i < d.length; i++)
			System.out.print(d[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {

		int[] a = { 2, 4, 6, 8, 11, 13, 1, 3, 5, 7, 9, 16, 21 };

		System.out.println("배열 a: ");
		showData(a);
		merge(a, 0, 5, 6, 12);

		System.out.println();
		System.out.println("합병후: ");
		showData(a);

	}
}
