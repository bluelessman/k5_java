
package Chap8_리스트;

/*
 * 정수 리스트 > 객체 리스트 >
 */
import java.util.Comparator;
import java.util.Scanner;

class SimpleObject2 {
	static final int NO = 1; // 번호를 읽어 들일까요?
	static final int NAME = 2; // 이름을 읽어 들일까요?
	String no; // 회원번호
	String name; // 이름

	public SimpleObject2(String sno, String sname) {
		this.no = sno;
		this.name = sname;
	}

	public SimpleObject2() {
		this.no = null;
		this.name = null;
	}

	// --- 문자열 표현을 반환 ---//
	@Override
	public String toString() {
		return "(" + no + ") " + name;
	}

	// --- 데이터를 읽어 들임 ---//
	void scanData(String guide, int sw) {
		Scanner sc = new Scanner(System.in);
		System.out.println(guide + "할 데이터를 입력하세요." + sw);

		if ((sw & NO) == NO) { // & 는 bit 연산자임
			System.out.print("번호: ");
			no = sc.next();
		}
		if ((sw & NAME) == NAME) {
			System.out.print("이름: ");
			name = sc.next();
		}
	}

	// --- 회원번호로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject2> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject2> {
		@Override
		public int compare(SimpleObject2 d1, SimpleObject2 d2) {
			return (d1.no.compareTo(d2.no) > 0) ? 1 : ((d1.no.compareTo(d2.no) < 0)) ? -1 : 0;
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject2> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject2> {
		@Override
		public int compare(SimpleObject2 d1, SimpleObject2 d2) {
			return (d1.name.compareTo(d2.name) > 0) ? 1 : ((d1.name.compareTo(d2.name) < 0)) ? -1 : 0;
		}
	}
}

class Node4 {
	SimpleObject2 data; // 데이터
	Node4 llink; // 좌측포인터(앞쪽 노드에 대한 참조)
	Node4 rlink; // 우측포인터(뒤쪽 노드에 대한 참조)

	// --- 생성자(constructor) ---//
	Node4(SimpleObject2 so) {
		this.data = so;
		llink = rlink = this;
	}

	Node4() { // head node로 사용
		this.data = null;
		llink = rlink = this;
	}

	Node4(String sno, String sname) {
		data = new SimpleObject2(sno, sname);
		llink = rlink = this;
	}

	public int compareNode(Node4 n2) {
		SimpleObject2 so1 = this.data;
		if (SimpleObject2.NO_ORDER.compare(so1, n2.data) < 0)
			return -1;
		else if (SimpleObject2.NO_ORDER.compare(so1, n2.data) > 0)
			return 1;
		else
			return 0;
	}
}

class DoubledLinkedList2 {
	private Node4 first; // 머리 포인터(참조하는 곳은 더미노드)

// --- 생성자(constructor) ---//
	public DoubledLinkedList2() {
		first = null;

	}

// --- 리스트가 비어있는가? ---//
	public boolean isEmpty() {
		if (first == null) {
			System.err.println("리스트가 비어있습니다.");
			return true;
		} else
			return false;
	}

// --- 노드를 검색 ---//
	public boolean search(SimpleObject2 obj, Comparator<? super SimpleObject2> c) {
		if (isEmpty())
			return false;
		Node4 temp = first;
		while (true) {
			if (c.compare(obj, temp.data) == 0) {
				return true;
			}
			temp = temp.rlink;
			if (temp == first)
				return false;
		}
	}

// --- 전체 노드 표시 ---//
	public void show() {
		if (isEmpty())
			return;
		Node4 temp = first;
		while (true) {
			System.out.print(temp.data + "  ");
			temp = temp.rlink;
			if (temp == first) {
				System.out.println();
				return;
			}

		}
	}

// --- 올림차순으로 정렬이 되도록 insert ---//
	public void add(SimpleObject2 obj, Comparator<? super SimpleObject2> c) {
		Node4 addNode = new Node4(obj);
		if (isEmpty()) {
			first = addNode;
			return;
		}
		Node4 temp = first;
		if (c.compare(obj, temp.llink.data) >= 0) {
			addNode.rlink = temp;
			addNode.llink = temp.llink;
			temp.llink.rlink = temp.llink = addNode;
			return;
		}
		while (true) {
			if (c.compare(temp.data, obj) >= 0) {
				addNode.rlink = temp;
				addNode.llink = temp.llink;
				temp.llink.rlink = temp.llink = addNode;
				if (temp == first)
					first = addNode;
				return;
			}
			temp = temp.rlink;
		}
	}

// --- list에 삭제할 데이터가 있으면 해당 노드를 삭제 ---//
	public void delete(SimpleObject2 obj, Comparator<? super SimpleObject2> c) {
		if (isEmpty())
			return;
		Node4 temp = first;
		while (true) {
			if (c.compare(obj, temp.data) == 0) {
				temp.rlink.llink = temp.llink;
				temp.llink.rlink = temp.rlink;
				if (temp == first) {
					if (temp.rlink == first)
						first = null;
					else
						first = temp.rlink;
				}
				temp = new Node4();
				return;
			}
			temp = temp.rlink;
			if (temp == first) {
				System.err.println("값이 존재하지 않습니다.");
				return;
			}
		}
	}

	public DoubledLinkedList2 merge(DoubledLinkedList2 lst2, Comparator<? super SimpleObject2> c) {
		if (isEmpty())
			return lst2;
		DoubledLinkedList2 list = new DoubledLinkedList2();
		Node4 node1 = first;
		Node4 node2 = lst2.first;
		System.out.println(node2.data);
		boolean check1 = false;
		boolean check2 = false;
		while (true) {
			if (c.compare(node1.data, node2.data) < 0) {
				list.add(node1.data, c);
				node1 = node1.rlink;
				check1 = true;
			} else if (c.compare(node1.data, node2.data) > 0) {
				list.add(node2.data, c);
				node2 = node2.rlink;
				check2 = true;
			} else {
				list.add(node1.data, c);
				node1 = node1.rlink;
				node2 = node2.rlink;
				check1 = true;
				check2 = true;
			}
			if (node1 == first&&check1) {
				while (true) {
					list.add(node2.data, c);
					node2 = node2.rlink;
					check2 = true;
					if (node2 == lst2.first&&check2)
						return list;
				}
			}
			if (node2 == lst2.first&&check2) {
				while (true) {
					list.add(node1.data, c);
					node1 = node1.rlink;
					check1 = true;
					if (node1 == first&&check1)
						return list;
				}
			}
		}
	}
}

public class 실습9_6객체이중리스트_test {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Merge("병합"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner sc1 = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc1.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Linked List");
		DoubledLinkedList2 lst1 = new DoubledLinkedList2(), lst2 = new DoubledLinkedList2(),
				lst3 = new DoubledLinkedList2();
		String sno1 = null, sname1 = null;
		SimpleObject2 so;
		boolean result = false;
		do {
			switch (menu = SelectMenu()) {
			case Add: // 머리노드 삽입
				so = new SimpleObject2();
				so.scanData("입력", 3);
				lst1.add(so, SimpleObject2.NO_ORDER);
				break;
			case Delete: // 머리 노드 삭제
				so = new SimpleObject2();
				so.scanData("삭제", SimpleObject2.NO);
				lst1.delete(so, SimpleObject2.NO_ORDER);
				break;
			case Show: // 꼬리 노드 삭제
				lst1.show();
				break;
			case Search: // 회원 번호 검색
				so = new SimpleObject2();
				so.scanData("탐색", SimpleObject2.NO);
				result = lst1.search(so, SimpleObject2.NO_ORDER);
				if (!result)
					System.out.println("검색 값 = " + so.no + " 데이터가 없습니다.");
				else
					System.out.println("검색 값 = " + so.no + " 데이터가 존재합니다.");
				break;
			case Merge:
				for (int i = 0; i < 3; i++) {
					so = new SimpleObject2();
					so.scanData("입력", 3);
					lst2.add(so, SimpleObject2.NO_ORDER);
				}
				lst3 = lst1.merge(lst2, SimpleObject2.NO_ORDER);
				System.out.println("list1: ");
				lst1.show();
				System.out.println("list2: ");
				lst2.show();
				System.out.println("list3: ");
				lst3.show();
				break;
			case Exit: // 꼬리 노드 삭제
				break;
			}
		} while (menu != Menu.Exit);
	}
}
