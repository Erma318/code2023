package LinkedList;


public class Utils {
	public static class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value = value;
			next = null;
		}
	} 
	
	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.value);
			System.out.print(" -> ");
			head = head.next;
		}
		System.out.println();
	}

}
