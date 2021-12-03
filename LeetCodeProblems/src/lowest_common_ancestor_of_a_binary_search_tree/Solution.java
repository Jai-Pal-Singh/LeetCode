package lowest_common_ancestor_of_a_binary_search_tree;

import java.util.ArrayList;
import java.util.List;

import helper_binary_tree.TreeNode;

/* 
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [2,1], p = 2, q = 1
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the BST.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pAncestors = new ArrayList<>();
        List<TreeNode> qAncestors = new ArrayList<>();
        findAllAncestors(root, p, pAncestors);
        findAllAncestors(root, q, qAncestors);
        return findLowestCommonAncestor(pAncestors, qAncestors);
    }

    public void findAllAncestors(TreeNode root, TreeNode node, List<TreeNode> nodeList) {
        if (root != null) {
            nodeList.add(root);
            if (root.val > node.val)
                findAllAncestors(root.left, node, nodeList);
            else if (root.val < node.val)
                findAllAncestors(root.right, node, nodeList);
        }
    }

    public TreeNode findLowestCommonAncestor(List<TreeNode> pAncestors, List<TreeNode> qAncestors) {
        int len = Math.min(pAncestors.size(), qAncestors.size());
        for (int i = len - 1; i >= 0; i--) {
            if (pAncestors.get(i) == qAncestors.get(i))
                return pAncestors.get(i);
        }
        return null;
    }
}
