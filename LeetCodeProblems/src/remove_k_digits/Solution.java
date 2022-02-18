package remove_k_digits;

/**
 * Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 

Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.
 */
/**
 * The first algorithm is straight-forward. Let's think about the simplest case: how to remove 1 digit from the number so that the new number is the smallest possible？ Well, one can simply scan from left to right, and remove the first "peak" digit; the peak digit is larger than its right neighbor. One can repeat this procedure k times, and obtain the first algorithm:
 */
public class Solution {

    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        while (k > 0) {
            int n = sb.length();
            int i = 0;
            while (i+1<n && sb.charAt(i)<=sb.charAt(i+1))  i++;
            sb.deleteCharAt(i);
            k--;
        }
        // trim leading zeros
        int s = 0;
        while (s<(int)sb.length()-1 && sb.charAt(s)=='0')  s++;
        sb.delete(0, s);
        
        return sb.toString().equals("") ? "0" : sb.toString();
    }
}