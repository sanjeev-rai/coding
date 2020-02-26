package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * Given an array arr[] of N integers and two players A and B are playing a game where 
 * the players pick the element with the maximum digit sum in their turns. 
 * In the end, the player with the maximum sum of the picked elements wins the game. 
 * Assuming that the player A always starts the game first and both the players play optimally, 
 * the task is to find the winner of the game.
 */
public class GameWin {

	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0) {
			String [] strs = br.readLine().trim().split("\\s+");
			List<GameNumber> list = new LinkedList<>();
			for(String str: strs)
				list.add(new GameNumber(Integer.parseInt(str)));
			Collections.sort(list,  Collections.reverseOrder());
			int sum1 = 0, sum2 =0;
			for(int i=0;i<list.size();i++) {
				if(i%2==0)
					sum1 += list.get(i).n;
				else
					sum2 += list.get(i).n;
			}
			if(sum1 > sum2)
				System.out.println("A");
			else if(sum1 == sum2)
				System.out.println("DRAW");
			else
				System.out.println("B");
			for(GameNumber g: list)
				System.out.println(g.n);
		}
	}
}
	
class GameNumber implements Comparable<GameNumber> {

	int n;
	public GameNumber(Integer n) {
		this.n = n;
	}
	public int compareTo(GameNumber num) {
		// TODO Auto-generated method stub
		
		// This method returns 
		// positive integer, if the current object is greater than the specified object.
		// negative integer, if the current object is less than the specified object.
		// zero, if the current object is equal to the specified object.
		int s1 = GameNumber.digitSum(this.n);
		int s2 = GameNumber.digitSum(num.n);
		if(s1 == s2)
			return this.n - num.n;
		return s1 - s2;
	}
	
	public static int digitSum(int n) {
		int sum = 0;
		while(n != 0) {
			sum += n%10;
			n /= 10;
		}
		return sum;
	}
	
}
