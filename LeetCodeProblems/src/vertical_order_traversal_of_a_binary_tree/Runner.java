package vertical_order_traversal_of_a_binary_tree;

import helper.ArrayFunctions;
import helper_binary_tree.TreeNode;

public class Runner {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        ArrayFunctions.printList(new Solution().verticalTraversal(root));
    }
}
