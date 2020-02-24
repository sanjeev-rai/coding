package linkedList;

public class StackUsingList<T> {
	
	public int length;
	private Node<T> head;
	public StackUsingList() {
		this.length = 0;
		this.head = null;
	}
	
	public boolean push(T data) {
		Node<T> temp = new Node<>(data);
		synchronized (this) {
			temp.setNext(head);
			head = temp;
			length++;
		}
		return true;
	}
	
	public synchronized T pop() {
		if(head == null)
			throw new RuntimeException("EmptyStackException");
		T el = head.getData();
		head = head.getNext();
		length--;
		return el;
	}
	
	public T peek() {
		if(head == null)
			throw new RuntimeException("EmptyStackException");
		return head.getData();
	}
	
	public boolean isEmpty() {
		if(length == 0 || head == null)
			return true;
		return false;
	}
}
