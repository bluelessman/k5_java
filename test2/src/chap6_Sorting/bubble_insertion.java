package chap6_Sorting;

import java.util.Random;

public class bubble_insertion {
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	static void print(int[] a) {
		System.out.print("[   ");
		for (int i : a) {
			System.out.print(i+"   ");
		}
		System.out.println("]\n");
	}
	static void bubblesort1(int[] a) {
		int count = 0;
		for (int i = 0; i < a.length-1; i++) {
			for (int j = 1; j < a.length-i; j++) {
				count++;
				if (a[j - 1] > a[j])
					swap(a, j - 1, j);
			}
		}
		System.out.println("bubblesort1, 비교 횟수 = " + count);
		print(a);
	}
	
	static void bubblesort2(int[] a) {
		int count = 0;
		for(int i = 0; i< a.length-1;i++) {
			int exchg = 0;
			for(int j = 1; j<a.length-i;j++) {
				count++;
				if(a[j-1]>a[j]) {
					exchg++;
					swap(a,j-1,j);
				}
			}
			if(exchg==0) break;
		}
		System.out.println("bubblesort2, 비교 횟수 = " + count);
		print(a);
	}
	
	static void bubblesort3(int[] a) {
		int count = 0;
		int k = a.length-1;
		while(k>0) {
			int last = 0;
			for(int i = 0;i<k;i++) {
				count++;
				if(a[i]>a[i+1]) {
					swap(a,i,i+1);
					last = i;
				}
			}
			k = last;
		}
		System.out.println("bubblesort3, 비교 횟수 = " + count);
		print(a);
	}
	static void selectionsort(int[] a) {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i =0;i<a.length;i++) {
			int min = i;
			for(int j = i+1;j<a.length;j++) {
				count++;
				if(a[min]>a[j]) min = j;
			}
			swap(a,i,min);
		}
		System.out.println("selectionsort, 비교 횟수 = " + count);
		print(a);
	}

	public static void main(String[] args) {
		Random rd = new Random();
		int[] a = new int[10];
		for(int i = 0;i<10;i++) {
			a[i] = rd.nextInt(100)+1;
		}
//		int[] a = {1,2,3,4,5,6,7,8,9,10};
		int[] bubble2 = a.clone();
		int[] bubble3 = a.clone();
		int[] selection = a.clone();
		System.out.println("초기 배열");
		print(a);
		bubblesort1(a);
		bubblesort2(bubble2);
		bubblesort3(bubble3);
		selectionsort(selection);
	}

}
