package maximum_depth_of_binary_tree;

import helper_binary_tree.TreeNode;

/**
 * Runner
 */
public class Runner {
        
	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		root.val = 3;
		
		root.left = new TreeNode(9);
		
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15); 
		root.right.right =  new TreeNode(7);
		
		Solution s = new Solution(); 
        System.out.println(s.maxDepth(root));   
    }
}