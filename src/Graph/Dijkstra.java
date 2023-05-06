package Graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
	static class NodeDistance{
		public int index;
		public int distance;
		NodeDistance(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		
	}
	
	static class Node {
		public int index;
		public List<NodeDistance> connect;
		Node(int index) {
			this.index = index;
			this.connect = new LinkedList<NodeDistance>();
		}
	}
	
	public static void main(String[] args) {
		Node one = new Node(1);
		one.connect.add(new NodeDistance(2, 4));
		one.connect.add(new NodeDistance(4, 2));
		Node two = new Node(2);
		two.connect.add(new NodeDistance(3, 4));
		two.connect.add(new NodeDistance(4, 1));
		Node three = new Node(3);
		three.connect.add(new NodeDistance(5, 3));
		Node four = new Node(4);
		four.connect.add(new NodeDistance(5, 7));
		four.connect.add(new NodeDistance(3, 1));
		//four.connect.add(new NodeDistance(2, 1));
		Node five = new Node(5);
		Node[] nodes = {one, two, three, four, five};
		System.out.println(findShortest(1, 2, nodes));
		System.out.println(findShortest(1, 3, nodes));
		System.out.println(findShortest(1, 4, nodes));
		System.out.println(findShortest(1, 5, nodes));
	
	}
	
	public static int findShortest(int start, int target, Node[] nodes) {
		Map<Integer, Integer> shortestMap = new HashMap<>();
		PriorityQueue<NodeDistance> pq = new PriorityQueue<>(new Comparator<NodeDistance>() {
			@Override
			public int compare(NodeDistance a, NodeDistance b) {
				return a.distance - b.distance;
			}
		});
		pq.add(new NodeDistance(start, 0));
		while (!pq.isEmpty()) {
			NodeDistance done = pq.poll();
			shortestMap.put(done.index, done.distance);
			if (done.index == target) {
				return done.distance;
			}
			shortestMap.put(done.index, done.distance);
			for (NodeDistance nd : nodes[done.index - 1].connect) {
				if (!shortestMap.containsKey(nd.index)) {
					pq.add(new NodeDistance(nd.index, nd.distance + done.distance));
				}
				
			}
		}
		
		return -1;
	}
}
