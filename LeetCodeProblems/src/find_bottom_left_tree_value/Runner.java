package find_bottom_left_tree_value;

import helper.BasicFunctions;
import helper_binary_tree.TreeNode;

public class Runner {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        BasicFunctions.print(new Solution().findBottomLeftValue(root));
    }
}
