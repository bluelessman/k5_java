package Chap4;

import java.util.Scanner;

public class Test37_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int score[] = new int[5];
		for(int i=0;i<score.length;i++) {
			System.out.printf("성적을 입력하세요(%d/5): ",i+1);
			score[i] = sc.nextInt();
		}
		int sum = 0;
		double avg = 0.0;
		int max = 0;
		int min = 999;
		for(int i=0;i<score.length;i++) {
			sum += score[i];
			if(max<score[i]) {
				max=score[i];
			}
			if(min>score[i]) {
				min = score[i];
			}
		}
		avg = sum/score.length;
		System.out.println("총 점 : "+sum);
		System.out.println("평 균 : "+avg);
		System.out.println("최댓값 : "+max);
		System.out.println("최솟값 : "+min);
	}

}
