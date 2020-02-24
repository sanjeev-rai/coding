package linkedList;

import java.util.Stack;

import linkedList.DLL.ADT;
import linkedList.DLL.Node;

public class DLLDemo {

	public static void main(String [] args) throws Exception {
		Stack<Integer> st = new Stack<>();
		st.pop();
		DLL dll = new DLL();
		ADT adt = dll.new ADT();
		Node head = adt.createList();
		System.out.print("Initial list :");
		adt.showList(head);
		// Insert in a list  
		head = adt.insert(head, 100, 1);
		System.out.print("after insertion at start :");
		adt.showList(head);
		head = adt.insert(head, 200, 4);
		System.out.print("After insertion at last :");
		adt.showList(head);
		head = adt.insert(head, 1000, 2);
		System.out.print("after insertion in between :");
		adt.showList(head);
		// delete from a list
		
		head = adt.delete(head, 100);
		System.out.print("after deletion from start :");
		adt.showList(head);
		head = adt.delete(head, 200);
		System.out.print("After deletion from last :");
		adt.showList(head);
		head = adt.delete(head, 9);
		System.out.print("after deletion in between :");
		adt.showList(head);
	}
}
