package Chap10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test03 {
	public static void main(String[] args) {
		// 값을 담을 리스트 변수 생성
		List<Integer> arr = new ArrayList<>();

		// 랜덤 변수 선언
		Random rd = new Random();
		// 리스트에 100개의 정수를 랜덤으로 저장
		for (int i = 0; i < 100; i++) {
			arr.add(rd.nextInt(101));
		}

		// 완성된 리스트 출력
		System.out.println(arr);

		// 최대,최소,합 변수 선언
		int arrsum = 0;
		int arrmax = -1;
		int arrmin = 101;
		// 리스트의 값을 읽으면서 최대,최소,합 구하기
		for (int i = 0; i < arr.size(); i++) {
			int temp = arr.get(i);
			arrsum += temp;
			if (temp > arrmax) {
				arrmax = temp;
			}
			if (temp < arrmin) {
				arrmin = temp;
			}
		}
		// 평균 계산
		float arravg = (float) arrsum / (float) arr.size();

		// 결과 출력
		System.out.printf("총합: %d, 평균: %.2f, 최솟값: %d, 최댓값: %d", arrsum, arravg, arrmin, arrmax);
	}
}
