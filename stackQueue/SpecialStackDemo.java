package stackQueue;

import java.util.Scanner;

public class SpecialStackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		while(t-- > 0) {
			SpecialStack st = new SpecialStack();
			int q = sc.nextInt();
			for(int i=0;i<q;i++) {
				int qtype = sc.nextInt();
				if(qtype == 1)
					st.push(sc.nextInt());
				else if(qtype == 2)
					System.out.print(st.pop() + " ");
				else 
					System.out.print(st.getMin() + " ");
			}
		}
		sc.close();
	}

}
