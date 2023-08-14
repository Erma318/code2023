package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementinanArray {
	     public static int findKthLargest(int[] array, int k) {
	    	int j = array.length - k + 1;
		    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, (Comparator<? super Integer>) new Comparator<Integer>(){
		      @Override
		      public int compare(Integer num1, Integer num2) {
		        if (num1.equals(num2)) {
		          return 0;
		        }
		        return num1 > num2 ? -1 : 1;
		      }
		    });
		    int i = 0;
		    for ( ; i < j; i++) {
		    	System.out.println(array[i]);
		      maxHeap.add(array[i]);
		    }
		    for ( ; i < array.length; i++) {
		      if (array[i] < maxHeap.peek()) {
		        maxHeap.poll();
		        System.out.println(array[i]);
		        maxHeap.add(array[i]);
		      }
		    }

		    return maxHeap.poll();
		  }
	     
	public static void main (String[] args) {
		int[] array = new int[] {8,10,2,7,4,2,13,19,6,3,3,4,5,0,-1,42,32,1,6,4};
		System.out.println(findKthLargest(array, 3));
	}
}
 