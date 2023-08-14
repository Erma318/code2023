package Recursion;

public class ReverseLinkedListInPairs {
	
	class ListNode {
	   public int value;
	   public ListNode next;
	   public ListNode(int value) {
	     this.value = value;
	     next = null;
	   }
	}

	
	public ListNode reverseInPairs(ListNode head) {
		return reverse(head);
	}
	
	
	private ListNode reverse(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		ListNode i = head;
		ListNode j = head.next;
		ListNode k = reverse(head.next.next);
		i.next = k;
		j.next = i;
		return j;
	}
}

