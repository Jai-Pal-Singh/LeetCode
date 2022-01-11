package sum_of_root_to_leaf_binary_numbers;

import helper_binary_tree.TreeNode;

public class Runner {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        helper.BasicFunctions.print(s.sumRootToLeaf(root));
    }
}
