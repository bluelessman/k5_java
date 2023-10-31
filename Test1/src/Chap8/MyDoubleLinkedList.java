package Chap8;


public class MyDoubleLinkedList {
	
	private Node head = null;
	private Node tail = null;
	private int len = 0;
	//노드 정의
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
			tail = newNode;
		}else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		len++;
	}
	//리스트 맨 앞에 새 노드 삽입
	public void addleft(String data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = newNode;
		}else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		len++;
	}
	//특정 인덱스에 노드 삽입
	public void add(int n, String data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = newNode;
		}else if(n == 0) {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}else if(n == len) {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}else {
			Node temp = findNode(n);
			newNode.prev = temp.prev;
			newNode.next = temp;
			temp.prev.next = newNode;
			temp.prev = newNode;
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
			while(temp!=null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
	}
	//리스트 역순 출력
	public void rprint() {
		if(head==null) {
			System.out.println("등록된 데이터가 없습니다.");
		}else {
			System.out.println("등록된 데이터는 다음과 같습니다.");
			Node temp = tail;
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
	//비어있으면 true 출력
	public boolean isEmpty() {
		if(len==0) {
			return true;
		}else {
			return false;
		}
	}
	//index가 n인 노드 찾기
	public Node findNode(int n) {
		Node temp = head;
		for(int i = 0;i<n;i++) {
			temp = temp.next;
		}
		return temp;
	}
	//특정 인덱스의 노드의 데이터 변경
	public void setData(int n, String data) {
		if(len<=n) {
			System.out.println("존재하지 않는 노드입니다");
		}else {
			Node temp = findNode(n);
			temp.data = data;
		}
	}
	//특정 인덱스의 노드의 데이터 반환
	public String getData(int n) {
		if(len<=n) {
			return "존재하지 않는 노드입니다";
		}else {
			Node temp = findNode(n);
			return temp.data;
		}
	}
	//마지막 노드 삭제 및 데이터 반환
	public String pop() {
		if(len==0) {
			return "등록된 데이터가 없습니다.";
		}else {
			Node temp = tail;
			if(head == tail) {
				head = null;
				tail = null;
			}else {
				tail = temp.prev;
				temp.prev.next = null;
				temp.prev = null;
			}
			len--;
			return temp.data;
		}
	}
	//첫 노드 삭제 및 데이터 반환
	public String popleft() {
		if(len==0) {
			return "등록된 데이터가 없습니다.";
		}else {
			Node temp = head;
			if(head == tail) {
				head = null;
				tail = null;
			}else {
				head = temp.next;
				temp.next.prev = null;
				temp.next = null;
			}
			len--;
			return temp.data;
		}
	}
	//특정 인덱스의 노드 삭제 및 데이터 반환
	public String pop(int n) {
		if(len<=n) {
			return "등록된 데이터가 없습니다.";
		}else {
			Node temp = findNode(n);
			if(head == tail) {
				head = null;
				tail = null;
			}else if(temp==head) {
				head = temp.next;
				temp.next.prev = null;
				temp.next = null;
			}else if(temp==tail) {
				tail = temp.prev;
				temp.prev.next = null;
				temp.prev = null;
			}else {
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
				temp.next = null;
				temp.prev = null;
			}
			len--;
			return temp.data;
		}
	}
}
