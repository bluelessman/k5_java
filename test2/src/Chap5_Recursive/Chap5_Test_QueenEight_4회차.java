
package Chap5_Recursive;
//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp

//N Queen problem / backtracking

import java.util.ArrayList;
import java.util.List;

import Chap5_Recursive.Stack3.EmptyGenericStackException;

//모든 해가 나오는 버젼 만들기 
/*
* 체스판은 8 x 8
* 체스의 기물: king/가로세로대각선 1칸만 이동, queen/가로세로 대각선/같은 편의 기물을 넘을 수 없다,
*  Rook/가로,세로 이동/다른 기물을 넘을 수없다, bishop/대각선, knight/1-2칸 이동/다른 기물을 넘을 수 있다,
*  pawn/처음 이동은 2칸까지 가능, 그 후 한칸만 가능, 잡을 때는 대각선 가능
*  체스판 최대 배치 문제 : king/16, Queen/8, rook/8, bishop/?, knight/?
*  rook 2개/a, h, knight 2개/b, g, bishop 2개/c, f, queen 1개/black queen은 black 칸에, 폰 8개
*/
class Point {
	private int ix;
	private int iy;

	public Point(int x, int y) {
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
		if ((this.ix == ((Point) p).ix) && (this.iy == ((Point) p).iy))
			return true;
		else
			return false;
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
		System.out.print("]\n");
	}
}

public class Chap5_Test_QueenEight_4회차 {
	public static void solveQueen(int[][] d) throws EmptyGenericStackException {
		int total = 0;// 총 해답 수
		int count = 0;// 퀸 배치 갯수
		int ix = 0, iy = 0;// 행 ix, 열 iy
		Stack3 st = new Stack3(100); // 100개를 저장할 수 있는 스택을 만들고
		Point p = new Point(ix, iy);// 현 위치를 객체로 만들고
		d[ix][iy] = 1;// 현 위치에 queen을 넣었다는 표시를 하고
		count++;
		st.push(p);// 스택에 현 위치 객체를 push
		ix++;// ix는 행별로 퀸 배치되는 것을 말한다.
		while (true) {
			// 교수님이 생각하신 완료조건인데 필요없음;; 아래에서 처리하면 된다.
//			if (st.isEmpty()&&iy==8) // iy가 8이면 8개 배치 완료, stack이 empty가 아니면 다른 해를 구한다
//				break;
			st.dump();
			if(total==5)break;
			if ((iy = nextMove(d, ix, iy)) == -1) {// 현재 row에 퀸 배치 불가, 배치 가능시 가능한 첫 column을 iy에 반환
				if(st.isEmpty()) break; //스택이 비어있다 = 탐색종료
				Point preQ = st.pop(); // 스택에서 이전 row의 퀸 위치 팝하여 새 객체에 저장

				// 이전 row의 퀸 위치로 좌표 이동
				ix = preQ.getX();
				iy = preQ.getY();

				// 이전 row의 퀸 제거
				d[ix][iy] = 0;
				count--;

				iy++;// 현재 위치에서 다음 column으로 이동

			} else {// 현재 row에 퀸 배치 가능(column=iy)

				// 새 퀸 위치를 새 객체에 저장 후 스택에 push
				Point newQ = new Point(ix, iy);
				st.push(newQ);

				// 퀸 배치
				d[ix][iy] = 1;
				count++;

				// 다음 row로 이동
				ix++;
				iy = 0;

			}
			if (count == 8) { // 8개를 모두 배치하면
				
				System.out.println("\n개수 : " + ++total);// 현재까지의 해답 수 출력

				showQueens(d);// 퀸 위치 출력

				// 마지막 퀸 위치 스택에서 팝하여 새 객체에 저장
				Point q = st.pop();

				// 마지막 퀸 위치 좌표로 이동
				ix = q.getX();
				iy = q.getY();

				// 마지막에 배치한 퀸 제거
				d[ix][iy] = 0;
				count--;

				iy++;// 현재 위치에서 다음 column으로 이동


			}

		}

	}

	public static boolean checkRow(int[][] d, int crow) { // 배열 d에서 행 crow에 퀸을 배치할 수 있는지 조사
		for (int i = 0; i < d.length; i++) {
			if (d[crow][i] == 1)
				return false;
		}
		return true;
	}

	public static boolean checkCol(int[][] d, int ccol) {// 배열 d에서 열 ccol에 퀸을 배치할 수 있는지 조사
		for (int i = 0; i < d.length; i++) {
			if (d[i][ccol] == 1)
				return false;
		}
		return true;
	}

	// 배열 d에서 행 cx, 열 cy에 퀸을 남서, 북동 대각선으로 배치할 수 있는지 조사
	public static boolean checkDiagSW(int[][] d, int cx, int cy) { // x++, y-- or x--, y++ where 0<= x,y <= 7
		int c = cx + cy;
		for (int i = Math.max(0, c - 7); i <= Math.min(7, c); i++) {
			if (d[i][c - i] == 1)
				return false;
		}
		return true;
	}

	
	// 배열 d에서 행 cx, 열 cy에 퀸을 남동, 북서 대각선으로 배치할 수 있는지 조사
	public static boolean checkDiagSE(int[][] d, int cx, int cy) {// x++, y++ or x--, y--
		int c = cy - cx + 7;
		for (int i = Math.max(0, c - 7); i <= Math.min(7, c); i++) {
			if (d[i + 7 - c][i] == 1)
				return false;
		}
		return true;
	}

	// 배열 d에서 (x,y)에 퀸을 배치할 수 있는지 조사
	public static boolean checkMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check
		if (checkRow(d, x) && checkCol(d, y) && checkDiagSE(d, x, y) && checkDiagSW(d, x, y)) {
			return true;
		}
		return false;
	}

	// 배열 d에서 현재 위치(row,col)에 대하여 다음에 이동할 위치 nextCol을 반환, 이동이 가능하지 않으면 -1를 리턴
	public static int nextMove(int[][] d, int row, int col) {// 현재 row, col에 대하여 이동할 col을 return
		for (int i = col; i < d.length; i++) {
			if (checkMove(d, row, i)) {
				return i;
			}
		}
		return -1;
	}

	static void showQueens(int[][] data) {// 배열 출력
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws EmptyGenericStackException {
		int row = 8, col = 8;
		int[][] data = new int[row][col];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;

		solveQueen(data);

	}
}
