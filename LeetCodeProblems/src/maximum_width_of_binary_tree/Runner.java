package maximum_width_of_binary_tree;

import helper.BasicFunctions;
import helper_binary_tree.TreeNode;

public class Runner {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        BasicFunctions.print(new Solution().widthOfBinaryTree(root)); 
    }
}
