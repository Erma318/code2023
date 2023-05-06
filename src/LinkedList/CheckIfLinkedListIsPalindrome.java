package LinkedList;

import java.util.Deque;
import java.util.LinkedList;
import LinkedList.Utils.ListNode;

public class CheckIfLinkedListIsPalindrome {
	public boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		Deque<Integer> stack = new LinkedList<>();

		while (fast.next != null && fast.next.next != null) {
			stack.addFirst(slow.value);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if (fast.next != null && fast.next.next == null) {
			// even, add the current slow into stack.
			stack.addFirst(slow.value);
		}
		while (slow != null && !stack.isEmpty()) {
			if (slow.value != stack.removeFirst()) {
				return false;
			}
			slow = slow.next;
		}
		if (slow != null || !stack.isEmpty()) {
			return false;
		}
		return true;
	}

}
