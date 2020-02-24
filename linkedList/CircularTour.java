package linkedList;

import java.util.Scanner;

public class CircularTour {

	public static void main(String [] args) {
		GfG g = new GfG();
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int [] petrol = new int [n];
		int [] dist = new int [n];
		for(int i=0;i<n;i++) {
			petrol[i] = s.nextInt();
			dist[i] = s.nextInt();
		}
		int res = g.tour(petrol, dist);
		System.out.println(res);
	}
}//4 6 6 5 7 3 4 5
// 96 25 46 83 68 15 65 35 51 44 9 88 79 77 85 89 
// 55 52 33 100 77 61 40 69
//87 27 40 95 71 96 79 35 2 68 3 98 93 18 57 53 81 2 42 87 90 66 20 45 30 41
// [27, 95, 96, 35, 68, 98, 18, 53, 2, 87, 66, 45, 41]

class GfG
{
    int tour(int petrol[], int distance[])
    {
	// Your code here
	    int start = 0, end = 1,count=petrol[0] - distance[0],n = petrol.length;
	    while(end != start && start < n){
	        if(count<0){
	        	if(end < start)
	        		return -1;
	            start = end;
	            end = (start + 1)%n;
	            count = petrol[start] - distance[start];
	        }else {
	            count = count + petrol[end] - distance[end];
	            end = (end + 1)%n;
	        }
	    }
	    if(start == n || count < 0)
	        return -1;
	    else
	        return start;
    }
}