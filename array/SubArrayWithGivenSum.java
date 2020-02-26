package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubArrayWithGivenSum {
	
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-- > 0){
	    	String[] str = br.readLine().trim().split("\\s+"); 
	    	int n = Integer.parseInt(str[0]);
	    	int k = Integer.parseInt(str[1]);
	        String line = br.readLine();
            String [] strs = line.trim().split("\\s+");
            int arr [] = new int [n];
            for(int i=0;i<n;i++)
            	arr[i] = Integer.parseInt(strs[i]);
            
            int start = 0, end = n-1, sum = 0;
            boolean flag = false;
            for(int i=0;i<n;i++) {
            	if(sum == k) {
            		end = i-1;
            		flag = true;
            		break;
            	}else if(sum > k) {
            		sum -= arr[start++];
            		i--;
            	}else 
            		sum +=arr[i];
            }
            while(sum > k && start < end)
            	sum -= arr[start++];
            
            if(sum == k || flag) 
            	System.out.println((start + 1) + " " + (end + 1));
            else
            	System.out.println(-1);
	    }
	    br.close();
	}
}
