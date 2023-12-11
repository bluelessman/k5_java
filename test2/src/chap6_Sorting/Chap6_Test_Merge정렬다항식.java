package chap6_Sorting;

class Polynomial implements Comparable<Polynomial>{
	static Polynomial[] buff;
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
		for (int i = 0;i<x.length;i++) {
			if(x[i].exp==-1) {
				continue;
			}
			else if(x[i].exp==0) {
				System.out.print(String.format("%.1f", x[i].coef));
				}
			else System.out.print(String.format("%.1f", x[i].coef)+"x^" + x[i].exp);
			if(i<x.length-1)
			System.out.print(" + ");
		}
		System.out.println();
	}
	
	public static void AddPolynomial(Polynomial[] x, Polynomial[] y, Polynomial[] z) {
		// TODO Auto-generated method stub
		int i = 0;
		for (Polynomial p : x) {
			z[i++] = new Polynomial(p.coef, p.exp);
		}
		for (Polynomial p : y) {
			z[i++] = new Polynomial(p.coef, p.exp);
		}
		MergeSort(z, 0,z.length-1);
		for(int count = 0;count<z.length-1;count++) {
			if(z[count].compareTo(z[count+1])==0) {
				z[count+1].coef += z[count].coef;
				z[count].exp = -1;
			}
		}
	}
	public static void MultiplyPolynomial(Polynomial[] x, Polynomial[] y, Polynomial[] z) {
		// TODO Auto-generated method stub
		int i = 0;
		for (Polynomial p1 : x) {
			for (Polynomial p2 : y) {
				z[i++] = new Polynomial(p1.coef*p2.coef, p1.exp+p2.exp);
			}
		}
		MergeSort(z, 0,z.length-1);
		for(int count = 0;count<z.length-1;count++) {
			if(z[count].compareTo(z[count+1])==0) {
				z[count+1].coef += z[count].coef;
				z[count].exp = -1;
			}
		}
		
	}
	public static int EvaluatePolynomial(Polynomial[] z, int i) {
		// TODO Auto-generated method stub
		int answer = 0;
		for (Polynomial p : z) {
			answer += p.coef*Math.pow(i,p.exp);
		}
		return answer;
	}
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

}
public class Chap6_Test_Merge정렬다항식 {

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
//	static Polynomial[] buff;
// 	static void merge(Polynomial[] a, int lefta, int righta, int leftb, int rightb ) {
//		 //body를 지우고 작성 훈련 연습이 도움이 된다 
//		buff = new Polynomial[righta-lefta+1];
//		int i;
//		int j=0;
//		int k=lefta;
//		int p=0;
//		for(i=lefta;i<=righta;i++) {
//			buff[p++] = a[i];
//		}
//		while(i<=rightb&&j<p) a[k++] = buff[j].compareTo(a[i])>0?buff[j++]:a[i++];
//		while(j<p) a[k++]=buff[j++];
//	}
//
//	// --- 퀵 정렬(비재귀 버전)---//
//	static void MergeSort(Polynomial[] a, int left, int right) {
//		int mid = (left+right)/2;
//		if (left == right) return;
//		MergeSort(a, left, mid);
//		MergeSort(a, mid+1, right);
//		merge(a, left, mid, mid+1, right);
//		return;
//	}

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
		System.out.println("정렬 전 X:" );
		Polynomial.ShowPolynomial(x);
		System.out.println("정렬 전 Y:" );
		Polynomial.ShowPolynomial(y);
		Polynomial.MergeSort(x, 0, x.length - 1); // 배열 x를 퀵정렬
		Polynomial.MergeSort(y, 0, y.length - 1); // 배열 x를 퀵정렬
		System.out.println("정렬 후 X:" );
		Polynomial.ShowPolynomial(x);
		System.out.println("정렬 후 Y:" );
		Polynomial.ShowPolynomial(y);
		Polynomial[] z = new Polynomial[x.length+y.length];
		System.out.println("X+Y:" );
		Polynomial.AddPolynomial(x,y,z);//다항식 덧셈 z = x + y
		Polynomial.ShowPolynomial(z);
		z = new Polynomial[x.length*y.length];
		Polynomial.MultiplyPolynomial(x,y,z);//다항식 곱셈 z = x * y
		System.out.println("X*Y:" );
		Polynomial.ShowPolynomial(z);
		int result = Polynomial.EvaluatePolynomial(z, 10);//다항식 값 계산 함수 z(10) 값 계산한다 
		System.out.println("X = 10, result = " + result );
	}
}
