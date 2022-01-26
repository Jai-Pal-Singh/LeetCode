package all_elements_in_two_binary_search_trees;

import java.util.ArrayList;
import java.util.List;

import helper_binary_tree.TreeNode;

/**
 * Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.

 

Example 1:


Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
Example 2:


Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]
 

Constraints:

The number of nodes in each tree is in the range [0, 5000].
-105 <= Node.val <= 105
 */
public class Solution {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = inorderTraversal(root1, new ArrayList<>());
        List<Integer> list2 = inorderTraversal(root2, new ArrayList<>());
        return mergeLists(list1, list2);
    }

    private List<Integer> inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
        return list;
    }

    private List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> ans = new ArrayList<>();
        int m = list1.size(), n = list2.size(), i = 0, j = 0;
        while (i < m && j < n) {
            if (list1.get(i) <= list2.get(j)) {
                ans.add(list1.get(i));
                i++;
            } else {
                ans.add(list2.get(j));
                j++;
            }
        }
        if (i < m) {
            ans.addAll(list1.subList(i, m));
        } else if (j < n) {
            ans.addAll(list2.subList(j, n));
        }
        return ans;
    }
}

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