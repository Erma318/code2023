package Tree;

public class StoreNumberOfNodesInLeftSubtree {
	
	
	 public class TreeNodeLeft {
	   public int key;
	   public TreeNodeLeft left;
	   public TreeNodeLeft right;
	   public int numNodesLeft;
	   public TreeNodeLeft(int key) {
	     this.key = key;
	   }
	 }
	  public void numNodesLeft(TreeNodeLeft root) {
		    if (root == null) {
		      return;
		    }
		    nodesNum(root);
	}
		  // the method return the total node number of under this root, including root
		  private int nodesNum(TreeNodeLeft root) {
		    if (root == null) {
		      return 0;
		    }
		    int left = nodesNum(root.left);
		    root.numNodesLeft = left;
		    return left + 1 + nodesNum(root.right);
	}
}
