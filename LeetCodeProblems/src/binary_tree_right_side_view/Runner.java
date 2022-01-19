package binary_tree_right_side_view;

import helper.ArrayFunctions;
import helper_binary_tree.TreeNode;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        ArrayFunctions.print(solution.rightSideView(root));
    }
}
