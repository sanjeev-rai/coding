package linkedList;

import java.util.Scanner;

public class QueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		QueueUsingList<Integer> st = new QueueUsingList<>();
		st.insert(sc.nextInt());
		st.insert(sc.nextInt());
		st.insert(sc.nextInt());
		System.out.println(st.length);
		System.out.println(st.remove());
		System.out.println(st.peek());
		sc.close();
	}
}
