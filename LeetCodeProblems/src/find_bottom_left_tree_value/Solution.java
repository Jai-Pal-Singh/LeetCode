package find_bottom_left_tree_value;

import helper_binary_tree.TreeNode;

/**
 * Given the root of a binary tree, return the leftmost value in the last row of
 * the tree.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [2,1,3]
 * Output: 1
 * Example 2:
 * 
 * 
 * Input: root = [1,2,3,4,null,5,6,null,null,7]
 * Output: 7
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 */

public class Solution {
    int ans = 0;
    int height = 0;

    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 1);
        return ans;
    }

    public void findBottomLeftValue(TreeNode root, int depth) {
        if (height < depth) {
            ans = root.val;
            height = depth;
        }
        if (root.left != null)
            findBottomLeftValue(root.left, depth + 1);
        if (root.right != null)
            findBottomLeftValue(root.right, depth + 1);
    }
}
