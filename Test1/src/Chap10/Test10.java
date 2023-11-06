package Chap10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Test10 {
	public static void main(String[] args) {
		lotto_generator(2);
	}
	

public static void lotto_generator(int n) {
	Random rd = new Random();
	Set<Integer> lotto = null;
	for(int i=0;i<n;i++) {
		

	lotto = new HashSet<>();
	while(lotto.size()<6) {
	lotto.add(rd.nextInt(45)+1);
	}
	List<Integer> L = new ArrayList<>(lotto);
	Collections.sort(L);
	System.out.println(L);

	}
}
}
