package Chap13;

import java.util.Arrays;
import java.util.Random;

public class test_정수배열정렬 {

public static void main(String[] args) {
	int [] data = new int[20];
	Random rnd = new Random();
	for (int i = 0; i < data.length; i++) {
		data[i] = rnd.nextInt(100);
	}
		
	Arrays.sort(data);

	//출력 
	for (int i : data) {
		System.out.print(i+" ");
	}
}
}
