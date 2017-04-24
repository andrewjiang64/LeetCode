import java.util.Stack;


public class BuildTreeInPostOrder {
	  public static TreeNode buildTree(int[] inorder, int[] postorder)
	    {
		  if(inorder.length == 0 || postorder.length == 0)
			   return null;
		  Stack<TreeNode> stack = new Stack<TreeNode>();
		  int il = inorder.length - 1;
		  int pl = postorder.length - 1;
		  TreeNode pre = null;
		  TreeNode root = new TreeNode(postorder[pl]);
		  stack.push(root);
		  pl--;
		  while(pl >= 0)
		  {
			  while(!stack.isEmpty() && stack.peek().val == inorder[il])
			  {
				  pre = stack.pop();
				  il--;
			  }
			  TreeNode tmp = new TreeNode(postorder[pl]);
			  if(pre != null)
			  {
				 pre.left = tmp;
				 
			  }
			  else
			  {
				  TreeNode curr = stack.peek();
				  curr.right = tmp;
				 
			  }
			  stack.push(tmp);
			  pre = null;
			  pl--;
		  }
		  return root;
	    }
	   public static void main(String[] args)
	    {
	    
	    	int[] inOrder = new int[]{1,3,8,2,9,10,11};
	    	int[] postOrder = new int[]{1,8,3,9,11,10,2};
	    	TreeNode root = buildTree(inOrder, postOrder);
	    }
}
