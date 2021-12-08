package longest_increasing_subsequence;

/* 
Given an integer array nums,return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.For example,[3,6,2,7]is a subsequence of the array[0,3,1,6,2,2,7].

Example 1:

Input:nums=[10,9,2,5,3,7,101,18]Output:4 Explanation:The longest increasing subsequence is[2,3,7,101],therefore the length is 4. Example 2:

Input:nums=[0,1,0,3,2,3]Output:4 Example 3:

Input:nums=[7,7,7,7,7,7,7]Output:1

Constraints:

1<=nums.length<=2500-104<=nums[i]<=104

Follow up:Can you come up with an algorithm that runs in O(n log(n))time complexity?
 */
public class Solution {
    int[] lis;

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        lis = new int[len];
        int maxLen = Integer.MIN_VALUE;
        for (int i = nums.length-1; i > -1 ; i--) {
            int max = Integer.MIN_VALUE;
            for (int j = i+1; j < lis.length; j++) {
                if(nums[i] < nums[j])
                    max = Math.max(max, lis[j]);
            }
            lis[i] = Math.max(1, max+1);
            maxLen = Math.max(maxLen, lis[i]);
        }
        return maxLen;
    }
}
