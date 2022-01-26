package binary_tree_maximum_path_sum;

import helper.BasicFunctions;
import helper_binary_tree.TreeNode;

public class Runner {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        BasicFunctions.print(new Solution().maxPathSum(root));
    }
}
