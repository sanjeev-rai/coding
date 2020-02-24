package stackQueue;

import java.util.Stack;

public class SpecialStack {

	public Stack<Integer> st = new Stack<>();
	public int minEle = -1;
	
	public int getMin() {
		return minEle;
	}
	
	public void push(int n) {
		if(minEle == -1) {
			minEle = n;
			st.push(n);
			return;
		}
		if(n >= minEle)
			st.push(n);
		else {
			// Modify element so that it will always be less that minEle and we can find prevous minEle
			// once this element will be popped
			
			// n = 2 * n - minEle  this will always less than minEle as n < minEle
			st.push(2 * n - minEle);
			minEle = n;
		}
			
	}
	
	public int pop() {
		if(st.isEmpty())
			return -1;
		
		int x = st.pop();
		int actualEle = x;
		if(x < minEle) {
			actualEle = minEle;
			minEle = 2 * minEle - x ;
		}
		if(st.isEmpty()) 
			minEle = -1;
		return actualEle;
	}
}
