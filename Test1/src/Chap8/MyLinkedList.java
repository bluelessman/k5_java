package Chap8;

public class MyLinkedList {
	
	private Node head = null;
	private int len = 0;
	private class Node{
		private String data;
		private Node link;
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
			Node next = head;
			while(next.link != null) {
				next = next.link;
			}
			next.link = newNode;
		}
		len++;
	}
	//리스트 출력
	public void print() {
		if(head==null) {
			System.out.println("등록된 데이터가 없습니다.");
		}else {
			System.out.println("등록된 데이터는 다음과 같습니다.");
			Node next = head;
			while(next!=null) {
				System.out.println(next.data);
				next = next.link;
			}
		}
	}
	//리스트의 길이 반환
	public int len() {
		return len;
	}
	public boolean isEmpty() {
		if(len==0) {
			return true;
		}else {
			return false;
		}
	}
	//특정 인덱스의 노드의 데이터 변경
	public void setData(int n, String data) {
		if(len<=n) {
			System.out.println("존재하지 않는 노드입니다");
		}else {
			Node next = head;
			for(int i = 0;i<n;i++) {
				next = next.link;
			}
			next.data = data;
		}
	}
	//특정 인덱스의 노드의 데이터 반환
	public String getData(int n) {
		if(len<=n) {
			return "존재하지 않는 노드입니다";
		}else {
			Node next = head;
			for(int i = 0;i<n;i++) {
				next = next.link;
			}
			return next.data;
		}
	}
	//리스트의 마지막 노드 제거 후 데이터 값 리턴
	public String pop() {
		if(head==null) {
			return "등록된 데이터가 없습니다.";
		}else {
			Node temp = head;
			Node next = null;
			while(temp.link!=null) {
				next = temp;
				temp = temp.link;
			}
			if(next == null) {
				head = null;
			}else {
				next.link = null;
			}
			len--;
			return temp.data;
		}
	}
}
