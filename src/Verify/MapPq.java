package Verify;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MapPq {
	static class NodeDistance{
		public int index;
		public int distance;
		NodeDistance(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		
	}
	public static void main(String[] args) {
		Map<Integer, NodeDistance> map = new HashMap<>();
		PriorityQueue<NodeDistance> pq = new PriorityQueue<>(new Comparator<NodeDistance>() {
			@Override
			public int compare(NodeDistance a, NodeDistance b) {
				return a.distance - b.distance;
			}
		});
		map.put(1, new NodeDistance(1, 0));
		map.put(2, new NodeDistance(2, 6));
		map.put(3, new NodeDistance(3, 10));
		map.put(4, new NodeDistance(4, 8));
		pq.add(map.get(1)); pq.add(map.get(2)); pq.add(map.get(3)); pq.add(map.get(4));
		System.out.println(pq.poll().index);
		map.get(3).distance = 5;
		System.out.println(pq.poll().index);
		map.get(4).distance = 4;
		System.out.println(pq.poll().index);
		System.out.println(pq.size());
		System.out.println(pq.poll().index);
	}

}
