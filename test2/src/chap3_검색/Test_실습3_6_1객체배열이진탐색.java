package chap3_검색;


import java.util.Arrays;

//import chap2_기본자료구조.PhyscData2;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData implements Comparable<PhyscData>{
	String name;
	int height;
	double vision;
	
	public PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	public int compareTo(PhyscData o) {
		// TODO Auto-generated method stub
		if (height != o.height) {
			return height - o.height;
		} else if (vision != o.vision) {
			if (vision > o.vision) {
				return 1;
			} else {
				return -1;
			}
		} else {
			return name.compareTo(o.name);
		}
	}
	public String toString() {
		return "[" + name + ", " + height + ", " + vision + "]";
	}

}
public class Test_실습3_6_1객체배열이진탐색 {

	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("길동", 182, 0.6),
				new PhyscData("길동", 167, 0.2),
				new PhyscData("길동", 167, 0.5),
		};
		showData(data);
		sortData(data);
		showData(data);
		PhyscData key = new PhyscData("길동", 167, 0.2);
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);
		key = new PhyscData("길동", 167, 0.5);

		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + idx);
	}
	static void showData(PhyscData[]arr) {
		System.out.println();
		for (PhyscData fruit: arr) {
			System.out.print(fruit+" ");
		}
		System.out.println();
	}
	static void sortData(PhyscData[] o) {
		PhyscData temp;
		for (int i = 0; i < o.length; i++) {
			for (int j = i + 1; j < o.length; j++) {
				if (o[i].compareTo(o[j]) > 0) {
					temp = o[i];
					o[i] = o[j];
					o[j] = temp;
				}
			}
		}
	}
	static int linearSearch(PhyscData[] data, PhyscData key) {
		for (int i = 0; i < data.length; i++) {
			if (data[i].compareTo(key)==0) {
				return i;
			}
		}
		return -1;
	}

	static int binarySearch(PhyscData[] data, PhyscData key) {
		int front = 0;
		int end = data.length;
		do {
			int middle = (front + end) / 2;
			if (data[middle].compareTo(key)==0) {
				return middle;
			} else if (data[middle].compareTo(key) < 0) {
				front = middle + 1;
			} else {
				end = middle - 1;
			}
		} while (front <= end);
		return -1;
	}


}
