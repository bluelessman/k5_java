package Chap3;

public class gugudandowhile {
	public static void main(String[] args) {
		int i = 1;
		do {
			int j = 1;
			do {
				System.out.printf("%d * %d = %d	", i, j, i * j);
				j++;
			} while (j <= 9);
			i++;
			System.out.println();
		} while (i <= 9);

	}
}
