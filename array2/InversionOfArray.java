package array2;

import java.util.*;
import java.io.*;

public class InversionOfArray {
    public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-- > 0){
	        int n = Integer.parseInt(br.readLine().trim()); 
	        String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            int arr [] = new int [n];
            for(int i=0;i<n;i++)
                arr[i] = Integer.parseInt(strs[i]);
            int inv = MergeSortAndCount(arr, 0, n-1);
            System.out.println(inv);
        }
        br.close();
    }
    
    private static int MergeSortAndCount(int [] arr, int s, int l ){
        int count = 0;
        if(s<l) {
            int m = (s + l)/2;
            
            count += MergeSortAndCount(arr, s,m);
            
            count += MergeSortAndCount(arr, m+1, l);
            
            count += MergeAndCount(arr, s, m, l);
        }
        return count;
    }
    
    private static int MergeAndCount(int arr [], int s, int m, int l) {
        int [] left = Arrays.copyOfRange(arr, s, m+1);
        int [] right = Arrays.copyOfRange(arr, m+1, l+1);
        
        int i=0, j=0, k=s, swaps = 0;
        while(i<left.length && j<right.length){
            if(left[i]<right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m-i+1) -s;// subtract s so that if starting index in 6 we can start 
                //counting after 6 not from 0
            }
        }
        
        while(i<left.length)
            arr[k++] = left[i++];
            
        while(j<right.length)
            arr[k++] = right[j++];
            
        //System.out.println(Arrays.toString(left)+" "+Arrays.toString(right)+" "+swaps);
        return swaps;
    }
}