package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class NextGreaterNum {

	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- >0) {
			br.readLine();
			String [] str = br.readLine().trim().split("\\s+");
			int n = str.length;
			int [] arr = new int [n];
			Stack<Integer> st = new Stack<Integer>();
			arr[n-1] = -1;
			st.push(Integer.parseInt(str[n-1]));
			StringBuilder sb = new StringBuilder();
			for(int i=n-2;i>=0;i--) {
				int el = Integer.parseInt(str[i]);
				if(el<st.peek()) {
					arr[i] = st.peek();
					st.push(el);
				}else {
					while(!st.isEmpty() && el > st.peek()) {
						st.pop();
					}
					
					if(st.isEmpty())
						arr[i] = -1;
					else {
						arr[i] = st.peek();
						st.push(el);
					}
				}
			}
			for(int i:arr) 
				sb.append(i + " ");
			System.out.println(sb.toString());
		}
	}

}
