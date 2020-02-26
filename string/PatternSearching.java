package string;

import java.io.*;
public class PatternSearching
 {
    public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        String str = br.readLine().trim();
            String substr = br.readLine().trim();
            int j = 0;
            boolean flag = false;
            for(int i=0;i<str.length();i++) {
                if(j == substr.length()){
                    flag = true;
                    break;
                }
                if(str.charAt(i) == substr.charAt(j))
                    j++;
                else
                    j = 0;
            }
            if(flag || (j == substr.length()))
                System.out.println("found");
            else 
                System.out.println("not found");
        }
        br.close();
    }
}