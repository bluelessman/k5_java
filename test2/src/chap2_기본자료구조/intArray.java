package chap2_기본자료구조;

import java.util.Random;
import java.util.Scanner;

public class intArray {
	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					swap(a, i, j);
				}
			}
		}
	}

	static void sort2(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] < a[j]) {
					swap(a, i, j);
				}
			}
		}
	}

	static int maxOf(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		return max;
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner stdIn = new Scanner(System.in);
		int num = stdIn.nextInt();
		int[] a = new int[num];
		for (int i = 0; i < num; i++) {
			a[i] = rand.nextInt(100);
		}
		int result = maxOf(a);
		for (int n : a) {
			System.out.print(n + " ");
		}
		System.out.println("\n" + "최댓값 : " + result);
		sort(a);
		for (int n : a) {
			System.out.print(n + " ");
		}
		sort2(a);
		System.out.println();
		for (int n : a) {
			System.out.print(n + " ");
		}
		stdIn.close();
	}
}