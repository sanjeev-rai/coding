package linkedList;

public class QueueUsingList<T> {
	
	public int length;
	private Node<T> head;
	public QueueUsingList() {
		this.length = 0;
		this.head = null;
	}
	
	public boolean insert(T data) {
		Node<T> current,temp = new Node<>(data);
		synchronized (this) {
			if(head == null) {
				head = temp;
			}
			else {
				current = head;
				while (current.getNext() != null)
					current = current.getNext();
				current.setNext(temp);
			}
			length++;
		}
		return true;
	}
	
	public synchronized T remove() {
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
