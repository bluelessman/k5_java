package Chap5_Recursive;

import java.util.Scanner;

class IntStack {
	private int[] stk; // 스택용 배열
	private int capacity; // 스택의 크기
	private int ptr; // 스택 포인터

//--- 실행시 예외: 스택이 비어있음 ---//
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
		}
	}

//--- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
		}
	}

//--- 생성자(constructor) ---//
	public IntStack(int maxlen) {
		//구현
		stk = new int[maxlen];
		capacity = maxlen;
		ptr = 0;
	}

//--- 스택에 x를 푸시 ---//
	public void push(int x) throws OverflowIntStackException {
		//구현
		if(ptr>=capacity) {
			throw new OverflowIntStackException();
		}
		stk[ptr++]=x;
	}

//--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public int pop() throws EmptyIntStackException {
		//구현
		if(ptr<=0) {
			throw new EmptyIntStackException();
		}
		return stk[--ptr];
	}

//--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public int peek() throws EmptyIntStackException {
		//구현
		if(ptr<=0) {
			throw new EmptyIntStackException();
		}
		return stk[ptr-1];
	}

//--- 스택을 비움 ---//
	public void clear() {
		ptr = 0;
	}

//--- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(int x) {
		//구현
		for(int i=0;i<ptr;i++) {
			if(stk[i]==x) {
				return i;
			}
		}
		return -1;
	}

//--- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

//--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return ptr;
	}

//--- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return ptr <= 0;
	}

//--- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return ptr >= capacity;
	}

//--- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
	public void dump() {
		//구현
		System.out.print("[ ");
		for(int i=0;i<ptr;i++) {
			System.out.print(stk[i]+" ");
			}
		System.out.print("]");
	}
}


public class recur {
	static int count = 0;
	static int mcount = 0;
	static String[] memo;
	//재귀함수
	static int recursive(int n) {
		if(n>0) {
			recursive(n-1);
			System.out.println(n);
			recursive(n-2);
		}
		return ++count;
	}
	//재귀함수(메모화)
	static int mrecursive(int n) {
		if(memo[n+1] != null) {
			System.out.print(memo[n+1]);
		}else if(n<=0){
			memo[n+1]="";
		}else {
			mrecursive(n-1);
			System.out.println(n);
			mrecursive(n-2);
			memo[n+1] = memo[n]+n+"\n"+memo[n-1];
		}
		return ++mcount;
	}
	//스택 사용
	static void srecursive(int n) {
		IntStack s = new IntStack(n);
		while(true) {
			if(n>0) {
				s.push(n);
				n=n-1;
				continue;
			}
			if(s.isEmpty()!=true) {
				n=s.pop();
				System.out.println(n);
				n=n-2;
				continue;
			}
			break;
		}
	}
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("정수를 입력하세요: ");
		int n = stdIn.nextInt();
		memo = new String[n+2];
		System.out.println("DP 미적용");
		System.out.println("DP 미적용시 호출 횟수 : "+recursive(n));
		System.out.println("DP 적용");
		System.out.println("DP 적용시 호출 횟수 : "+mrecursive(n));
		System.out.println("스택");
		srecursive(n);
		stdIn.close();
	}
}
