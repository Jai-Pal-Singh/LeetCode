package construct_binary_tree_from_inorder_postorder_traversal;

import helper_binary_tree.TreeNode;

public class Runner {
    public static void main(String[] args) {

        // TreeNode root = new TreeNode(4);
        // root.left = new TreeNode(2);
        // root.left.left = new TreeNode(3);
        // root.left.right= new TreeNode(1);

        // root.right  = new TreeNode(6);
        // root.right.left  = new TreeNode(5);
        // System.out.println("Sample tree");
        // TreeNode.print(root);
        // System.out.println();

        // int[] inorder = {9,3,15,20,7};
        // int[] postorder = {9,15,7,20,3};
        int[] inorder = {1,2,3,4};
        int[] postorder = {2,1,4,3};
        Solution s = new Solution();
        TreeNode.print(s.buildTree(inorder, postorder));
    }
}