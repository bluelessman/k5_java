package chap3_검색;

//3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
//comparator 구현 실습
import java.util.Arrays;
import java.util.Random;
public class Test_실습3_4정수배열이진탐색 {

	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data);
		showData(data);
		sortData(data);
		System.out.println();
		for (int num: data) {
			System.out.print(num+" ");
		}
		int key = 33;
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);

		key = 39;
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + idx);

	}
	static void inputData(int []data) {
		Random rand = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(100);
		}
	}
	static void swap(int[]arr, int ind1, int ind2) {
		int temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}
	static void sortData(int []arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					swap(arr, i, j);
				}
			}
		}
	}
	static void showData(int[] items) {
		for (int i = 0; i < items.length; i++) {
			System.out.print(items[i]+" ");
		}
	}
	static int linearSearch(int[] data, int key) {
		for(int i=0;i<data.length;i++) {
			if(data[i]==key) {
				return i;
			}
		}
		return -1;
	}
	static int binarySearch(int[] data, int key) {
		int front = 0;
		int end = data.length;
		do {
			int middle = (front+end)/2;
			if(data[middle]==key) {
				return middle;
			}else if(data[middle]<key) {
				front = middle + 1;
			}else {
				end = middle - 1;
			}
		}while(front<=end);
		return -1;
	}
}
