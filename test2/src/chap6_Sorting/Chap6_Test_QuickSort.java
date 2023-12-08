package chap6_Sorting;

import java.util.ArrayList;
import java.util.List;

import chap6_Sorting.Stack3.EmptyGenericStackException;

class Point {
	private int ix;
	private int iy;

	public Point(int x, int y) {
		ix = x;
		iy = y;
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}
}
class Stack3 {
	// --- 실행시 예외: 스택이 비어있음 ---//
	// generic class는 Throwable을 상속받을 수 없다 - 지원하지 않는다
	public class EmptyGenericStackException extends Exception {
		private static final long serialVersionUID = 1L;

		public EmptyGenericStackException() {
			super();
		}
	}

	// --- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowGenericStackException extends RuntimeException {
		public OverflowGenericStackException() {
		}
	}

	private List<Point> data; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

//--- 생성자(constructor) ---//
	public Stack3(int capacity) {
		// 구현
		data = new ArrayList<Point>();
		this.capacity = capacity;
		top = 0;

	}

//--- 스택에 x를 푸시 ---//
	public void push(Point x) throws OverflowGenericStackException {
		// 구현
		if (top >= capacity) {
			throw new OverflowGenericStackException();
		}
		top++;
		data.add(x);

	}

//--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Point pop() throws EmptyGenericStackException {
		// 구현
		if (top <= 0) {
			throw new EmptyGenericStackException();
		}
		return data.remove(--top);
	}

//--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Point peek() throws EmptyGenericStackException {
		// 구현
		if (top <= 0) {
			throw new EmptyGenericStackException();
		}
		return data.get(top - 1);
	}

//--- 스택을 비움 ---//
	public void clear() {
		top = 0;
	}

//--- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(Point x) {
		// 구현
		int count = 0;
		for (Point point : data) {
			if (point.equals(x)) {
				return count;
			}
			count++;
		}
		return -1;
	}

//--- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

//--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

//--- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return top <= 0;
	}

//--- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return top >= capacity;
	}

//--- 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력 ---//
	public void dump() {
		// 구현
		System.out.print("[ ");
		for (Point point : data) {
			System.out.print(point.toString() + " ");
		}
		System.out.print("]");
	}
}
public class Chap6_Test_QuickSort {
	static int count;

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void quickSort(int[] a, int left, int right) throws EmptyGenericStackException {
		Stack3 st = new Stack3(10);
		Point pt = new Point(left, right);
		st.push(pt);
		while(!st.isEmpty()) {
			pt = st.pop();
			int pl = left = pt.getX();
			int pr = right = pt.getY();
			int x = a[(left+right)/2];
			
			do {
				while (a[pl] < x) {
					pl++;
					count++;
				}
				while (a[pr] > x) {
					pr--;
					count++;
				}
				if (pl <= pr)
					swap(a, pl++, pr--);
			} while (pl <= pr);
			
			if(left<pr) st.push(new Point(left,pr));

			if(pl<right) st.push(new Point(pl,right));

		}
	}

	public static void main(String[] args) throws EmptyGenericStackException {
		int nx = 10;
		int[] x = new int[10];
		for (int ix = 0; ix < 10; ix++) {
			double d = Math.random();
			x[ix] = (int) (d * 20);
		}
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
		System.out.println();

		quickSort(x, 0, nx - 1); // 배열 x를 퀵정렬

		System.out.println("오름차순으로 정렬했습니다. count = "+count);
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
	}
}
