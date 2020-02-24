package array;

import java.util.Arrays;
import java.util.Scanner;

public class AsphaltCoverByPushkar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int damages [] = new int[n];
		for(int i=0;i<n;i++)
			damages[i] = s.nextInt();
		int res = findMinAsphaltArea(damages,k);
		System.out.println(res);
		s.close();
	}

	private static int findMinAsphaltArea(int [] damages, int k) {
		int covered = -1;
		Arrays.parallelSort(damages);
		int count = k, n=damages.length;
		covered = damages[0] + k - 1;
		for(int i=1;i<n-1;i++) {
			int damage = damages[i];
			int leftCover = damage - k + 1;
			int rightCover = damage + k -1;
			// if we choose to spread asphalt left side
			int damageCount = 0,j=i+1;
			// count how many next damages con be covered
			while(j<n && damages[j++]<rightCover)
				damageCount++;
			
			// if we can cover next damages while filling i th damage
			if(damageCount > 0) {
				int remainingLeft = damages[i+damageCount] - rightCover;
				if(remainingLeft > 0 && covered - remainingLeft + damage > 0) {
					count += (k - (covered - remainingLeft + damage));
					covered = damages[i+damageCount];
				}else {
					covered = rightCover;
					count += k;
				}
				i += damageCount;
			}else {
				// if we can't cover next damages in this filling
				
				// overlapped area if we choose to spread asphalt left
				int leftOverlap = covered - leftCover +1;
				// overlapped area if we choose to spread asphalt right
				int rightOverlap = rightCover - (damages[i+1] - k + 1) + 1;
				if(leftOverlap > 0 && leftOverlap >= rightOverlap) {
					count += (k-leftOverlap);
					covered = damage;
				}else {
					count += k;
					covered = rightCover;
				}
			}
		}
		// filling the last damage if it is not filled yet
		if(covered < damages[n-1]) {
			int leftOverlap = covered -(damages[n-1] - k + 1) + 1;
			count += (leftOverlap > 0)?(k - leftOverlap):k;
		}
		return count;
	}
}
