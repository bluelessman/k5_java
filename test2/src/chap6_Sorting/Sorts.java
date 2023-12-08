package chap6_Sorting;

import java.util.Random;

public class Sorts {
	static int qcount = 0;
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}

	static void print(int[] a) {
		System.out.print("[   ");
		for (int i : a) {
			System.out.print(i + "   ");
		}

		System.out.println("]\n");
	}

	public static void main(String[] args) {
		Random rd = new Random();
		int n = 100;
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = rd.nextInt(n*10) + 1;
		}
//		int[] a = {1,2,3,4,5,6,7,8,9,10};
		int[] bubble2 = a.clone();
		int[] bubble3 = a.clone();
		int[] selection = a.clone();
		int[] insertion = a.clone();
		int[] shell = a.clone();
		int[] shell2 = a.clone();
		int[] partition = a.clone();
		int[] quick = a.clone();
		System.out.println("초기 배열");
		print(a);
		bubblesort1(a);
		bubblesort2(bubble2);
		bubblesort3(bubble3);
		selectionsort(selection);
		insertion_Sort(insertion, n);
		shellsort(shell, n);
		shellsort2(shell2, n);
		partition(partition, n);
		quicksort(quick, 0, n - 1);
		System.out.println("quick, count = "+qcount);
		print(quick);

	}



	static void bubblesort1(int[] a) {
		int count = 0;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 1; j < a.length - i; j++) {
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
		for (int i = 0; i < a.length - 1; i++) {
			int exchg = 0;
			for (int j = 1; j < a.length - i; j++) {
				count++;
				if (a[j - 1] > a[j]) {
					exchg++;
					swap(a, j - 1, j);
				}
			}
			if (exchg == 0)
				break;
		}
		System.out.println("bubblesort2, 비교 횟수 = " + count);
		print(a);
	}

	static void bubblesort3(int[] a) {
		int count = 0;
		int k = a.length - 1;
		while (k > 0) {
			int last = 0;
			for (int i = 0; i < k; i++) {
				count++;
				if (a[i] > a[i + 1]) {
					swap(a, i, i + 1);
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
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				count++;
				if (a[min] > a[j])
					min = j;
			}
			swap(a, i, min);
		}
		System.out.println("selectionsort, 비교 횟수 = " + count);
		print(a);
	}

	static void insertion_Sort(int[] a, int n) {
		int count = 0;
		for (int i = 1; i < n; i++) {
			int tmp = a[i];
			int j;
			for (j = i; j > 0 && a[j - 1] > tmp; j--) {
				count++;
				a[j] = a[j - 1];
			}
			a[j] = tmp;
		}
		System.out.println("insertion, count= " + count);
		print(a);
	}

	static void partition(int[] a, int n) {
		int front = 0;
		int end = n - 1;
		int middle = a[n / 2];
		do {
			while (a[front] < middle)
				front++;
			while (a[end] > middle)
				end--;
			if (front <= end)
				swap(a, front++, end--);
		} while (front <= end);
		System.out.println("partition");
		System.out.printf("피벗값은 %d 입니다\n", middle);
		System.out.print("피벗 이하의 그룹: ");
		for (int i = 0; i < front; i++)
			System.out.print(a[i] + " ");
		System.out.println();
		if (front > end + 1) {
			System.out.print("피벗과 같은 그룹: ");
			for (int i = end + 1; i < front; i++)
				System.out.print(a[i] + " ");
			System.out.println();
		}
		System.out.print("피벗 이상의 그룹: ");
		for (int i = end + 1; i < n; i++)
			System.out.print(a[i] + " ");
		System.out.println("\n");

	}

	private static void quicksort(int[] a, int left, int right) {
		int front = left;
		int end = right;
		int middle = a[(front + end) / 2];
		do {
			while (a[front] < middle) {
				front++;
				qcount++;
			}
			while (a[end] > middle) {
				end--;
				qcount++;
			}
			if (front <= end)
				swap(a, front++, end--);
		} while (front <= end);
		if (left < end)
			quicksort(a, left, end);
		if (front < right)
			quicksort(a, front, right);
	}

	private static void shellsort2(int[] a, int n) {

		int count = 0;
		int i;
		for (i = 1; i < n; i = i * 3 + 1)
			;
		for (; i > 0; i /= 3) {
			for (int j = i; j < n; j++) {
				int k;
				int tmp = a[j];
				for (k = j - i; k >= 0 && a[k] > tmp; k -= i) {
					count++;
					a[i + k] = a[k];
				}
				a[k + i] = tmp;
			}
		}
		System.out.println("shell2, count= " + count);
		print(a);
	}

	private static void shellsort(int[] a, int n) {

		int count = 0;
		for (int i = n / 2; i > 0; i /= 2) {
			for (int j = i; j < n; j++) {
				int k;
				int tmp = a[j];
				for (k = j - i; k >= 0 && a[k] > tmp; k -= i) {
					count++;
					a[i + k] = a[k];
				}
				a[k + i] = tmp;
			}
		}
		System.out.println("shell, count= " + count);
		print(a);
	}

}
