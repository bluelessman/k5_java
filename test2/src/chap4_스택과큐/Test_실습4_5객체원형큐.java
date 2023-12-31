package chap4_스택과큐;
/*
 * 원형 큐로서 큐에 Point 객체를 저장 - 교재 소스코드를 원형 큐가 되도록 수정하는 연습
 */

import java.util.Random;
import java.util.Scanner;


class Point4 {
	private int ix;
	private int iy;

	public Point4(int x, int y) {
		ix = x;
		iy = y;
	}

	@Override
	public String toString() {
		return "<" + ix + ", " + iy + ">";
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

	@Override
	public boolean equals(Object p) {
		if ((this.ix == ((Point4) p).ix) && (this.iy == ((Point4) p).iy))
			return true;
		else
			return false;
	}
}

public class Test_실습4_5객체원형큐 {

	static int QUEUE_SIZE = 0;
	Point4[] que;// 배열로 객체원형 큐 구현
	int front, rear;
	int num;
	static boolean isEmpty;

	// --- 실행시 예외: 큐가 비어있음 ---//
	public class EmptyQueueException extends RuntimeException {
		public EmptyQueueException() {
		}
	}

	// --- 실행시 예외: 큐가 가득 찼음 ---//
	public class OverflowQueueException extends RuntimeException {
		public OverflowQueueException() {
		}
	}

	public Test_실습4_5객체원형큐(int count) {
		QUEUE_SIZE = count;
		que = new Point4[count];
		front = rear = num = 0;
		isEmpty = true;
	}

	void push(Point4 it) {
		if (num >= QUEUE_SIZE) {
			throw new OverflowQueueException();
		}
		que[rear++] = it;
		num++;
		if (rear == QUEUE_SIZE) {
			rear = 0;
		}
		isEmpty = false;

	}

	Point4 pop() {
		if (isEmpty) {
			throw new EmptyQueueException();
		}
		num--;
		if(num<=0) {
			isEmpty = true;
		}
		Point4 temp = que[front++];
		if(front==QUEUE_SIZE) {
			front=0;
		}
		return temp;
	}

	void clear() {
		for (int i = 0; i < que.length; i++) {
			que[i] = null;
			front = rear = 0;
		}
		isEmpty = true;
		System.out.println("원형 큐가 비었습니다.");
	}

	// --- 큐의 크기를 반환 ---//
	public int getCapacity() {
		return QUEUE_SIZE;
	}

	// --- 큐에 쌓여 있는 데이터 개수를 반환 ---//
	public int size() {
		return num;
	}

	public void dump() {
		if(isEmpty) {
			throw new EmptyQueueException();
		}
		System.out.print("[ ");
		for(int i=0;i<num;i++) {
			int idx = (i+front)%QUEUE_SIZE;
			System.out.print(que[idx]+" ");
		}
		System.out.print("]");
	
	}

	public Point4 peek() throws EmptyQueueException {
		if(num<=0) {
			throw new EmptyQueueException();
		}
		return que[front];
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		Test_실습4_5객체원형큐 oq = new Test_실습4_5객체원형큐(4); // 최대 64개를 인큐할 수 있는 큐
		Random random = new Random();
		int rndx = 0, rndy = 0;
		Point4 p = null;
		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", oq.size(), oq.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(0)종료: ");
			int menu = stdIn.nextInt();
			switch (menu) {
			case 1: // 인큐

				rndx = random.nextInt(20);

				rndy = random.nextInt(20);
				System.out.print("입력데이터: (" + rndx + ", " + rndy + ")");
				p = new Point4(rndx, rndy);
				try {
					oq.push(p);
				} catch (Test_실습4_5객체원형큐.OverflowQueueException e) {
					System.out.println("stack이 가득차있습니다.");
				}
				break;

			case 2: // 디큐
				try {
					p = oq.pop();
					System.out.println("디큐한 데이터는 " + p + "입니다.");
				} catch (Test_실습4_5객체원형큐.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = oq.peek();
					System.out.println("피크한 데이터는 " + p + "입니다.");
				} catch (Test_실습4_5객체원형큐.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 4: // 덤프

				try {
					oq.dump();
				} catch (Test_실습4_5객체원형큐.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;
			default:
				break;
			}
		}
	}

}
