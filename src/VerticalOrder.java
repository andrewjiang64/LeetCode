import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;


public class VerticalOrder {
     public static void main(String[] args)
     {
    	 TreeNode root = new TreeNode(3);
 		root.left = new TreeNode(9);
 		root.right = new TreeNode(20);
 		
 		root.right.left = new TreeNode(15);
 		root.right.right = new TreeNode(7);
 		verticalOrder(root);
     }
	  public static List<List<Integer>> verticalOrder(TreeNode root) {
	        if(root == null)
	          return new ArrayList<List<Integer>>();
	        TreeMap<Integer,List<Integer>> map = new TreeMap<Integer, List<Integer>>();
	        List<List<Integer>> ret = new ArrayList<List<Integer>>();
	        Queue<TreeNode> queueTreenode = new LinkedList<TreeNode>();
	        Queue<Integer> queueTreenodecol = new LinkedList<Integer>();
	        ArrayList<Integer> rootList = new ArrayList<Integer>();
	        rootList.add(root.val);
	        map.put(0, rootList);
	        queueTreenode.offer(root);
	        queueTreenodecol.add(0);
	        while(!queueTreenode.isEmpty())
	        {
	            int size = queueTreenode.size();
	            for(int i = 0; i < size; i++)
	            {
	                TreeNode node = queueTreenode.poll();
	                int nodecol = queueTreenodecol.poll();
	                if(node.left != null)
	                {
	                    int leftcol = nodecol - 1;
	                    if(map.containsKey(leftcol))
	                    {
	                        List<Integer> list = map.get(leftcol);
	                        list.add(node.left.val);
	                    }
	                    else
	                    {
	                        ArrayList<Integer> list = new ArrayList<Integer>();
	                        list.add(node.left.val);
	                        map.put(leftcol, list);
	                    }
	                    queueTreenode.offer(node.left);
	                    queueTreenodecol.offer(nodecol - 1);
	                }
	                 if(node.right != null)
	                {
	                    int rightcol = nodecol + 1;
	                    if(map.containsKey(rightcol))
	                    {
	                        List<Integer> list = map.get(rightcol);
	                        list.add(node.right.val);
	                    }
	                    else
	                    {
	                        ArrayList<Integer> list = new ArrayList<Integer>();
	                        list.add(node.right.val);
	                        map.put(rightcol, list);
	                    }
	                    queueTreenode.offer(node.right);
	                    queueTreenodecol.offer(nodecol + 1);
	                }
	            }
	            
	        }
	        for (Map.Entry<Integer,List<Integer>> entry : map.entrySet()) {
	           List<Integer> value = entry.getValue();
	           ret.add(value);
	            
	        }
	        return ret;
	        
	    }
}
