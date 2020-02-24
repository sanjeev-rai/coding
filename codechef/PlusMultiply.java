package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PlusMultiply {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			String [] str = br.readLine().trim().split("\\s+");
			int count0=0, count1=0, pair=0;
			for(int i=0;i<n;i++) {
				if("0".equals(str[i]))
					count0++;
				else if("2".equals(str[i]))
					count1++;
			}
			pair = (count0 * (count0-1))/2 + (count1 * (count1-1))/2;
			System.out.println(pair);
	}
	}
}
