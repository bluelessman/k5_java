package Chap10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Test3_classtype {
public static void main(String[] args) {
	List<Integer> arr = new ArrayList<>();
	Random rd = new Random();
	for(int i=0;i<100;i++) {
		arr.add(rd.nextInt(101));
	}
	System.out.println(arr);
	

	int arrsum = 0;
	int arrmax = -1;
	int arrmin = 101;
	for(int i=0;i<arr.size();i++) {
		int temp = arr.get(i);
		arrsum += temp;
		if(temp>arrmax) {
			arrmax = temp;
		}
		if(temp<arrmin) {
			arrmin = temp;
		}
		
	}
	float arravg = (float)arrsum/(float)arr.size();
	System.out.printf("총합: %d, 평균: %.2f, 최솟값: %d, 최댓값: %d",arrsum,arravg,arrmin,arrmax);
	
//	List<Integer> linked = new LinkedList<Integer>();
	
}
}
