package monotone_increasing_digits;

/**
 * An integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.

Given an integer n, return the largest number that is less than or equal to n with monotone increasing digits.

 

Example 1:

Input: n = 10
Output: 9
Example 2:

Input: n = 1234
Output: 1234
Example 3:

Input: n = 332
Output: 299
 

Constraints:

0 <= n <= 109
 */

public class Solution {
    public int monotoneIncreasingDigits(int n) {
        int[] num = Integer.toString(n).chars().map(c -> c-'0').toArray();
        int mark = num.length;
        for(int i = num.length-1;i>0;i--){
            if(num[i]<num[i-1]){
                mark = i-1;
                num[i-1]--;
            }
        }
        for(int i = mark+1;i<num.length;i++){
            num[i] = 9;
        }
        return arrayToInt(num);
    }
    
    public int arrayToInt(int[] nums){
        StringBuilder strNum = new StringBuilder();
        for (int num : nums) {
             strNum.append(num);
        }
        return Integer.parseInt(strNum.toString());
    }
}
