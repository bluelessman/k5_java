package chap6_Sorting;

public class Chap6_Test_Merge배열1 {
//--- 정렬을 마친 배열 a, b를 병합하여 배열 c에 저장 ---//
static void merge(int[] a, int na, int[] b, int nb, int[] c) {
	int pa = 0;
	int pb = 0;
	int pc = 0;
	while(pa<na&&pb<nb) c[pc++] = a[pa]>b[pb]?b[pb++]:a[pa++];
	while(pa<na) c[pc++] = a[pa++];
	while(pb<nb) c[pc++] = b[pb++];
}
static void showData(int[] d) {
	 System.out.println();
   for (int i = 0; i < d.length; i++)
       System.out.print(d[i] + " ");
   System.out.println();
}
public static void main(String[] args) {
   int[] a = {2, 4, 6, 8, 11, 13};
   int[] b = {1, 2, 3, 4, 9, 16, 21};
   int[] c = new int[13];

   System.out.println("두 개의 배열을 병합");

   merge(a, a.length, b, b.length, c);      // 배열 a와 b를 병합하여 c에 넣어 둠

   System.out.println("배열 a와 b를 병합하여 배열 c에 저장했습니다.");
   System.out.println("배열 a: ");
   showData(a);
   System.out.println();
   System.out.println("배열 b: ");
   showData(b);
   System.out.println();
   System.out.println("배열 c: ");
   showData(c);
  
}
}
