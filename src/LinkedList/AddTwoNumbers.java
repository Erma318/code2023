package LinkedList;
import LinkedList.Utils.ListNode;


public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode dummy = new ListNode(0);
    	ListNode node = dummy;
    	int addOne = 0;
    	while (l1 != null && l2 != null) {
    		int sum = l1.value + l2.value + addOne;
    		if (sum > 9) {
    			sum = sum - 10;
    			addOne = 1;
    		} else {
          addOne = 0;
        }
    		ListNode newNode = new ListNode(sum);
    		node.next = newNode;
    		l1 = l1.next; l2 = l2.next; node = node.next;  		
    	}
    	ListNode modify;
    	if (l1 != null) {
    		modify = l1;
    	} else {
    		modify = l2;
    	}
    	node.next = modify;
    	while (modify != null && addOne == 1) {
    		modify.value = modify.value + 1;
    		if (modify.value > 9) {
    			modify.value = modify.value - 10;
    			addOne = 1;
    		} else {
          addOne = 0;
        }
    		modify = modify.next;
    		node = node.next;
    	}
    	if (addOne == 1) {
    		node.next = new ListNode(1);
    	}
    	return dummy.next;
    }
    
    public static void main(String[] args) {
//    	ListNode nine = new ListNode(9);
//    	ListNode nine_2 = new ListNode(9);
//    	ListNode eight = new ListNode(8);
//    	nine.next = nine_2;
//    	nine_2.next = eight;
//    	
//    	ListNode one = new ListNode(1);
//    	ListNode three = new ListNode(3);
//    	ListNode four = new ListNode(4);
//    	ListNode two = new ListNode(2);
//    	one.next = three;
//    	three.next = four;
//    	four.next = two;
    	
    	
    	ListNode nine = new ListNode(9);
    	ListNode eight = new ListNode(8);
    	nine.next = eight;
    	
    	ListNode one = new ListNode(1);
    	ListNode one_2 = new ListNode(1);
    	one.next = one_2;
    	
        ListNode res = addTwoNumbers(nine, one);
        Utils.printList(res);
    	
    }
    

}
