package tree;

public class Trees {

	public static void inOrderTraversal(Node root) {
		if(root != null) {
			inOrderTraversal(root.left);
			System.out.print(root.data +" ");
			inOrderTraversal(root.right);
		}
	}
	
	public static void preOrderTraversal(Node root) {
		if(root != null) {
			System.out.print(root.data +" ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}
	
	public static void postOrderTraversal(Node root) {
		if(root != null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.data +" ");
		}
	}
	
	public static Node TreeWithInorderAndPreOrder(int [] inOrder, int [] preOrder) {
		if(inOrder == null || preOrder == null)
			return null;
		if(inOrder.length != preOrder.length)
			return null;
		return createTree(inOrder, 0, inOrder.length, preOrder, 0, preOrder.length);
	}
	
	private static Node createTree(int [] inOrder, int inStart, int inEnd, int [] preOrder, int preStart, int preEnd) {
		if(inEnd > inStart) {
			int data = preOrder[preStart];
			Node root = new Node(data);
			int i = inStart;
			for(;i<inEnd;i++) 
				if(inOrder[i] == data)
					break;
			if(i==inEnd)
				return null;
			root.left = createTree(inOrder, inStart, i, preOrder, preStart+1, preStart +1 + i - inStart );
			root.right = createTree(inOrder, i+1, inEnd, preOrder, preStart +1 + i - inStart, preEnd);
			return root;	
		}
		return null;
	}
}
