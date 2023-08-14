package LinkedList;

import LinkedList.Utils.ListNode;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		while (head != null) {
			if (head.value == val) {
				pre.next = head.next;
			} else {
                pre = pre.next;
            }
			head = head.next;
		}
		return dummy.next;
	}
}
