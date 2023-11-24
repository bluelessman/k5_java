package chap2_기본자료구조;

public class PhyscData2 implements Comparable<PhyscData2> {
	String name;
	int height;
	double vision;

	public PhyscData2(String name, int height, double vision) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	public int compareTo(PhyscData2 o) {
		// TODO Auto-generated method stub
		if (height != o.height) {
			return height - o.height;
		} else if (vision != o.vision) {
			if (vision > o.vision) {
				return 1;
			} else {
				return -1;
			}
		} else {
			return name.compareTo(o.name);
		}
	}

	public String toString() {
		return "[" + name + ", " + height + ", " + vision + "]";
	}

}