package linkedList;

import java.util.Scanner;

public class StackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StackUsingList<String> st = new StackUsingList<>();
		st.push(sc.next());
		st.push(sc.next());
		st.push(sc.next());
		System.out.println(st.length);
		System.out.println(st.pop());
		System.out.println(st.peek());
		sc.close();
	}

}
