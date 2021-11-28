package jump_game;
/* 
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] jumps = new boolean[len];
        jumps[len-1] = true;
        for(int i = len-2; i>=0; i--){
            jumps[i] = false;
            for(int j = 1; j<=nums[i] ; j++){
                if(jumps[i+j]){
                    jumps[i]=true;
                    break;
                }
            }
        }
        return jumps[0];
    }
}
