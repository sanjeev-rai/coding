package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumberFormedByArray {
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-- > 0){
	        int n = Integer.parseInt(br.readLine().trim()); 
	        String line = br.readLine();
           String[] strs = line.trim().split("\\s+");
           List<StringNumber> list = new ArrayList<>();
           for(String str : strs){
               list.add(new StringNumber(str));
           }
           Collections.sort(list);
           StringBuilder sb = new StringBuilder();
           for(int i=n-1;i>=0;i--){
               //sb.append(list.get(i).number);
        	   System.out.println(list.get(i).number);
           }
           System.out.println(sb.toString());
       }
       br.close();
   }
}
//93192487974659545273250
class StringNumber implements Comparable<StringNumber> {
   String number;
   
   public StringNumber(String number) {
       this.number = number;
   }
   
   public int compareTo(StringNumber num) {
       int length = Math.min(this.number.length() , num.number.length());
       int i = 0;
       while(i<length) {
           if(this.number.charAt(i) == num.number.charAt(i)){
               i++;
               continue;
           }
           return this.number.charAt(i) - num.number.charAt(i);
       }
       if(this.number.length() != length) {
    	   while(i<this.number.length()) {
    		   if(this.number.charAt(i) == num.number.charAt(length -1)){
                   i++;
                   continue;
               }
    		   return this.number.charAt(i) - num.number.charAt(length-1);
    	   }   
       }
       
       if(num.number.length() != length) {
    	   while(i<num.number.length()) {
    		   if(this.number.charAt(length -1) == num.number.charAt(i)){
                   i++;
                   continue;
               }
    		   return this.number.charAt(length-1) - num.number.charAt(i);
    	   }   
       }
       
       return 0;
   }
}