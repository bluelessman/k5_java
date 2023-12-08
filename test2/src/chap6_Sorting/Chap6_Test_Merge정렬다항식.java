package chap6_Sorting;

class Polynomial implements Comparable<Polynomial>{
    double coef;           // 계수
    int    exp;            // 지수

	public Polynomial(double coef, int exp) {
		this.coef = coef;
		this.exp = exp;
	}

	@Override
	public String toString() {
		return "Polynomial [coef=" + coef + ", exp=" + exp + "]";
	}

	public int compareTo(Polynomial o) {
		
		if(this.exp>o.exp) {
			return 1;
		}else if(this.exp<o.exp) {
			return -1;
		}else {
		return 0;
		}
	}
	
	public static void ShowPolynomial(Polynomial[] x) {
		// TODO Auto-generated method stub
		String[] ans = new String[x.length];
		int i = 0;
		for (Polynomial polynomial : x) {
			ans[i++] = polynomial.coef+"x^" + polynomial.exp;
		}
		System.out.println(String.join(" + ", ans));
	}
	
	public static void AddPolynomial(Polynomial[] x, Polynomial[] y, Polynomial[] z) {
		// TODO Auto-generated method stub
		
	}
	public static void MultiplyPolynomial(Polynomial[] x, Polynomial[] y, Polynomial[] z) {
		// TODO Auto-generated method stub
		
	}
	public static int EvaluatePolynomial(Polynomial[] z, int i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
public class Chap6_Test_Merge정렬다항식 {

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static Polynomial[] buff;
 	static void merge(Polynomial[] a, int lefta, int righta, int leftb, int rightb ) {
		 //body를 지우고 작성 훈련 연습이 도움이 된다 
		buff = new Polynomial[righta-lefta+1];
		int i;
		int j=0;
		int k=lefta;
		int p=0;
		for(i=lefta;i<=righta;i++) {
			buff[p++] = a[i];
		}
		while(i<=rightb&&j<p) a[k++] = buff[j].compareTo(a[i])>0?buff[j++]:a[i++];
		while(j<p) a[k++]=buff[j++];
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void MergeSort(Polynomial[] a, int left, int right) {
		int mid = (left+right)/2;
		if (left == right) return;
		MergeSort(a, left, mid);
		MergeSort(a, mid+1, right);
		merge(a, left, mid, mid+1, right);
		return;
	}

	public static void main(String[] args) {
		Polynomial[] x = {
		         new Polynomial(1.5, 3),
		         new Polynomial(2.5, 7),
		         new Polynomial(3.3, 2),
		         new Polynomial(4.0, 1),
		         new Polynomial(2.2, 0),
		         new Polynomial(3.1, 4),
		         new Polynomial(3.8, 5),
		     };
		Polynomial[] y = {
		         new Polynomial(1.5, 1),
		         new Polynomial(2.5, 2),
		         new Polynomial(3.3, 3),
		         new Polynomial(4.0, 0),
		         new Polynomial(2.2, 4),
		         new Polynomial(3.1, 5),
		         new Polynomial(3.8, 6),
		     };
		
		Polynomial.ShowPolynomial(x);
		Polynomial.ShowPolynomial(y);
		MergeSort(x, 0, x.length - 1); // 배열 x를 퀵정렬
		MergeSort(y, 0, y.length - 1); // 배열 x를 퀵정렬
		Polynomial.ShowPolynomial(x);
		Polynomial.ShowPolynomial(y);
//		Polynomial[] z = new Polynomial[20];
//		Polynomial.AddPolynomial(x,y,z);//다항식 덧셈 z = x + y
//		Polynomial.ShowPolynomial(z);
//		Polynomial.ShowPolynomial(y);
//		Polynomial.MultiplyPolynomial(x,y,z);//다항식 곱셈 z = x * y
//		Polynomial.ShowPolynomial(y);
//		int result = Polynomial.EvaluatePolynomial(z, 10);//다항식 값 계산 함수 z(10) 값 계산한다 
//		System.out.println(" result = " + result );
	}
}
