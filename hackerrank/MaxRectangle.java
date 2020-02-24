package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaxRectangle {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
        long area = h.length;
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int el,j,k,n = h.length;
        for(int i =1 ;i<n;i++) {
            if(!st.isEmpty() && h[i]<h[st.peek()]) {
                el = h[st.pop()];
                while(!st.isEmpty() && el == h[st.peek()])
                    st.pop();
                j = (st.isEmpty())?-1:st.peek();
                k = i;
                area = Math.max(area, el* (k-j-1));
                i--;
            }else st.push(i);
        }
        k = n;
        while(!st.isEmpty()) {
            el = h[st.pop()];
            while(!st.isEmpty() && el == h[st.peek()])
                st.pop();
            j = (st.isEmpty())?-1:st.peek();
            area = Math.max(area, el* (k-j-1));
        }
    return area;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

