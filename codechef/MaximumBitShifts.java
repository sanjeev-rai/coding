package codechef;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaximumBitShifts {
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		String [] str = br.readLine().trim().split("\\s+");
		long [] arr = new long [t];
		for(int i=0;i<t;i++) {
			long number = Long.parseLong(str[i]);
			String binary = Long.toBinaryString(number);
			int ones = Long.bitCount(number);
			StringBuffer sb = new StringBuffer();
			for(int j=0;j<ones;j++)
				sb.append('1');
			for(int j=0;j<binary.length()-ones;j++)
				sb.append('0');
			arr[i] = Long.parseLong(sb.toString(),2);
		}
		for(int i=0;i<t;i++)
			System.out.print(arr[i]+" ");
	}
}