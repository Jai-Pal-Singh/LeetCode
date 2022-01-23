package largest_number;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

 

Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 109
 */


/**
 * Complexity Analysis

Time complexity : \mathcal{O}(nlgn)O(nlgn)

Although we are doing extra work in our comparator, it is only by a constant factor. Therefore, the overall runtime is dominated by the complexity of sort, which is \mathcal{O}(nlgn)O(nlgn) in Python and Java.

Space complexity : \mathcal{O}(n)O(n)

Here, we allocate \mathcal{O}(n)O(n) additional space to store the copy of nums. Although we could do that work in place (if we decide that it is okay to modify nums), we must allocate \mathcal{O}(n)O(n) space for the final return string. Therefore, the overall memory footprint is linear in the length of nums.
 */
public class Solution {
    public String largestNumber(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, new LargerNumberComparator());

        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        StringBuilder largestNumberStr = new StringBuilder();
        for (String numAsStr : asStrs) {
            largestNumberStr.append(numAsStr);
        }

        return largestNumberStr.toString();
    }
    
    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
           return order2.compareTo(order1);
        }
    }
}
