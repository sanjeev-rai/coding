package linkedList;

import java.util.*;
import java.io.*;
public class RottenOrange
 {
    public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-- > 0){
	        String[] strs = br.readLine().trim().split("\\s+");
	        int row = Integer.parseInt(strs[0]);
	        int col = Integer.parseInt(strs[1]);
	        Orange.row = row;
	        Orange.col = col;
	        String s = br.readLine().trim();
            strs = s.split(" ");
            char arr [][] = new char [row][col];
            for(int i=0,r=0,c=0;i<strs.length;i++,r = i/col, c = i%col){
                arr[r][c] = strs[i].charAt(0);
            }
            
            Orange.mat = arr;
            Queue<Orange> q = new LinkedList<Orange>();
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(arr[i][j] == '2' )
                    	q.add(new Orange(i,j));
                }
            }
            q.add(null);
            boolean flag = true;
            int count = 0;
            while(!q.isEmpty()) {
            	Orange o = q.remove();
            	if(o == null) {
            		flag = true;
            		if(!q.isEmpty())
            			q.add(null);
            		continue;
            	}else {
            		Orange or = Orange.validate(o.r, o.c-1);
            		if(or!=null) {
            			q.add(or);
            			if(flag) {
            				flag = false;
            				count++;
            			}
            		}
            		
            		or = Orange.validate(o.r, o.c+1);
            		if(or!=null) {
            			q.add(or);
            			if(flag) {
            				flag = false;
            				count++;
            			}
            		}
            		
            		or = Orange.validate(o.r-1, o.c);
            		if(or!=null) {
            			q.add(or);
            			if(flag) {
            				flag = false;
            				count++;
            			}
            		}
            		
            		or = Orange.validate(o.r + 1, o.c);
            		if(or!=null) {
            			q.add(or);
            			if(flag) {
            				flag = false;
            				count++;
            			}
            		}
            	}
            }
            flag = true;
            for(int i=0;i<row && flag;i++){
                for(int j=0;j<col && flag;j++){
                    if(arr[i][j] == '1' ) {
                    	flag = false;
                    }
                }
            }
            if(flag)
            	System.out.println(count);
            else
            	System.out.println(-1);         
        }
        br.close();
    }
}

class Orange {
    int r, c, value = 2;
    static int row, col;
    static char [][] mat;
    
    public Orange(int r, int c){
        this.r = r;
        this.c = c;
    }
    
    public static Orange validate(int r, int c) {
    	Orange o = null;
    	if(r>=0 && r<row && c>=0 && c<col && mat[r][c] == '1') {
    		o = new Orange(r,c);
    		mat[r][c] = '2';
    	}
    	return o;
    }
}