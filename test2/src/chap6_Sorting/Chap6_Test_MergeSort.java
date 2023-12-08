package chap6_Sorting;

// PhyscData 클래스를 Comparable로 수정해야 한다.
// stack을 이용한 객체들의 non-recusrive MergeSort 구현
import java.util.Arrays;
import java.util.Comparator;

public class Chap6_Test_MergeSort {
//	package chap6_Sorting;
	// MergeSort() 구현 소스 코드를 사용하여 객체들의 정렬 소스코드로 수정한다.
	static PhyscData[] buff;
	static class PhyscData {
		private String name; // 이름
		private int height; // 키
		private double vision; // 시력

		// --- 생성자(constructor) ---//
		public PhyscData(String name, int height, double vision) {
			this.name = name;
			this.height = height;
			this.vision = vision;
		}

		// --- 문자열로 만들어 반환하는 메서드 --//
		public String toString() {
			return name + " " + height + " " + vision;
		}

		// --- 키의 오름차순으로 정렬하기 위한 comparator ---//
		public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

		private static class HeightOrderComparator implements Comparator<PhyscData> {
			public int compare(PhyscData d1, PhyscData d2) {
				return (d1.height > d2.height) ? 1 : (d1.height < d2.height) ? -1 : 0;
			}
		}
	}

	public class MergeSortObjects {

		// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
		static void merge(PhyscData[] a, int lefta, int righta, int leftb, int rightb) {

			int i; 			//뒤 배열 인덱스, 뒷 배열 순회에 사용
			int p = 0; 	//buff 배열 생성용 인덱스
			int j = 0;		//buff 배열 인덱스, 앞 배열 순회에 사용
			int k = lefta; //반환할 배열의 가장 앞 인덱스, 반환할 배열 인덱스로 사용
			
			buff = new PhyscData[righta-lefta+1];			//앞 배열을 저장할 buff 배열 정의
			
			for(i=lefta;i<=righta;i++)buff[p++]=a[i];		//lefta~righta까지의 a[]의 값을 buff에 저장
			//위의 for문 실행 후 buff에는 a[lefta]부터 a[righta]의 값을 가지고, p는 buff의 크기를, i는 leftb를 가리킨다.
			
			while(i<=rightb&&j<p) a[k++] = PhyscData.HEIGHT_ORDER.compare(buff[j],a[i])<=0?buff[j++]:a[i++];
			//앞 배열이나 뒷 배열의 값을 모두 넣을 때까지 두 배열의 현재 인덱스의 값을 비교하여 작은 값을 a[k]에 대입하고 k++
			while(j<p) a[k++] = buff[j++];
			//만약 앞 배열의 값이 남았다면 모두 삽입

		}

		// --- 퀵 정렬(비재귀 버전)---//
		static void MergeSort(PhyscData[] a, int left, int right) {
			int mid = (left + right) / 2;
			if (left == right)
				return;
			MergeSort(a, left, mid);
			MergeSort(a, mid + 1, right);
			merge(a, left, mid, mid + 1, right);
			return;
		}
	}

	public static void main(String[] args) {
		PhyscData[] x = { new PhyscData("강민호", 192, 0.3), new PhyscData("강민하", 162, 0.3), new PhyscData("김찬우", 173, 0.7),
				new PhyscData("박준서", 171, 2.0), new PhyscData("유서범", 171, 1.5), new PhyscData("이수연", 168, 0.4),
				new PhyscData("장경오", 171, 1.2), new PhyscData("황지안", 169, 0.8), };
		int nx = x.length;
		System.out.println("■ 신체검사 리스트 ■");
		System.out.println(" 이름     키  시력");
		System.out.println("------------------");
		for (int i = 0; i < x.length; i++)
			System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
		MergeSortObjects.MergeSort(x, 0, nx - 1); // 배열 x를 퀵정렬
		System.out.println("\n오름차순으로 정렬했습니다.");
		System.out.println("■ 신체검사 리스트 ■");
		System.out.println(" 이름     키  시력");
		System.out.println("------------------");
		for (int i = 0; i < x.length; i++)
			System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
	}

}
