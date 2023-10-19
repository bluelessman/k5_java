package Chap3;

public class gugudanwhile {
	public static void main(String[] args) {
		int i = 1;
		while (i <= 9) {
			int j = 1;
			while (j <= 9) {
				System.out.printf("%d * %d = %d\t", i, j, i * j);
				j++;
			}
			System.out.println();
			i++;
		}
	}
}
