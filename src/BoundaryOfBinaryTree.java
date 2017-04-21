import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BoundaryOfBinaryTree {
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(4);
		boundaryOfBinaryTree(root);
		
	}
	 public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
	        List<Integer> ret = new ArrayList<Integer>();
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        List<Integer> left = new ArrayList<Integer>();
	        List<Integer> leaves = new ArrayList<Integer>();
	        List<Integer> right = new ArrayList<Integer>();
	        if(root == null)
	           return ret;
	        queue.offer(root);
	        while(!queue.isEmpty())
	        {
	            int size = queue.size();
	            for(int i = 0; i < size; i++)
	            {
	                 TreeNode node = queue.poll();
	                 if(i == 0)
	                 {
	                	 if(!isLeaf(node))
	                		 left.add(node.val);
	                 }
	                 else if(i == size - 1)
	                 {
	                	 if(!isLeaf(node))
	                		 right.add(node.val);
	                 }
	                 if(isLeaf(node))
	                    leaves.add(node.val);
	                 if(node.left != null)
	                 {
	                     queue.offer(node.left);
	                    
	                 }
	                 if(node.right != null)
	                 {
	                     queue.offer(node.right);
	                 }
	            }
	            
	        }
	        for(int i = 0; i < left.size(); i++)
	            ret.add(left.get(i));
	        for(int i = 0; i < leaves.size(); i++)
	            ret.add(leaves.get(i));
	        for(int i = right.size() - 1; i >= 0; i--)
	            ret.add(right.get(i));
	        return ret;
	    }
	    public static boolean isLeaf(TreeNode node)
	    {
	        if(node.left == null && node.right == null)
	          return true;
	         return false;
	    }
}
