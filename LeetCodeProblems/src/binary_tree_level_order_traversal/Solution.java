package binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import helper_binary_tree.TreeNode;

/* 
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode>[] q = new Queue[2];
        q[0] = new LinkedList<>();
        q[1] = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            q[0].add(root);
            int i = 0;
            while (!q[i % 2].isEmpty()) {
                List<Integer> level = new ArrayList<>();
                while (!q[i % 2].isEmpty()) {
                    TreeNode node = q[i % 2].remove();
                    if (node != null) {
                        level.add(node.val);
                        q[(i + 1) % 2].add(node.left);
                        q[(i + 1) % 2].add(node.right);
                    }

                }
                if (!level.isEmpty())
                    result.add(level);
                i++;
            }
        }
        return result;
    }
}
