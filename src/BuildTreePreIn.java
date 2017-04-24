import java.util.Stack;


public class BuildTreePreIn {
    public static TreeNode buildTree(int[] preOrder, int[] inOrder)
    {
    	TreeNode root = null;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	if(preOrder == null || preOrder.length == 0)
    		 return root;
    	root = new TreeNode(preOrder[0]);
    	stack.push(root);
    	int index = 0;
    	for(int i = 1; i < preOrder.length; i++)
    	{
    		TreeNode tmp = stack.peek();
    		if(tmp.val != inOrder[index])
    		{
    			tmp.left = new TreeNode(preOrder[i]);
    			stack.push(tmp.left);
    		}
    		else
    		{
    			while(!stack.isEmpty() && (stack.peek().val == inOrder[index]))
    			{
    				tmp = stack.pop();
    				index++;
    			}
    			if(index < inOrder.length)
    			{
    				tmp.right = new TreeNode(preOrder[i]);
    				stack.push(tmp.right);
    			}
    		}
    	}
    	return root;
    }
    public static void main(String[] args)
    {
    	int[] preOrder = new int[]{1,2,3};
    	int[] inOrder = new int[]{3,2,1};
    	TreeNode root = buildTree(preOrder, inOrder);
    }
}
/*TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder) {
    TreeNode *root=NULL; stack<TreeNode *> MyData;
    if(preorder.empty()) return root;
    root = new TreeNode(preorder[0]);
    MyData.push(root); int index = 0;
   	for(int i=1; i<=preorder.size(); i++) {
   		TreeNode *cur = MyData.top();
   		if((MyData.top()->val)!=inorder[index]) {
   			cur->left = new TreeNode(preorder[i]);
   			MyData.push(cur->left);
   		} else {
   			while(!MyData.empty() && ((MyData.top()->val)==inorder[index])) {
   				cur=MyData.top(); MyData.pop(); index++; 
   			}
   			if(index<inorder.size()) {
   				cur->right = new TreeNode(preorder[i]);
   				MyData.push(cur->right);
   			} 
   		}  
   	}
   	return root;
}*/