package construct_binary_tree_from_preorder_and_inorder_traversal;

import helper_binary_tree.TreeNode;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode.print(solution.buildTree(preorder, inorder));
    }
}
