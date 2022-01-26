package all_elements_in_two_binary_search_trees;

import helper.ArrayFunctions;
import helper_binary_tree.TreeNode;

public class Runner {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        ArrayFunctions.print(new Solution().getAllElements(root1, root2));
    }
}
