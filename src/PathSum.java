import java.util.Stack;


public class PathSum {
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(-2);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.left.left.left = new TreeNode(-1);
		root.right.left = new TreeNode(-2);
		System.out.println(hasPathSum(root,3));
	}
    public static boolean hasPathSum(TreeNode root, int sum) {
    	 if(root == null)
             return false;
          Stack<TreeNode> stack = new Stack<TreeNode>();
       
          stack.push(root);
          while(!stack.isEmpty())
          {
              TreeNode cur = stack.pop();
        
              if(cur.left == null && cur.right == null)
              {
                  if(cur.val == sum)
                    return true;
              }
               if(cur.right != null)
              {
                 cur.right.val = cur.right.val + cur.val;
                  stack.push(cur.right);
              }
              if(cur.left != null)
              {
            	  cur.left.val = cur.left.val + cur.val;
                  stack.push(cur.left);
              }
             
          }
          return false;
    }
}
