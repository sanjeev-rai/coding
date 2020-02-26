package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort012Array {

	public static void main(String [] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-- > 0){
	        int n = Integer.parseInt(br.readLine().trim()); 
	        String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            int arr [] = new int [n];
            for(int i=0;i<n;i++)
                arr[i] = Integer.parseInt(strs[i]);
            
            int start = 0, end = n-1;
            for(int i=0;i<n && end >= i;i++){
                if(arr[i] == 1)
                    continue;
                if(arr[i] == 0){
                    int temp = arr[start];
                    arr[start++] = 0;
                    arr[i--] = temp;
                }else {
                    int temp = arr[end];
                    arr[end--] = 2;
                    arr[i--] = temp;
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i: arr) 
                sb.append(i+" ");
            System.out.println(sb.toString());
        }
        br.close();
    }
}
		
