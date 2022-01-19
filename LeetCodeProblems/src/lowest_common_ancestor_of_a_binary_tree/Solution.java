package lowest_common_ancestor_of_a_binary_tree;

import java.util.ArrayList;
import java.util.List;

import helper_binary_tree.TreeNode;
/* 
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pAncestors = new ArrayList<>();
        List<TreeNode> qAncestors = new ArrayList<>();
        findAllAncestors(root, p, pAncestors);
        findAllAncestors(root, q, qAncestors);
        return findLowestCommonAncestor(pAncestors, qAncestors);
    }

    public boolean findAllAncestors(TreeNode root, TreeNode node, List<TreeNode> nodeList) {
        if (root != null) {
            if(root == node || findAllAncestors(root.left, node, nodeList) || findAllAncestors(root.right, node, nodeList)) {
                 nodeList.add(root);
                return true;
            }
            else{
                return false;    
            }               
        }
        return false;
    }

    public TreeNode findLowestCommonAncestor(List<TreeNode> pAncestors, List<TreeNode> qAncestors) {
        int x = pAncestors.size() - 1;
        int y = qAncestors.size() - 1;
        while (x >= 0 && y >= 0) {
            if (pAncestors.get(x) == qAncestors.get(y)){
                x--;
                y--;
            }
            else {
                break;
            }            
        }
        return pAncestors.get(x+1);
    }
}
