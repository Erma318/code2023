package BFS;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class WallsAndGates {
	  public static int[][] wallsAndGates(int[][] rooms) {
		    int m = rooms.length, n = rooms[0].length;
		    for (int i = 0; i < m; i++) {
		      for (int j = 0; j < n; j++) {
		        if (rooms[i][j] == Integer.MAX_VALUE) {
		          rooms[i][j] = findDistance(rooms, i, j);
		          System.out.println(rooms[i][j]);
		        }
		      }
		    }
		    return rooms;
		  }

		  private static int findDistance(int[][] rooms, int x, int y) {
		    int m = rooms.length, n = rooms[0].length;
		    int[][] visited = new int[m][n];
		    int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
		    int res = 0;
		    Deque<int[]> queue = new LinkedList<>();
		    queue.addFirst(new int[]{x, y});
		    while (!queue.isEmpty()) {
		      int size = queue.size();
		      for (int i = 0; i < size; i++) {
		    	
		        int[] cur = queue.pollLast();
		       
		        int a = cur[0];
		        int b = cur[1];
		        visited[a][b] = 1;
		        if (rooms[a][b] == 0) {
		          return res;
		        }
		        if (rooms[a][b] != -1) {
		          for (int j = 0; j < 4; j++) {
		            if (a + directions[j][0] < m && a + directions[j][0] >= 0 && b + directions[j][1] < n && b + directions[j][1] >= 0) {
		            	if (visited[a + directions[j][0]][b + directions[j][1]] == 0) {
		 		              queue.addFirst(new int[]{a + directions[j][0], b + directions[j][1]});
		            	}
		            }
		          }
		        }
		      }
		      res++;
		    }
		    return res;
		  }
		  

		  
	public static  void main(String[] args) {
		//int[][] test = new int[][]{{-1,0,0,-1,-1,-1,2147483647,0,0,2147483647,2147483647,0,2147483647,-1,2147483647,2147483647,0,2147483647,0,0,-1,0,-1,2147483647,0,0,-1,0,-1,-1,0,2147483647,-1,0,-1,2147483647,2147483647,2147483647,0,0,-1,-1,-1,-1,-1,2147483647},{2147483647,-1,-1,0,2147483647,0,-1,-1,-1,2147483647,-1,2147483647,0,2147483647,0,2147483647,-1,0,2147483647,2147483647,0,-1,2147483647,2147483647,0,2147483647,0,2147483647,-1,-1,2147483647,-1,-1,2147483647,-1,0,-1,-1,0,0,-1,2147483647,0,2147483647,0,0},{2147483647,2147483647,2147483647,2147483647,0,-1,2147483647,0,-1,2147483647,2147483647,2147483647,0,-1,0,-1,-1,2147483647,-1,0,2147483647,-1,-1,0,-1,-1,-1,2147483647,2147483647,0,0,2147483647,0,2147483647,2147483647,0,0,0,2147483647,2147483647,2147483647,0,2147483647,2147483647,0,0},{0,-1,0,2147483647,-1,0,0,2147483647,-1,-1,-1,0,2147483647,2147483647,0,2147483647,-1,-1,0,-1,0,0,0,-1,2147483647,2147483647,0,-1,-1,2147483647,-1,-1,2147483647,0,-1,0,-1,-1,-1,-1,2147483647,0,2147483647,0,-1,-1},{2147483647,0,-1,-1,2147483647,-1,-1,-1,2147483647,0,-1,0,0,0,2147483647,0,2147483647,0,0,-1,-1,0,-1,-1,0,-1,-1,2147483647,-1,0,-1,0,2147483647,-1,0,2147483647,2147483647,-1,0,0,2147483647,0,2147483647,2147483647,-1,0}};
		
		int[][] test = new int[][] {{2147483647, -1, 0, 2147483647}, {2147483647,2147483647,2147483647,-1}, {2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
		System.out.println(Arrays.deepToString(wallsAndGates(test)));
	}
}
