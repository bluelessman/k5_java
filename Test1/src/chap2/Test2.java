package chap2;

public class Test2 {
	public static void main(String[] args) {
		double a = 3.14;
		float b = 1;
		float exchangeRate = 1136.50F;
		byte age = 23;
		short point = 32000;
		int price = 3500000;
		long totalSales = 2147483648L;
		int depositAmount;
		depositAmount = 50000;
		boolean isMarried = true;
		String t = "100";
		char gender = 'F';
		gender = 'M';
		String greet = "good morning";
		System.out.println(greet + "\n" + depositAmount + "\n" + isMarried + "\t" + gender);
		System.out.println(depositAmount + "|" + price + "|" + age + "|" + a + "|" + b + "|" + exchangeRate + "|"
				+ point + "|" + totalSales);
		System.out.println(b + price + depositAmount);
		System.out.println(depositAmount + price + age + a + b + exchangeRate + point + totalSales);
		System.out.println(depositAmount + t +  price + age + a + b + exchangeRate + point + totalSales);
	}
}
