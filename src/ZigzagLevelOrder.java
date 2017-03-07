import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class ZigzagLevelOrder {
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = null;
		root.right.left = null;
		root.right.right = new TreeNode(5);
		List<List<Integer>> list = zigzagLevelOrder(root);
		System.out.println(list);
	}
	   public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        ArrayList<List<Integer>> list = new  ArrayList<List<Integer>>();
	        if(root == null)
	          return list;
	        queue.offer(root);
	        int index = 1;
	        while(!queue.isEmpty())
	        {
	        	int levelNum = queue.size();
	            LinkedList<Integer> linkedList = new LinkedList<Integer>();
	            for(int i = 0; i < levelNum; i++)
	            {
	               TreeNode node = queue.poll();
	               if(index % 2 == 0)
	               {
	            	   linkedList.add(0, node.val);
	               }
	               else
	               {
	            	   linkedList.add(node.val);
	               }
	               if(node.left != null)
	            	   queue.add(node.left);
	               if(node.right != null)
	            	   queue.add(node.right);
	                  
	            }
	            index++;
	            list.add(linkedList);
	            
	        }
	        return  list;
	    }
}
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; left = null; right = null; }
 }