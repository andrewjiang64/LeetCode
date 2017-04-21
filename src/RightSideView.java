import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class RightSideView {
	public static void main(String[] args)
	{
	    TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.left.right = null;
	    root.left.left.left = null;
	    root.left.left.right = null;
	    root.right.left = null;
	    root.right.right = null;
	    rightSideView(root);
	}
	 public static List<Integer> rightSideView(TreeNode root) {
	        List<Integer> ret = new ArrayList<Integer>();
	        if(root == null)
	            return ret;
	         Stack<TreeNode> stack = new Stack<TreeNode>();
	         Queue<TreeNode> queue = new LinkedList<TreeNode>();
	         queue.offer(root);
	         stack.push(root);
	         while(!queue.isEmpty())
	         {
	             int size = queue.size();
	            int val = stack.peek().val;
	            ret.add(val);
	            for(int i = 0; i < size; i++)
	            {
	                TreeNode tmp = queue.poll();
	             //    stack.pop();
	                  if(tmp.left != null)
	                  {
	                      queue.offer(tmp.left);
	                      stack.push(tmp.left);
	                  }
	                  if(tmp.right != null)
	                  {
	                      queue.offer(tmp.right);
	                      stack.push(tmp.right);
	                  }
	            }
	         }
	         return ret;
	    }
}
