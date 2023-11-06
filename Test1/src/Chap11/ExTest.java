package Chap11;

public class ExTest {
	public void d() {
		throw new IndexOutOfBoundsException();
	}

	public void c() throws Exception {
		System.out.println("C1");
//		int v = 10/0;
		d();
		System.out.println("C2");
	}

	public void b() throws Exception {
		System.out.println("b1");
		c();
		System.out.println("b2");
	}

	public void a() {
		System.out.println("a1");
		try {
			b();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("오류 발생 : " + e.getMessage());
		}
		System.out.println("a2");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExTest et = new ExTest();
		et.a();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DONE");
	}

}
