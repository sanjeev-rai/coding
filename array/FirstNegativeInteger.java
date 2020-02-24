package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FirstNegativeInteger {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        int n = Integer.parseInt(br.readLine()); 
	        String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            int arr [] = new int [n];
            for(int i=0;i<n;i++)
                arr[i] = Integer.parseInt(strs[i]);
            int k = Integer.parseInt(br.readLine());
            int pos = 0, val = 0;
            for(int i=0;i<=n-k;i++) {
            	if(pos>0) {
            		System.out.print(val + " ");
            		pos--;
            	}
            	else {
            		int j;
            		for( j=i;j<i+k;j++) {
            			if(arr[j]<0) {
            				val = arr[j];
            				pos = j-i;
            				System.out.print(val + " ");
            				break;
            			}
            		}
            		if(j==i+k)
            			System.out.print(0 + " ");
            	}
            	
            }
            System.out.println();
        }
        br.close();
	}

}
