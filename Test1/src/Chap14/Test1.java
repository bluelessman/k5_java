package Chap14;

interface MyInterface {
	public void print();
}

//방법 1 : implements 사용
class MyClass1 implements MyInterface {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("MyClass1");
	}

}

class MyClass2 implements MyInterface {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Myclass2");
	}

}

public class Test1 {
	// 방법 4 : 매개변수 타입이 인터페이스
	public static void test(MyInterface mi) {
		mi.print();
	}

	// 방법 5 : 리턴 타입이 인터페이스
	public static MyInterface test2() {

		MyInterface mi = new MyInterface() {
			
			@Override
			public void print() {
				// TODO Auto-generated method stub
				System.out.println("test2()메서드에서 반환된 MyInterface");
			}
		};
		return mi;
		

	}
	//일반 인터페이스
	public static MyInterface test3() {
		return new MyInterface() {

			@Override
			public void print() {
				// TODO Auto-generated method stub
				System.out.println("hello");
			}
		};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyClass1 mc1 = new MyClass1();
		MyClass2 mc2 = new MyClass2();
		mc1.print();
		mc2.print();

		MyInterface mi = new MyInterface() {
			// 방법 2 : 익명클래스 사용
			@Override
			public void print() {
				// TODO Auto-generated method stub
				System.out.println("익명 클래스로 구현");
			}
		};
		// 방법 4
		test(mc1);
		test(mi);
		// 방법 2
		mi.print();

		// 방법 3 : 선언 생성 호출을한번에 처리
		(new MyInterface() {

			@Override
			public void print() {
				// TODO Auto-generated method stub
				System.out.println("선언, 생성, 호출을 한번에 처리");
			}
		}).print();

		// 방법 5
		MyInterface mi2 = test2();
		mi2.print();

		// 일반 인터페이스
		MyInterface m1 = test3();
		m1.print();
		//람다식 사용
		MyInterface m2 =()-> System.out.println("hello lambda");
		m2.print();

	}

}
