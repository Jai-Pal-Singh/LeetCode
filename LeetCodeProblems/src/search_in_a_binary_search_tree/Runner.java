package search_in_a_binary_search_tree;

import helper_binary_tree.TreeNode;

public class Runner {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        Solution sol = new Solution();
        TreeNode ans = sol.searchBST(root, 2);
        TreeNode.print(ans);
    }
}
