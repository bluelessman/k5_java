package Chap7_Geometry;

public abstract class Geometry {
	private int[] xArr = new int[4];
	private int[] yArr = new int[4];
	private int count = 0; 
	void addPoint(int x, int y) {
		xArr[count] = x;
		yArr[count] = y;
		count++;
	}
	public abstract double getLength();
	public abstract double getArea();
	public void getPoint() {
		for(int i=0;i<count;i++) {
			System.out.println(xArr[i]+","+yArr[i]);
		}
	}
}
