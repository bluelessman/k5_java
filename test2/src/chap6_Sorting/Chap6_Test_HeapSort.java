package chap6_Sorting;

import java.util.Random;
import java.util.Scanner;

interface MaxHeap {
	public void Insert(int x);
	public int DeleteMax();
}

class Heap implements MaxHeap {
	final int heapSize = 100;
	private int[] heap;
	private int n; // current size of MaxHeap
	private int MaxSize; // Maximum allowable size of MaxHeap
	
	public Heap(int sz) {
		MaxSize = sz;
		heap = new int[MaxSize+1];
	}

	public void display() {
		System.out.print("\n[ ");
		for (int i=1;i<n+1 ; i++) {
			System.out.print(heap[i]+" ");
		}
		System.out.println("]");
	}
	@Override
	public void Insert(int x) {
		int i;
		if(HeapFull()) return;
		n++;
		for(i = n;i>0;) {
			if(i==1) break;
			if(x<=heap[i/2]) break;
			heap[i] = heap[i/2];
			i /= 2;
		}
		heap[i] = x;
	}
	@Override
	public int DeleteMax() {
		int i,j;
		if(HeapEmpty()) return 0;
		int x = heap[1];
		int k = heap[n--];
		for(i=1,j=2;j<=n;) {
			if(j<n) if(heap[j]<heap[j+1]) j++;
			if(k>=heap[j]) break;
			heap[i]=heap[j];
			i=j;
			j*=2;
		}
		heap[i] = k;
		return x;
	}

	public boolean HeapEmpty() {
		if(n<=0) {
			System.out.println("Heap Empty");
			return true;
		}
		return false;
	}

	public boolean HeapFull() {
		if(n>=MaxSize) {
			System.out.println("Heap Full");
			return true;
		}
		return false;
	}
}
public class Chap6_Test_HeapSort {
	 static void showData(int[] d) {
	     for (int i = 0; i < d.length; i++)
	         System.out.print(d[i] + " ");
	     System.out.println();
	 }
	public static void main(String[] args) {
		Random rnd = new Random();
		int select;
		Scanner stdIn = new Scanner(System.in);
	    final int size = 20;
		Heap heap = new Heap(size);
	    int[] x = new int[size];
	    int []sorted = new int[size];
	    int count = 0;
		do {
			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
			select = stdIn.nextInt();
			switch (select) {
			case 1:
				if(!heap.HeapFull()) {
					int data = rnd.nextInt(20)+1;
					x[count++] = data;
					System.out.println("삽입된 데이터 : "+data);
					heap.Insert(data);
				}
				break;
			case 2:
				heap.display();
				break;
			case 3:
				if(!heap.HeapEmpty()) {
					System.out.println("정렬 전: ");
					showData(x);
					int idx = size-1;
					while(!heap.HeapEmpty()) {
						sorted[idx--] = heap.DeleteMax();
					}
					System.out.println("정렬 후: ");
					showData(sorted);
				}
				break;
			case 4:
				stdIn.close();
				return;
			}
		} while (select < 5);
		stdIn.close();
		return;
	}
}
