package linkedList;

import java.util.Scanner;

public class DLL {

	class Node {
		private int data;
		private Node next, prev;
		
		public Node(int data) {
			this.data = data;
			this.next = this.prev = null;
		}	
	}

	 class ADT {
		public  Node insert(Node head, int data, int pos ) throws Exception {
			if(pos <= 0)
				throw new Exception("Illegal Position");
			if(pos == 1 || head == null) {
				Node node = new Node(data);
				node.next = head;
				node.prev = null;
				if(head != null)
					head.prev = node;
				return node;
			}
			Node temp = null;
			int count = 1;
			temp = head;
			while(temp.next != null && count != pos -1) {
				count++;
				temp = temp.next;
			}
			if(count != pos-1 )
				throw new Exception("Not enough nodes to reach the given Position");
			
			Node node = new Node(data);
			node.next = temp.next;
			node.prev = temp;
			if(temp.next != null)
				temp.next.prev = node;
			temp.next = node;
			return head;
		}
		
		public  Node delete(Node head, int data ) throws Exception {
			if (head != null) {
				Node temp = null;
				temp = head;
				while (temp != null) {
					if (temp.data == data)
						break;
					temp = temp.next;
				}
				if(temp == null) {
					System.out.println("Number not Found");
					return head;
				}
				if(temp == head) {
					temp.next.prev = null;
					return head.next;
				}
				temp.prev.next = temp.next;
				if(temp.next != null)
					temp.next.prev = temp.prev;
				return head;
			}
			System.out.println("List is Empty");
			return null;
		}
	
		public  Node createList() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter no of elements");
			int n = sc.nextInt();
			System.out.printf("Enter %d elements :", n);
			int data = sc.nextInt();
			Node head = new Node(data);
			Node temp = head;
			for(int i=1;i<n;i++) {
				data = sc.nextInt();
				temp.next = new Node(data);
				temp.next.prev = temp;
				temp = temp.next;
			}
			sc.close();
			return head;	
		}
	
		public  void showList(Node head) {
			while(head.next != null) {
				System.out.print(head.data + " ");
				head = head.next;
			}
			System.out.print(head.data + "    :");
			while(head.prev != null) {
				System.out.print(head.data + " ");
				head = head.prev;
			}
			System.out.print(head.data + " ");
			System.out.println();
		}
	}
		
}
