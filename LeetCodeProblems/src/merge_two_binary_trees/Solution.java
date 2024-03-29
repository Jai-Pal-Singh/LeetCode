package merge_two_binary_trees;

import helper_binary_tree.TreeNode;
/* 
You are given two binary trees root1 and root2.

Imagine that when you put one of them to cover the other,some nodes of the two trees are overlapped while the others are not.You need to merge the two trees into a new binary tree.The merge rule is that if two nodes overlap,then sum node values up as the new value of the merged node.Otherwise,the NOT null node will be used as the node of the new tree.

Return the merged tree.

Note:The merging process must start from the root nodes of both trees.

Example 1:

Input:root1=[1,3,2,5],root2=[2,1,3,null,4,null,7]Output:[3,4,5,5,4,null,7]Example 2:

Input:root1=[1],root2=[1,2]Output:[2,2]

Constraints:

The number of nodes in both trees is in the range[0,2000].-104<=Node.val<=104
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return mergeTrees(root1, root2, null);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2, TreeNode currNode) {
        if (root1 == null && root2 == null)
            return null;
        else if (root1 != null && root2 != null) {
            currNode = new TreeNode(root1.val + root2.val);
            currNode.left = mergeTrees(root1.left, root2.left, currNode.left);
            currNode.right = mergeTrees(root1.right, root2.right, currNode.right);
        } else if (root1 != null)
            currNode = root1;
        else
            currNode = root2;
        return currNode;
    }
}
