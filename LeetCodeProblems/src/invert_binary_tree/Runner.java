package invert_binary_tree;

import helper_binary_tree.TreeNode;

public class Runner {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(0);
        root.left.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(10);
        root.right.left.left = new TreeNode(5);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(11);
        root.right.right.right = new TreeNode(13);
        root.left.left.left.left = new TreeNode(0);
        root.left.left.left.right = new TreeNode(5);
        root.left.left.right.left = new TreeNode(8);
        root.left.left.right.right = new TreeNode(10);
        root.left.right.left.left = new TreeNode(8);
        root.left.right.left.right = new TreeNode(10);
        root.left.right.right.left = new TreeNode(11);
        root.left.right.right.right = new TreeNode(13);
        root.right.left.left.left = new TreeNode(5);
        root.right.left.left.right = new TreeNode(8);
        root.right.left.right.left = new TreeNode(11);
        root.right.left.right.right = new TreeNode(13);
        root.right.right.left.left = new TreeNode(11);
        root.right.right.left.right = new TreeNode(13);
        root.right.right.right.left = new TreeNode(14);
        root.right.right.right.right = new TreeNode(15);
        helper_binary_tree.TreeNode.print(new Solution().invertTree(root));
    }
}
