package binary_tree_zigzag_level_order_traversal;

import helper.ArrayFunctions;
import helper_binary_tree.TreeNode;

/**
 * Runner
 */
public class Runner {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        ArrayFunctions.printList(solution.zigzagLevelOrder(root));
    }
}