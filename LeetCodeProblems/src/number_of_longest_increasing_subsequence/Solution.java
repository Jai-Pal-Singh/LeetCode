package number_of_longest_increasing_subsequence;

/**
 * Given an integer array nums, return the number of longest increasing subsequences.

Notice that the sequence has to be strictly increasing.

 

Example 1:

Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:

Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.

 

Constraints:

1 <= nums.length <= 2000
-106 <= nums[i] <= 106
 */
public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int res = 0;
        int maxLen = 0;
        int[] len =  new int[n];
        int[] count = new int[n];
        for(int i = 0; i<n; i++){
            len[i] = count[i] = 1;
            for(int j = 0; j <i ; j++){
                if(nums[i] > nums[j]){
                    if(len[i] == len[j] + 1)count[i] += count[j];
                    if(len[i] < len[j] + 1){
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            if(maxLen == len[i])res += count[i];
            if(maxLen < len[i]){
                maxLen = len[i];
                res = count[i];
            }
        }
        return res;
    }
}
