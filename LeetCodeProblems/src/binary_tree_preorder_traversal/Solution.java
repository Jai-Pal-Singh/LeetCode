package binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;

import helper_binary_tree.TreeNode;
/* 
Given the root of a binary tree,return the preorder traversal of its nodes' values.

Example 1:

Input:root=[1,null,2,3]Output:[1,2,3]Example 2:

Input:root=[]Output:[]Example 3:

Input:root=[1]Output:[1]Example 4:

Input:root=[1,2]Output:[1,2]Example 5:

Input:root=[1,null,2]Output:[1,2]

Constraints:

The number of nodes in the tree is in the range[0,100].-100<=Node.val<=100

Follow up:Recursive solution is trivial,could you do it iteratively?
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
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null)
                preorderTraversal(root.left);
            if (root.right != null)
                preorderTraversal(root.right);
        }
        return res;
    }
}
