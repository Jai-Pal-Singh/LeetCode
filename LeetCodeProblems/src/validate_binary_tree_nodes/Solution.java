package validate_binary_tree_nodes;

import java.util.Arrays;

/* 
You have n binary tree nodes numbered from 0 to n-1 where node i has two children leftChild[i]and rightChild[i],return true if and only if all the given nodes form exactly one valid binary tree.

If node i has no left child then leftChild[i]will equal-1,similarly for the right child.

Note that the nodes have no values and that we only use the node numbers in this problem.

Example 1:

Input:n=4,leftChild=[1,-1,3,-1],rightChild=[2,-1,-1,-1]Output:true Example 2:

Input:n=4,leftChild=[1,-1,3,-1],rightChild=[2,3,-1,-1]Output:false Example 3:

Input:n=2,leftChild=[1,0],rightChild=[-1,-1]Output:false

Constraints:

n==leftChild.length==rightChild.length 1<=n<=104-1<=leftChild[i],rightChild[i]<=n-1
 */
class Solution{
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int nodesWithNoParent = n;

        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                if (parent[leftChild[i]] == -1) {
                    parent[leftChild[i]] = i;
                    nodesWithNoParent--;
                } else {
                    return false;
                }
            }
            if (rightChild[i] != -1) {
                if (parent[rightChild[i]] == -1) {
                    parent[rightChild[i]] = i;
                    nodesWithNoParent--;
                } else {
                    return false;
                }
            }
        }
        return nodesWithNoParent == 1 && noLoops(n, parent);
    }

    public boolean noLoops(int n, int[] parent) {
        boolean[] visited;
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            int j = i;
            while (parent[j] != -1) {
                if (visited[j]) {
                    return false;
                }
                visited[j] = true;
                j = parent[j];
            }
        }
        return true;
    }
}