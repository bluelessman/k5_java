package com.ruby.java.ch09;

import java.util.Arrays;
import java.util.Random;

public class Test15 {
	public static void main(String[] args) {
		Random r2 = new Random();
		int data[] = new int[6];
		for (int i = 0; i < 6; i++) {
			data[i] = r2.nextInt(45)+1;
		}
		for(int num: data) {
			System.out.print(num+" ");
		}
		System.out.println(
				);
		Arrays.sort(data);
		for(int num: data) {
			System.out.print(num+" ");
		}
//		System.out.println(Arrays.toString(data));
//		for (int i = 0; i < 5; i++) {
//			System.out.println(r2.nextInt(10));
//		}
	}
}
