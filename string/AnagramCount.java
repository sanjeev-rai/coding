package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AnagramCount {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        String text = br.readLine();
	        String str = br.readLine();
	        int count = 0, n = str.length(), m = text.length();
	        int arr [] = new int [26];
	        int check [] = new int [26];
	        for(int i=0;i<n;i++)
	        	arr[str.charAt(i)-'a']++;
	        for(int i=0;i<n;i++)
	        	check[text.charAt(i)-'a']++;
	        for(int i=0;i<26;i++)
	        	if(arr[i]>check[i])
	        		count += arr[i]-check[i];
	        int anag = 0;
	        if(count==0)
	        	anag++;
	        for(int i=1;i<=m-n;i++) {
	        	int index = text.charAt(i-1)-'a';
	        	check[index]--;
	        	if(arr[index]>check[index])
	        		count++;
	        	index = text.charAt(i+n-1)-'a';
	        	check[index]++;
	        	if(arr[index]>=check[index])
	        		count--;
	        	if(count==0)
	        		anag++;
	        }
	        System.out.println(anag);
        }
        br.close();
	}

}

