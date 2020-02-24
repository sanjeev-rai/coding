package linkedList;

import java.util.Scanner;

public class ListNode {
	public int data;
	public ListNode next;
	
	public ListNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	static class ADT {
		public static ListNode insert(ListNode head, int data, int pos ) throws Exception {
			if(pos <= 0)
				throw new Exception("Illegal Position");
			if(pos == 1) {
				ListNode node = new ListNode(data);
				node.next = head;
				return node;
			}
			ListNode prev = null, temp = null;
			int count = 0;
			if(head != null) {
				temp = head;
				while(temp != null && count != pos -1) {
					count++;
					prev = temp;
					temp = temp.next;
				}
				if(temp == null && count != pos -1)
					throw new Exception("Not enough nodes to reach the given Position");
				
				ListNode node = new ListNode(data);
				node.next = temp;
				prev.next = node;
				return head;
			}
			return null;
		}
		
		public static ListNode delete(ListNode head, int data ) throws Exception {
			if (head != null) {
				ListNode temp, prev = null;
				temp = head;
				while (temp != null) {
					if (temp.data == data)
						break;
					prev = temp;
					temp = temp.next;
				}
				if (prev == null)
					return head.next;
				if(temp == null) {
					System.out.println("Number not Found");
				}else 
					prev.next = temp.next;
				return head;
			}
			System.out.println("List is Empty");
			return null;
		}
	
		public static ListNode createList() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter no of elements");
			int n = sc.nextInt();
			System.out.printf("Enter %d elements :", n);
			int data = sc.nextInt();
			ListNode head = new ListNode(data);
			ListNode temp = head;
			for(int i=1;i<n;i++) {
				data = sc.nextInt();
				temp.next = new ListNode(data);
				temp = temp.next;
			}
			sc.close();
			return head;	
		}
	
		public static void showList(ListNode head) {
			while(head != null) {
				System.out.print(head.data + " ");
				head = head.next;
			}
			System.out.println();
		}
	}
}
