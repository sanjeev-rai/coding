package linkedList;

//import java.util.Scanner;

public class Node<T> {

	private T data;
	private Node<T> next;
	
	public Node(T data) {
		this.data = data;
		this.next = null;
	}
	
//	public Node() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter no of elements");
//		int n = sc.nextInt();
//		System.out.printf("Enter %d elements :", n);
//		int data = sc.nextInt();
//		Node<Integer> head = new Node<>(data);
//		head.createList();
//		sc.close();
//	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	
//	public <Integer> Node<Integer> createList() {
//		Node<Integer> temp = this;
//		for(int i=1;i<n;i++) {
//			data = sc.nextInt();
//			temp.next = new Node<>(data);
//			temp = temp.next;
//	}
}
