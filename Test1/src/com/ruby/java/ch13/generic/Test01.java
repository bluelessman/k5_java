package com.ruby.java.ch13.generic;

import java.util.Arrays;
import java.util.Random;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] data = new int[20];
		Random rnd = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = rnd.nextInt(100);
		}
			
		Arrays.sort(data);
		for (int i : data) {
			System.out.println(i);
		}
	}

}
