package contiguous_array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
 */

/**
 * Algorithm
 * 
 * This approach relies on the same premise as the previous approach. But, we
 * need not use an array of size 2n+1, since it isn't necessary that we'll
 * encounter all the count values possible. Thus, we make use of a HashMap
 * mapmap to store the entries in the form of (index,count). We make an entry
 * for a count in the mapmap whenever the count is encountered first, and later
 * on use the correspoding index to find the length of the largest subarray with
 * equal no. of zeros and ones when the same countcount is encountered again.
 * 
 * The following animation depicts the process:
 * 
 * Current
 * 1 / 8
 ** Complexity Analysis**
 * Time complexity : O(n). The entire array is traversed only once.
 * 
 * Space complexity : O(n). Maximum size of the HashMap mapmap will be
 * n, if all the elements are either 1 or 0.
 */

public class Solution {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }
}