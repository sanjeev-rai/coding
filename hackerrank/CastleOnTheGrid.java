package hackerrank;

import java.io.*;
import java.util.*;


public class CastleOnTheGrid {

    // Complete the minimumMoves function below.
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
    	int n = grid.length;
    	int [][] res = new int [n][n];
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++)
    			res[i][j] = Integer.MAX_VALUE;
    	}
    	Queue<Cell> q = new LinkedList<Cell>();
    	q.add(new Cell(startX, startY, 0, res));
    	q.add(null);
    	while(!q.isEmpty()) {
    		Cell c = q.remove();
    		if(c == null) {
    			if(!q.isEmpty())
    				q.add(null);
    			continue;
    		}
    		int x = c.x,y = c.y, val = c.val + 1;
    		for(int i=x+1;i<n;i++) {
    			if(grid[i].charAt(y) == 'X')
    				break;
    			int newVal = Math.min(res[i][y], val);
    			if(newVal == res[i][y])
    				break;
    			else 
    				q.add(new Cell(i,y,newVal,res));
    		}
    		
    		for(int i=x-1;i>=0;i--) {
    			if(grid[i].charAt(y) == 'X')
    				break;
    			int newVal = Math.min(res[i][y], val);
    			if(newVal == res[i][y])
    				break;
    			else
    				q.add(new Cell(i,y,newVal,res));
    		}
    		
    		for(int i=y+1;i<n;i++) {
    			if(grid[x].charAt(i) == 'X')
    				break;
    			int newVal = Math.min(res[x][i], val);
    			if(newVal == res[x][i])
    				break;
    			else
    				q.add(new Cell(x,i,newVal,res));
    		}
    		
    		for(int i=y-1;i>=0;i--) {
    			if(grid[x].charAt(i) == 'X')
    				break;
    			int newVal = Math.min(res[x][i], val);
    			if(newVal == res[x][i])
    				break;
    			else
    				q.add(new Cell(x,i,newVal,res));
    		}
    		
    	}	
    	return res[goalX][goalY];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

class Cell {
	int x,y,val;
	
	public Cell(int x, int y, int val, int [][] res) {
		this.x = x;
		this.y = y;
		this.val = val;
		res[x][y] = val;
	}
	
//	public static Cell getCell(int x, int y, int val, int n) {
//		Cell cell = null;
//		if(x >=0 && x<n && y>=0 && y<n)
//			cell = new Cell(x,y,val);
//		return cell;
//	}
}

