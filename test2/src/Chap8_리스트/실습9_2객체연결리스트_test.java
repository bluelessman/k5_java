
package Chap8_리스트;
/*
 * 정수 리스트 > 객체 리스트: 2번째 실습 대상
 */
import java.util.Comparator;
import java.util.Scanner;




class SimpleObject {
	static final int NO = 1; // 번호를 읽어 들일까요?
	static final int NAME = 2; // 이름을 읽어 들일까요?

	private String no; // 회원번호
	private String name; // 이름

	// --- 문자열 표현을 반환 ---//
	@Override
	public String toString() {
		return "(" + no + ") " + name;
	}
	public SimpleObject() {
		no = null;name = null;
	}
	public int getNo() {
		return this.NO;
	}
	// --- 데이터를 읽어 들임 ---//
	void scanData(String guide, int sw) {
		Scanner sc = new Scanner(System.in);
		System.out.println(guide + "할 데이터를 입력하세요."+ sw);

		if ((sw & NO) == NO) { //& 는 bit 연산자임
			System.out.print("번호: ");
			no = sc.next();
		}
		if ((sw & NAME) == NAME) {
			System.out.print("이름: ");
			name = sc.next();
		}
	}

	// --- 회원번호로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject> {
		@Override
		public int compare(SimpleObject d1, SimpleObject d2) {
			return (d1.no.compareTo(d2.no) > 0) ? 1 : (d1.no.compareTo(d2.no)<0) ? -1 : 0;
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject> {
		@Override
		public int compare(SimpleObject d1, SimpleObject d2) {
			return d1.name.compareTo(d2.name);
		}
	}
}
class Node2 {
	SimpleObject data;
	Node2 link;
	public Node2(SimpleObject element) {
		data = element;
		link = null;
	}
}

class LinkedList2 {
	Node2 first;
	public LinkedList2() {
		first = null;
	}

	public int Delete(SimpleObject element, Comparator<SimpleObject> cc) //delete the element
	{
		Node2 temp = first;
		if(temp==null) {
			System.out.println("리스트가 비었습니다.");
			return -1;
		}
		if(cc.compare(temp.data, element)==0) {
			first = temp.link;
			return element.getNo();
		}
		while(temp.link!=null) {
			if(cc.compare(temp.link.data, element)==0) {
				temp.link = temp.link.link;
				return element.getNo();
			}
			temp = temp.link;
		}
		System.out.println("입력한 값이 없습니다.");
		return -1;
	}
	public void Show() { // 전체 리스트를 순서대로 출력한다.
		Node2 temp = first;
		while(temp!=null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	public void Add(SimpleObject element, Comparator<SimpleObject> cc) //임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
	{
		if(first==null) {
			first = new Node2(element);
			return;
		}
		Node2 newNode = new Node2(element);
		Node2 temp = first;
		if(cc.compare(temp.data, newNode.data)>=0) {
			newNode.link = temp;
			first = newNode;
			return;
		}
		while(temp.link!=null) {
			if(cc.compare(temp.link.data, newNode.data)>=0) {
				newNode.link = temp.link;
				temp.link = newNode;
				return;
			}
			temp = temp.link;
		}
		temp.link = newNode;
		return;
	}
	public boolean Search(SimpleObject element, Comparator<SimpleObject> cc) { // 전체 리스트를 순서대로 출력한다.
		Node2 temp = first;
		while(temp!=null) {
			if(cc.compare(temp.data,element)==0) {
				return true;
			}
			temp = temp.link;
		}
		return false;
	}
}
public class 실습9_2객체연결리스트_test {

	 enum Menu {
	        Add( "삽입"),
	        Delete( "삭제"),
	        Show( "인쇄"),
	        Search( "검색"),
	        Exit( "종료");

	        private final String message;                // 표시할 문자열

	        static Menu MenuAt(int idx) {                // 순서가 idx번째인 열거를 반환
	            for (Menu m : Menu.values())
	                if (m.ordinal() == idx)
	                    return m;
	            return null;
	        }

	        Menu(String string) {                        // 생성자(constructor)
	            message = string;
	        }

	        String getMessage() {                        // 표시할 문자열을 반환
	            return message;
	        }
	    }

	    //--- 메뉴 선택 ---//
	    static Menu SelectMenu() {
			Scanner sc = new Scanner(System.in);
	        int key;
	        do {
	            for (Menu m : Menu.values()) {
	                System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
	                if ((m.ordinal() % 3) == 2 &&
	                      m.ordinal() != Menu.Exit.ordinal())
	                    System.out.println();
	            }
	            System.out.print(" : ");
	            key = sc.nextInt();
	        } while (key < Menu.Add.ordinal() ||
	                                            key > Menu.Exit.ordinal());
	        return Menu.MenuAt(key);
	    }

	public static void main(String[] args) {
       Menu menu;                                // 메뉴
		System.out.println("Linked List");
		LinkedList2 l = new LinkedList2();
		Scanner sc = new Scanner(System.in);
		SimpleObject data;
    System.out.println("inserted");
	     l.Show();
	        do {
	            switch (menu = SelectMenu()) {
	             case Add :                           // 머리노드 삽입
	            	 data = new SimpleObject();
	            	 data.scanData("입력", 3);
	    	         l.Add(data, SimpleObject.NO_ORDER);
	                     break;
	             case Delete :                          // 머리 노드 삭제
	            	 data = new SimpleObject();
	            	 data.scanData("삭제", SimpleObject.NO);
	            	 int num = l.Delete(data, SimpleObject.NO_ORDER);
	            	 System.out.println("삭제된 데이터 성공은 " + num);
	                    break;
	             case Show :                           // 꼬리 노드 삭제
	                    l.Show();
	                    break;
	             case Search :                           // 회원 번호 검색
	            	 data = new SimpleObject();
	            	 data.scanData("탐색", SimpleObject.NO);
	                boolean result = l.Search(data, SimpleObject.NO_ORDER);
	                    if (result)
	                        System.out.println("검색 성공 = " + result );
	                    else
	                        System.out.println("검색 실패 = " + result);
	                     break;
	             case Exit :                           // 꼬리 노드 삭제
	                    break;
	            }
	        } while (menu != Menu.Exit);
	    }
}


