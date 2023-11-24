package chap2_기본자료구조;

public class Test_실습2_14객체배열정렬 {

	public static void main(String[] args) {
		PhyscData2[] data = { new PhyscData2("홍길동", 162, 0.3), new PhyscData2("홍동", 162, 1.3),
				new PhyscData2("홍길", 152, 0.7), new PhyscData2("김홍길동", 172, 0.3), new PhyscData2("이길동", 182, 0.6),
				new PhyscData2("박길동", 167, 0.2), new PhyscData2("최길동", 169, 0.5), new PhyscData2("김길", 152, 0.7) };
		showData(data);
		sortData(data);
		showData(data);
	}

	static void showData(PhyscData2[] o) {
		for (int i = 0; i < o.length; i++) {
			System.out.print(o[i].toString());
		}
		System.out.println();
	}

	static void sortData(PhyscData2[] o) {
		PhyscData2 temp;
		for (int i = 0; i < o.length; i++) {
			for (int j = i + 1; j < o.length; j++) {
				if (o[i].compareTo(o[j]) > 0) {
					temp = o[i];
					o[i] = o[j];
					o[j] = temp;
				}
			}
		}
	}

}
