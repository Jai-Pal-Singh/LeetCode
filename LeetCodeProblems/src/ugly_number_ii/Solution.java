package ugly_number_ii;
/* 
An ugly number is a positive integer whose prime factors are limited to 2,3,and 5.

Given an integer n,return the nth ugly number.

Example 1:

Input:n=10 Output:12 Explanation:[1,2,3,4,5,6,8,9,10,12]is the sequence of the first 10 ugly numbers.Example 2:

Input:n=1 Output:1 Explanation:1 has no prime factors,therefore all of its prime factors are limited to 2,3,and 5.

Constraints:

1<=n<=1690 Accepted 237,547 Submissions 533,808 Seen this question in a real interview before?

Yes

No The naive approach is to call isUgly for every number until you reach the nth one.Most numbers are not ugly.Try to focus your effort on generating only the ugly ones.An ugly number must be multiplied by either 2,3,or 5 from a smaller ugly number.The key is how to maintain the order of the ugly numbers.Try a similar approach of merging from three sorted lists:L1,L2,and L3.Assume you have Uk,the kth ugly number.Then Uk+1 must be Min(L1*2,L2*3,L3*5).
 */
public class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            if (factor2 == min)
                factor2 = 2 * ugly[++index2];
            if (factor3 == min)
                factor3 = 3 * ugly[++index3];
            if (factor5 == min)
                factor5 = 5 * ugly[++index5];
        }
        return ugly[n - 1];
    }
}
