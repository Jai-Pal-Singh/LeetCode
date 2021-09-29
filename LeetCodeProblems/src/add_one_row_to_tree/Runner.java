package add_one_row_to_tree;

import helper_binary_tree.TreeNode;

public class Runner {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right= new TreeNode(1);

        root.right  = new TreeNode(6);
        root.right.left  = new TreeNode(5);

        Solution s = new Solution();
        s.addOneRow(root, 1, 4);
    }
}
