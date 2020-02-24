package linkedList;

import java.util.ArrayList;

public class NthNodeFromEnd {
	
	public static void main(String [] args) {
		ListNode head = ListNode.ADT.createList();
		ListNode nthNode = nthEleFromEnd(head, 4);
		System.out.println(nthNode.getData());
	}
	
	private static ListNode nthEleFromEnd(ListNode head, int n) {
		int count = 0;
		ListNode temp = head;
		while(temp != null) {
			count++;
			temp = temp.getNext();
		}
		if(n > count) {
			System.out.println("There is not enough node");
			return null;
		}
		count = count -n;
		temp = head;
		while(count != 0) {
			temp = temp.getNext();
			count--;
		}
		return temp;
	}
	
	private static ListNode reverseListInGroup(ListNode head, int k) {
		int count = 0;
		ListNode temp = head;
		ArrayList<ListNode> lastNodes = new ArrayList<>();
		while(temp != null) {
			count++;
			if(count%k == 0)
				lastNodes.add(temp.getNext());
			temp = temp.getNext();
		}
		count = count/k;
		ListNode current = head,next = null;
		for(int i=0;i<count;i++) {
			ListNode prev = lastNodes.get(i);
			int nodeCount = 0;
			while(nodeCount != k && current != null) {
				next = current.getNext();
				current.setNext(prev);
				prev = current;
				current = next;
			}
			if(i==0) {
				temp = head;
				head = prev;
			}else {
				temp.setNext(prev);
			}
				
			
		}
	}
}
