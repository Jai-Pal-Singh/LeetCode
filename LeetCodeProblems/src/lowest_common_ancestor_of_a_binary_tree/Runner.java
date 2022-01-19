package lowest_common_ancestor_of_a_binary_tree;

import helper_binary_tree.TreeNode;

public class Runner {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(10);
        root.right.right.left = new TreeNode(11);
        root.right.right.right = new TreeNode(12);
        Solution solution = new Solution();
        TreeNode.printNode(solution.lowestCommonAncestor(root, root.right, root.right.right));
    }
}
