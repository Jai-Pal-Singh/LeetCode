package path_sum;

import helper_binary_tree.TreeNode;

public class Runner {

	public static void main(String[] args) {
		TreeNode root = new TreeNode();
//		root.val = 3;
//		
//		root.left = new TreeNode(9);
//		
//		root.right = new TreeNode(20);
//		root.right.left = new TreeNode(15); 
//		root.right.right =  new TreeNode(7);
//		root.val = 1;		
//		root.left = new TreeNode(2);
		root.val = -2;		
		root.right = new TreeNode(-3);
		helper.BasicFunctions.print(new Solution().hasPathSum(root, -5));
	}

}
