package construct_binary_tree_from_inorder_postorder_traversal;

import java.util.Objects;

import main.TreeNode;
/*

Construct Binary Tree from Inorder and Postorder Traversal

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

Example 1:

Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: []

Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int totalTreeNodes = postorder.length;
        TreeNode root = new TreeNode(postorder[totalTreeNodes-1], null, null);

        for(int i = totalTreeNodes-1; i >= 0; i--){
            TreeNode node = root;
            int currentNodeLocation = getIndexOf(inorder, postorder[i]);
            System.out.println("i : "+postorder[i]);
            for(int j = totalTreeNodes-1; j>i; j--){
                int previousNodeLocation = getIndexOf(inorder, postorder[j]);
                System.out.println(postorder[j] + " location " + previousNodeLocation);
                if(currentNodeLocation > previousNodeLocation){
                    if(Objects.nonNull(node.right) ){ node = node.right; }
                    else if(j != i+1){ continue;}
                    else{ System.out.println("inserting " + inorder[currentNodeLocation] + " to the right of " + node.val + " currentlocation : " + currentNodeLocation + " prevlocation : " + previousNodeLocation); 
                        node.right = new TreeNode(inorder[currentNodeLocation], null, null); break;}
                }
                else{
                    if(Objects.nonNull(node.left) ){ node = node.left; }
                    else if(j != i+1){ continue;}
                    else{ System.out.println("inserting " + inorder[currentNodeLocation] + " to the left of " + node.val + " currentlocation : " + currentNodeLocation + " prevlocation : " + previousNodeLocation); 
                        node.left = new TreeNode(inorder[currentNodeLocation], null, null); break;}
                }
            }
        }
        return root;
    }

    private int getIndexOf(int[] inorder, int val) {
        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == val) return i;
        }
        return -1;
    }
}
