import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class PathSumII {
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)
           return new ArrayList<List<Integer>>();
        List<List<Integer>> array = new ArrayList<List<Integer>>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new LinkedList<Integer>();
        TreeNode cur = root;
        int pathsum = 0;
        TreeNode pre = null;
        while(!stack.isEmpty() || cur != null)
        {
          while(cur != null)
          {
        	stack.push(cur);
        	pathsum = pathsum + cur.val;
        	list.add(cur.val);
        	cur = cur.left;
          }
          cur = stack.peek();
          if(cur.right != null && cur.right != pre)
          {
        	  cur = cur.right;
        	  continue;
          }
          if(cur.left == null && cur.right == null)
          {
        	  if(pathsum == sum)
        		  array.add(new ArrayList<Integer>(list));
          }
          pre = cur;
          stack.pop();
          pathsum = pathsum - cur.val;
          list.remove(list.size() - 1);
          cur = null;
        }
        return array;
    }
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		System.out.println(pathSum(root,22));
	}
}
