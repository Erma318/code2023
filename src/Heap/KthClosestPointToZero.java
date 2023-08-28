package Heap;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class KthClosestPointToZero {
	  public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
	      PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(2 * k, new Comparator<List<Integer>>() {
		      @Override
		      public int compare(List<Integer> o1, List<Integer> o2) {
		        long d1 = distance(o1, a, b, c);
		        long d2 = distance(o2, a, b, c);
		        if (d1 == d2) {
		          return 0;
		        }
		        return d1 < d2 ? -1 : 1;
		      }
	      });
	      Set<List<Integer>> visited = new HashSet<>();
	      List<Integer> cur = Arrays.asList(0, 0, 0);
	      visited.add(cur);
	      minHeap.offer(cur);
	      while(k > 0) {
	        cur = minHeap.poll();
	        List<Integer> n = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
	        if (n.get(0) < a.length && visited.add(n)) {
	          minHeap.offer(n);
	        }
	        n = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
	        if (n.get(1) < b.length && visited.add(n)) {
	          minHeap.offer(n);
	        }
	        n = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
	        if (n.get(2) < c.length && visited.add(n)) {
	          minHeap.offer(n);
	        }
	        k--;
	      }
	      cur.set(0, a[cur.get(0)]);
	      cur.set(1, b[cur.get(1)]);
	      cur.set(2, c[cur.get(2)]);
	      return cur;
		}
		private long distance(List<Integer> point, int[] a, int[] b, int[] c) {
		  	long dis = 0;
		  	dis += a[point.get(0)] * a[point.get(0)];
			dis += b[point.get(1)] * b[point.get(1)];
			dis += b[point.get(2)] * b[point.get(2)];
			return dis;
	    }
}
