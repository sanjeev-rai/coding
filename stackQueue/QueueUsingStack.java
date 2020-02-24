package stackQueue;

public class QueueUsingStack {

	public StackQueue st2 = new StackQueue();
	
	public void push(int x) {
		st2.insert(x);
	}
	
	public int remove() {
		return st2.remove();
	}
}
