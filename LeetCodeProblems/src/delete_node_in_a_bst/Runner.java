package delete_node_in_a_bst;

import helper_binary_tree.TreeNode;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        TreeNode result = solution.deleteNode(root, 3);
        TreeNode.printNode(result);
    }
}
