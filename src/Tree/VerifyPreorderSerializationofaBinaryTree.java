package Tree;


import java.util.Deque;
import java.util.LinkedList;

public class VerifyPreorderSerializationofaBinaryTree {
	static class Node {
		String value;
		String left;
		String right;
		public Node (String value) {
			this.value = value;
		}
		public Node(String value, String left, String right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
		
	}
	
    public static boolean isValidSerialization(String preorder) {
        Deque<Node> stack = new LinkedList<>();
        String[] pre = preorder.split(",");
        for (int i = 0; i < pre.length; i++) {
        	if (i == 0) {
        		if (!pre[i].equals("#")) stack.offerFirst(new Node(pre[i]));
        	} else {
        		if (stack.isEmpty()) {
            		return false;
            	} else {
            		Node temp = stack.peekFirst();
            		if (temp.left == null) {
            			temp.left = pre[i];
            		} else {
            			stack.pollFirst();
            		}
            		if (!pre[i].equals("#")) stack.offerFirst(new Node(pre[i]));
            	}  
        	}
        	 
        }
        if (stack.isEmpty()) {
        	return true;
        } else {
        	return false;
        }
    }
	
    public static void main(String[] args) {
        String preorder = "1,#";
        System.out.println(isValidSerialization(preorder));
    }
}
