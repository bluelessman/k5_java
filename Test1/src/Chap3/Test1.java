package Chap3;


public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = 90;
		int bonus;
		if (score < 100) {
			bonus = 10;
		} 
		else if (score < 200) {
			bonus = 20;
		}
		else {
			bonus = 30;
		}
		score += bonus;
		System.out.println(score);
	}

}
