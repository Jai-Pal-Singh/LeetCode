package bitwise_and_of_numbers_range;

/**
 * Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.

 

Example 1:

Input: left = 5, right = 7
Output: 4
Example 2:

Input: left = 0, right = 0
Output: 0
Example 3:

Input: left = 1, right = 2147483647
Output: 0
 

Constraints:

0 <= left <= right <= 231 - 1
 */

/**
 * Solution
 * The hardest part of this problem is to find the regular pattern.
For example, for number 26 to 30
Their binary form are:
11010
11011
11100　　
11101　　
11110

Because we are trying to find bitwise AND, so if any bit there are at least one 0 and one 1, it always 0. In this case, it is 11000.
So we are go to cut all these bit that they are different. In this case we cut the right 3 bit.
 */
public class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int i = 0; // i means we have how many bits are 0 on the right
        while (left != right) {
            left >>= 1;
            right >>= 1;
            i++;
        }
        return left << i;
    }
}
