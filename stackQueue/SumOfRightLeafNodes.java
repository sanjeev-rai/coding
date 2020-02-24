package stackQueue;

public class SumOfRightLeafNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		GfG g = new GfG();
		int val = g.rightLeafSum(root);
		System.out.println(val);
	}

}

class GfG{
    public int rightLeafSum(Node root)
    {
      //add code here.
        if(root == null)
            return 0;
        int Lval = 0, Rval = 0;
        if(root.right != null) {
            if(root.right.left == null && root.right.right == null)
                Rval = root.right.data;
            else
                Rval = rightLeafSum(root.right);
        }
        if(root.left != null)
            Lval = rightLeafSum(root.left);
        return Lval + Rval;
    }
}

class Node {
	int data;
	Node left,right;
	
	public Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}