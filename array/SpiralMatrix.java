package array;

import java.util.ArrayList;

public class SpiralMatrix {
	
	public static void SpiralOrder(int [][] mat) {
		int r1 = 0, r2= mat.length,c1=0, c2=mat[0].length;
		while(r1<r2 && c1<c2) {
			for(int i=c1;i<c2;i++)
				System.out.print(mat[r1][i] + " ");
			r1++;
			
			for(int i=r1;i<r2;i++)
				System.out.print(mat[i][c2-1] + " ");
			c2--;
			
			if(r1<r2 ) {
				for(int i=c2-1;i>=c1;i--)
					System.out.print(mat[r2-1][i] + " ");
			}
			r2--;
			
			if(c2>c1 ) {
				for(int i=r2-1;i>=r1;i--)
					System.out.print(mat[i][c1] + " ");
			}
			c1++;
		}
	}
	
	public static void SpiralList(ArrayList<ArrayList<Integer>> list) {
		int r1 = 0, r2= list.size(),c1=0, c2=list.size();
		while(r1<r2 && c1<c2) {
			for(int i=c1;i<c2;i++)
				System.out.print(list.get(r1).get(i) + " ");
			r1++;
			
			for(int i=r1;i<r2;i++)
				System.out.print(list.get(i).get(c2-1) + " ");
			c2--;
			
			if(r1<r2 ) {
				for(int i=c2-1;i>=c1;i--)
					System.out.print(list.get(r2-1).get(i) + " ");
			}
			r2--;
			
			if(c2>c1 ) {
				for(int i=r2-1;i>=r1;i--)
					System.out.print(list.get(i).get(c1) + " ");
			}
			c1++;
		}
	}
	
	public static ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<A;i++) {
        	ArrayList<Integer> li = new ArrayList<Integer>(A);
        	for(int j=0;j<A;j++)
        		li.add(0);
        	list.add(li);
        }
        
        int istart=0, ilast=A, jstart=0, jlast=A, value = 1;
        while(istart<ilast && jstart<jlast) {
            for(int i=jstart;i<jlast;i++)
                list.get(istart).set(i, value++);
            istart++;
            
            for(int i=istart;i<ilast;i++)
                list.get(i).set(jlast-1, value++);
            jlast--;
            
            if (ilast>istart) {
				for (int i = jlast - 1; i >= jstart; i--)
					list.get(ilast - 1).set(i, value++);
				ilast--;
			}
			if (jstart<jlast) {
				for (int i = ilast - 1; i >= istart; i--)
					list.get(i).set(jstart, value++);
				jstart++;
			}
        }
        return list;
    }
	
	public static void main(String [] args) {
//		int [][] mat = {{1,2,3,10},{8,9,4,11},{7,6,5,12}, {16,15,14,13}};
//		SpiralMatrix.SpiralOrder(mat);
		ArrayList<ArrayList<Integer>> li = SpiralMatrix.generateMatrix(3);
		SpiralMatrix.SpiralList(li);
	}
}
