package LinkedList;
import LinkedList.Utils.ListNode;

public class MergeSortLinkedList {
	
	public static ListNode mergeSort(ListNode head) {
		return sort(head);
	}
	
	private static ListNode sort(ListNode head) {
		if (head.next == null) {
			return head;
		}
		ListNode midPrevious = findMidPrevious(head);
		ListNode mid = midPrevious.next;
		midPrevious.next = null;
		ListNode newHead = sort(head);
		ListNode newMid = sort(mid);
		return merge(newHead, newMid);
	}
	
	private static ListNode findMidPrevious(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	private static ListNode merge(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		ListNode head = dummy;
		while (a != null && b != null) {
			if (a.value <= b.value) {
				head.next = a;
				a = a.next;
			} else {
				head.next = b;
				b = b.next;
			}
			head = head.next;
		}
		if (a != null) {
			head.next = a;
		} else {
			head.next = b;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode four = new ListNode(4);
		ListNode two = new ListNode(2);
		ListNode six = new ListNode(6);
		ListNode negative_three = new ListNode(-3);
		ListNode five = new ListNode(5);
		four.next = two;
		two.next = six;
		six.next = negative_three;
		negative_three.next = five;
		ListNode newHead = mergeSort(four);
		Utils.printList(newHead);
	}


}
