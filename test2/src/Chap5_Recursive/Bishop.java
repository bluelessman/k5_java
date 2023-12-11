package Chap5_Recursive;

import Chap5_Recursive.Stack3.EmptyGenericStackException;

public class Bishop {
	public static void solveBishop(int[][] d) throws EmptyGenericStackException {
		int total = 0;// 총 해답 수
		int count = 0;// 비숍 배치 갯수
		int ix, iy;//현재 위치
		Point nextPoint;//nextMove로 찾은 새 지점 저장
		Stack3 st = new Stack3(100); // 100개를 저장할 수 있는 스택을 만들고
		for (int i = 0; i < 2; i++) {//0,0에 비숍이 있을 경우와 없을 경우 분리
			if (i == 0) {//0,0에 비숍이 있는 경우
				ix = iy = 0;
				Point p = new Point(ix, iy);// 현 위치를 객체로 만들고
				d[ix][iy] = 1;// 현 위치에 비숍을 넣었다는 표시를 하고
				count++;
				st.push(p);// 스택에 현 위치 객체를 push
				ix++;
			} else {//0,0에 비숍이 없는 경우
				ix = 1;
				iy = 0;
				Point p = new Point(ix, iy);// 현 위치를 객체로 만들고
				d[ix][iy] = 1;// 현 위치에 비숍을 넣었다는 표시를 하고
				count++;
				st.push(p);// 스택에 현 위치 객체를 push
				ix++;
			}
			while (true) {
				nextPoint = nextMove(d, ix, iy);//다음 대각선의 비숍 위치 저장
				if (nextPoint.equals(new Point(-1,-1))) {// 현재 대각선에 비숍 배치 불가,
					if (st.isEmpty())
						break; // 스택이 비어있다 = 탐색종료
					Point preB = st.pop(); // 스택에서 이전 대각선의 비숍 위치 팝하여 새 객체에 저장
					
					// 이전 대각선의 비숍 위치로 좌표 이동
					ix = preB.getX();
					iy = preB.getY();

					// 이전 대각선의 비숍 제거
					d[ix][iy] = 0;
					count--;

					//이전 대각선의 다음 지점으로 비숍 이동
					ix--; 
					iy++;

				} else {// 현재 대각선에 비숍 배치 가능

					// 새 비숍 위치를 새 객체에 저장 후 스택에 push
					ix = nextPoint.getX();
					iy = nextPoint.getY();
					Point newB = new Point(ix, iy);
					st.push(newB);

					// 비숍 배치
					d[ix][iy] = 1;
					count++;

					// 다음 대각선으로 이동
					int ixy = ix + iy;
					ix = Math.min(7, ixy+1);
					iy = Math.max(0,ixy+1-7);
				}
				if (count == 14) { // 14개를 모두 배치하면

					System.out.println("\n개수 : " + ++total);// 현재까지의 해답 수 출력

					showBishops(d);// 비숍 위치 출력

					// 마지막 비숍 위치 스택에서 팝하여 새 객체에 저장
					Point q = st.pop();

					// 마지막 퀸 위치 좌표로 이동
					ix = q.getX();
					iy = q.getY();

					// 마지막에 배치한 비숍 제거
					d[ix][iy] = 0;
					count--;
					
					//다음 위치로 비숍 이동
					ix--;
					iy++;
				}
			}
		}
	}

	// 배열 d에서 행 cx, 열 cy에 비숍을 남서, 북동 대각선으로 배치할 수 있는지 조사
	public static boolean checkDiagSW(int[][] d, int cx, int cy) { // x++, y-- or x--, y++ where 0<= x,y <= 7
		int c = cx + cy;
		for (int i = Math.max(0, c - 7); i <= Math.min(7, c); i++) {
			if (d[i][c - i] == 1)
				return false;
		}
		return true;
	}

	// 배열 d에서 행 cx, 열 cy에 비숍을 남동, 북서 대각선으로 배치할 수 있는지 조사
	public static boolean checkDiagSE(int[][] d, int cx, int cy) {// x++, y++ or x--, y--
		int c = cy - cx + 7;
		for (int i = Math.max(0, c - 7); i <= Math.min(7, c); i++) {
			if (d[i + 7 - c][i] == 1)
				return false;
		}
		return true;
	}

	// 배열 d에서 (x,y)에 비숍을 배치할 수 있는지 조사
	public static boolean checkMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check
		if (checkDiagSE(d, x, y) && checkDiagSW(d, x, y)) {
			return true;
		}
		return false;
	}

	// 배열 d에서 현재 위치(row,col)에 대하여 다음에 이동할 위치 nextPoint를 반환, 이동이 가능하지 않으면 (-1,-1)을 리턴
	public static Point nextMove(int[][] d, int row, int col) {
		int i,j;
		for (i = row, j = col; i >=0 && j<d.length ; i--,j++) {
			if (checkMove(d, i, j)) {
				return new Point(i,j);
			}
		}
		return new Point(-1, -1);
	}

	static void showBishops(int[][] data) {// 배열 출력
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

		solveBishop(data);
	}
}
