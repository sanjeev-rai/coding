package codechef;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ValidPartitions {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0) {
			String [] str = br.readLine().trim().split("\\s+");
			String s = str[0];
			int k = Integer.parseInt(str[1]);
			if(s.length() >= ((k-1)*k + k-1)) {
				StringBuffer sb = new StringBuffer();
				int i, loop = s.length()/k, r = 0;
				r = (s.length()%k == 0)?0:1;
				for(i=0;i<loop-1+r;i++) {
					sb.append(s.substring(k*i, (k*i)+k));
					sb.append('-');
				}
				sb.append(s.substring(k*i));
				System.out.println(sb.toString());
			}else {
				System.out.println(-1);
			}
		}
	}

}
