package linkedList;

public class SinglyListDemo {

	public static void main(String[] args) throws Exception {
		ListNode.ADT.insert(null, 100, -5);
		// TODO Auto-generated method stub
		ListNode head = ListNode.ADT.createList();
		System.out.print("Initial list :");
		ListNode.ADT.showList(head);
		// Insert in a list  
		head = ListNode.ADT.insert(head, 100, 1);
		System.out.print("after insertion at start :");
		ListNode.ADT.showList(head);
		head = ListNode.ADT.insert(head, 200, 4);
		System.out.print("After insertion at last :");
		ListNode.ADT.showList(head);
		head = ListNode.ADT.insert(head, 1000, 2);
		System.out.print("after insertion in between :");
		ListNode.ADT.showList(head);
		// delete from a list
		
		head = ListNode.ADT.delete(head, 100);
		System.out.print("after deletion from start :");
		ListNode.ADT.showList(head);
		head = ListNode.ADT.delete(head, 200);
		System.out.print("After deletion from last :");
		ListNode.ADT.showList(head);
		head = ListNode.ADT.delete(head, 9);
		System.out.print("after deletion in between :");
		ListNode.ADT.showList(head);
		
		
	}

}
