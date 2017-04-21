import java.util.Stack;
public class LowestCommonAncestor {
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		lowestCommonAncestor(root, new TreeNode(2), new TreeNode(1));
	}
	  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		  if(root == null)
		         return root;
		   TreeNode node = null;
		       while(root != null)
		       {
		    	   if(root.val > p.val && root.val > q.val)
		    		    root = root.left;
		    	   if(root.val < q.val && root.val < p.val)
		    		   root = root.right;
		    	   else 
		    		   node = root;
		       }
		       return node;
	    }
}
