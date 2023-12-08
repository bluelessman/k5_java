package chap6_Sorting;

public class partition {
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	static void partition(int[] a, int n) {
		int front = 0;
		int end = n-1;
		int middle = a[n/2];
		do {
			while(a[front]<middle) front++;
			while(a[end] > middle) end--;
			if(front<=end) swap(a,front++,end--);
		}while(front<=end);
		
		System.out.printf("피벗값은 %d 입니다",middle);
		System.out.println("피벗 이하의 그룹");
		for(int i=0;i<front;i++) System.out.print(a[i]+" ");
		System.out.println();
		if(front>end+1) {
			System.out.println("피벗과 같은 그룹");
			for(int i=end+1;i<front;i++) System.out.print(a[i]+" ");
			System.out.println();
		}
		System.out.println("피벗 이상의 그룹");
		for(int i=end+1;i<n;i++) System.out.print(a[i]+" ");
		System.out.println();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
