package Chap8;


public class MyLinkedList2 {
	
	private Node head = null;
	private int len = 0;
	private class Node{
		private String data;
		private Node next;
		private Node prev;
		public Node(String data) {
			this.data = data;
		}
	}
	//리스트 끝에 새 노드 삽입
	public void add(String data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
		}else {
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.prev = temp;
		}
		len++;
	}
	//리스트 출력
	public void print() {
		if(head==null) {
			System.out.println("등록된 데이터가 없습니다.");
		}else {
			System.out.println("등록된 데이터는 다음과 같습니다.");
			Node temp = head;
			while(temp.next!=null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
			System.out.println(temp.data);
			System.out.println("-".repeat(10)+"reverse"+"-".repeat(10));
			while(temp!=null) {
				System.out.println(temp.data);
				temp = temp.prev;
			}
		}
	}
	//리스트의 길이 반환
	public int len() {
		return len;
	}
	//특정 인덱스의 노드의 데이터 변경
	public void setData(int n, String data) {
		if(len<=n) {
			System.out.println("존재하지 않는 노드입니다");
		}else {
			Node temp = head;
			for(int i = 0;i<n;i++) {
				temp = temp.next;
			}
			temp.data = data;
		}
	}
	//특정 인덱스의 노드의 데이터 반환
	public String getData(int n) {
		if(len<=n) {
			return "존재하지 않는 노드입니다";
		}else {
			Node temp = head;
			for(int i = 0;i<n;i++) {
				temp = temp.next;
			}
			return temp.data;
		}
	}
	//리스트의 마지막 노드 제거 후 데이터 값 리턴
//	public String pop() {
//		if(head==null) {
//			return "등록된 데이터가 없습니다.";
//		}else {
//			Node popnode = head;
//			Node temp = null;
//			if(head)
//			while(popnode.next!=null) {
//				temp = popnode;
//				popnode = temp.next;
//			}
//			temp.next = null;
//			popnode.prev = null;
//			return popnode.data;
//		}
//	}
}
