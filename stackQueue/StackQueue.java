package stackQueue;

import java.util.Stack;

class StackQueue
{
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    /* The method insert to push element
       into the queue */
    protected void insert(int B)
    {
	   // Your code here
	   s1.push(B);
    }
	
    
    /* The method remove which return the
      element popped out of the queue*/
    protected int remove()
    {
	   // Your code here
	   while(!s1.isEmpty()){
	       s2.push(s1.pop());
	   }
	   int x =-1;
	   if(!s2.isEmpty())
	       x = s2.pop();
	   while(!s2.isEmpty()){
	       s1.push(s2.pop());
	   }
	   return x;
    }
}