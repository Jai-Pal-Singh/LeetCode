package two_sum_iv_input_is_a_bst;

import helper.BasicFunctions;
import helper_binary_tree.TreeNode;

public class Runner {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        BasicFunctions.print(new Solution().findTarget(root, 9));
    }
}
