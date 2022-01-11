package sum_of_root_to_leaf_binary_numbers;

import helper_binary_tree.TreeNode;

// You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents a binary number starting with the most significant bit.

// For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
// For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers.

// The test cases are generated so that the answer fits in a 32-bits integer.

 

// Example 1:


// Input: root = [1,0,1,0,1,0,1]
// Output: 22
// Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
// Example 2:

// Input: root = [0]
// Output: 0
 

// Constraints:

// The number of nodes in the tree is in the range [1, 1000].
// Node.val is 0 or 1.

public class Solution {
    int result = 0;
    
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return result;
    }
    
    public void dfs(TreeNode root, StringBuilder sb){
        if(root.left == null && root.right==null){
            sb.append(root.val);
            // System.out.println(result+"..."+sb.toString());
            result += Integer.parseInt(sb.toString(),2);
            sb.deleteCharAt(sb.length()-1);
        }
        else{
            sb.append(root.val);
            if(root.left!= null)
                dfs(root.left, sb);
            if(root.right!= null)
                dfs(root.right, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
