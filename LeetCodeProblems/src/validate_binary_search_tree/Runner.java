package validate_binary_search_tree;

import helper_binary_tree.TreeNode;

public class Runner {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        helper.BasicFunctions.print(new Solution().isValidBST(root));
    }
}
