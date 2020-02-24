package recursion;

import java.util.Scanner;

public class TowerOfHanoi {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		towerOfHanoi(n, 'A', 'C', 'B');
		sc.close();
	}
	
	private static void towerOfHanoi(int n, char src, char dest, char aux) {
		if(n == 1) {
			System.out.println("Move from " + src + " to " + dest);
		}else {
			towerOfHanoi(n-1, src, aux, dest);
			
			System.out.println("Move from " + src + " to " + dest);
			
			towerOfHanoi(n-1, aux, dest, src);
		}
			
	}
	
}
