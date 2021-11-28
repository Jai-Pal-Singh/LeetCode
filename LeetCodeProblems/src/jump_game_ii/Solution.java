package jump_game_ii;
/* 
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
 */
public class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int[] jumps = new int[len];
        jumps[len-1] = 0;
        for(int i = len-2; i>=0; i--){
            int minJumps = Integer.MAX_VALUE-2000;
            for(int j = 1; j<=nums[i] ; j++){
                if(i+j < len){
                    minJumps = Math.min(minJumps, jumps[i+j]+1);
                }
                else{
                    break;
                }
            }
            jumps[i] = minJumps;
        }
        return jumps[0];
    }
}
