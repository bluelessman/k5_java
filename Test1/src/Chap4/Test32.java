package Chap4;

import java.util.Scanner;

public class Test32 {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int[] arr = new int[5];
//		arr[0] = 10;
//		arr[1] = 20;
//		arr[2] = 30;
//		arr[3] = 40;
//		arr[4] = 50;
//		System.out.println(arr[0]);
//		System.out.println(arr[1]);
//		System.out.println(arr[2]);
//		System.out.println(arr[3]);
//		System.out.println(arr[4]);
//		for(int i = 0; i < 5; i++) {
//			arr[i] = (i+1)*10;
//		}
//		for(int i = 0; i < 5; i++) {
//			System.out.println(arr[i]);
//		}
//	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[3];
		System.out.print("국어 점수를 입력하세요.: ");
		arr[0] = sc.nextInt();
		System.out.print("영어 점수를 입력하세요.: ");
		arr[1] = sc.nextInt();
		System.out.print("수학 점수를 입력하세요.: ");
		arr[2] = sc.nextInt();
		for (int i = 0; i < 3; i++) {
			System.out.println(arr[i]);
		}
		int avg = (arr[0] + arr[1] + arr[2]) / 3;
		System.out.printf("평균은 %d\n", avg);
		System.out.println("다른 배열 초기화, length 함수 활용");
		int arr2[] = { 1, 2, 3 };
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		int arr3[] = { 1, 2, 3 };
		System.out.println("확장for문");
		for (int i : arr3) {
			System.out.println(i);
		}

	}
}
