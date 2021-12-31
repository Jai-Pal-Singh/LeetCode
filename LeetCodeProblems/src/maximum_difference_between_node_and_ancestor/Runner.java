package maximum_difference_between_node_and_ancestor;

import helper.BasicFunctions;
import helper_binary_tree.TreeNode;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(8, new TreeNode(3, new TreeNode(1), new TreeNode(6)), new TreeNode(10, new TreeNode(14), new TreeNode(4, new TreeNode(7), new TreeNode(13))));
        BasicFunctions.print(solution.maxAncestorDiff(root));
    }
}
