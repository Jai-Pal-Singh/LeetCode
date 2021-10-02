package search_in_a_binary_search_tree;

import helper_binary_tree.TreeNode;

// You are given the root of a binary search tree (BST) and an integer val.

// Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

 

// Example 1:


// Input: root = [4,2,7,1,3], val = 2
// Output: [2,1,3]
// Example 2:


// Input: root = [4,2,7,1,3], val = 5
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [1, 5000].
// 1 <= Node.val <= 107
// root is a binary search tree.
// 1 <= val <= 107

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root.val == val){
            return root;
        }
        else if(root.val > val && root.left != null){
            return searchBST(root.left, val);
        }
        else if(root.val < val && root.right != null){
            return searchBST(root.right, val);
        }
        else{
            return null;
        }
        
    }
}