package tree;

public class TreeDemo {
	
	public static void main(String [] args) {
		int [] in = {1,2,3,4,5,6};
		int [] pre = {3,2,1,5,4,6};
		
		Node root = Trees.TreeWithInorderAndPreOrder(in, pre);
		Trees.postOrderTraversal(root);
	}
}
