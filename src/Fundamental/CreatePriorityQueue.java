package Fundamental;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CreatePriorityQueue {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1.equals(o2)) {
					return 0;
				}
				return o1 > o2 ? -1 : 1;
			}
			
		});
		
		PriorityQueue<Integer> pq2 = new PriorityQueue<>((o1, o2) -> o1 - o2);
	}
}
