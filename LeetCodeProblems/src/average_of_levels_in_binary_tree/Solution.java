package average_of_levels_in_binary_tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hp
 * @implNote Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.
 */
public class Solution {
	public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new LinkedList<Double>();
        TreeNode temp = root;
        Queue<TreeNode>[] q= new Queue[2];
		q[0] = new LinkedList<TreeNode>(); 
		q[1] = new LinkedList<TreeNode>();
        q[0].add(temp);
        int i=0;
        while(!q[i%2].isEmpty()){
            Double sum = 0D;
            Double count = 0D;
            while(!q[i%2].isEmpty()){
                TreeNode node = q[i%2].remove();
                if(node != null){
                    sum += Double.valueOf(node.val);
                    count++;
                    q[(i+1)%2].add(node.left);
                    q[(i+1)%2].add(node.right);
                }
                
            }
            if(count!=0)
            	result.add(sum/count);
            i++;  
        }
        
        return result;
    }
}
