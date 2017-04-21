import java.util.LinkedList;
import java.util.Queue;


public class DistanceBetweenTwoNode {
	public static int depth(TreeNode root, int n)
	{
	   if(root == null)
		   return 0;
	   Queue<TreeNode> queue = new LinkedList<TreeNode>();
	   int depth = 0;
	   queue.offer(root);
	   while(!queue.isEmpty())
	   {
		   int size = queue.size();
		   for(int i = 0; i < size; i++)
		   {
			   TreeNode node = queue.poll();
			   if(node.val == n)
				   return depth;
			   if(node.left != null)
				   queue.offer(node.left);
			   if(node.right != null)
				   queue.offer(node.right);
		   }
		   if(size > 0)
			   depth = depth + 1;
	   }
	   return depth;
	}
	
    public static TreeNode findLCA(TreeNode root, int n1, int n2)
    {
    	if(root != null)
    	{
    		if(root.val == n1 || root.val == n2)
    		{
    			return root;
    		}
    		TreeNode left = findLCA(root.left, n1, n2);
    		TreeNode right = findLCA(root.right, n1, n2);
    		if(left != null && right != null)
    		{
    			return root;
    		}
    		if(left !=  null)
    			return left;
    		if(right != null)
    			 return right;
    	}
    	return null;
    }
    public static void main(String[] args) throws java.lang.Exception {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(10);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(25);
		root.right.left = new TreeNode(30);
		root.right.right = new TreeNode(35);
		root.left.right.right = new TreeNode(45);
		int depth1 = depth(root, 45);
		int depth2 = depth(root,20);
		int common = findLCA(root,45,20 ).val;
		int commonDepth = depth(root,common);
		int length = depth1 + depth2 - 2 * commonDepth;
		System.out.println(length);
	}
}
