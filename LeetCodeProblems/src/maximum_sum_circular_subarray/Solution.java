package maximum_sum_circular_subarray;
/* 
Given a circular integer array nums of length n,return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array.Formally,the next element of nums[i]is nums[(i+1)%n]and the previous element of nums[i]is nums[(i-1+n)%n].

A subarray may only include each element of the fixed buffer nums at most once.Formally,for a subarray nums[i],nums[i+1],...,nums[j],there does not exist i<=k1,k2<=j with k1%n==k2%n.

Example 1:

Input:nums=[1,-2,3,-2]Output:3 Explanation:Subarray[3]has maximum sum 3. Example 2:

Input:nums=[5,-3,5]Output:10 Explanation:Subarray[5,5]has maximum sum 5+5=10. Example 3:

Input:nums=[-3,-2,-3]Output:-2 Explanation:Subarray[-2]has maximum sum-2.

Constraints:

n==nums.length 1<=n<=3*104-3*104<=nums[i]<=3*104
 */
public class Solution {
    public int maxSubarraySumCircular(int[] A) {
        // S: sum of A
        int S = 0;
        for (int x : A) {
            S += x;
        }

        if (A.length == 1) {
            return S;
        }

        // ans1: answer for one-interval subarray
        int ans1 = Integer.MIN_VALUE;
        int cur = Integer.MIN_VALUE;
        for (int x : A) {
            cur = x + Math.max(cur, 0);
            ans1 = Math.max(ans1, cur);
        }

        // ans2: answer for two-interval subarray, interior in A[1:]
        int ans2 = Integer.MAX_VALUE;
        cur = Integer.MAX_VALUE;
        for (int i = 1; i < A.length; ++i) {
            cur = A[i] + Math.min(cur, 0);
            ans2 = Math.min(ans2, cur);
        }
        ans2 = S - ans2;

        // ans3: answer for two-interval subarray, interior in A[:-1]
        int ans3 = Integer.MAX_VALUE;
        cur = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; ++i) {
            cur = A[i] + Math.min(cur, 0);
            ans3 = Math.min(ans3, cur);
        }

        return Math.max(ans1, Math.max(ans2, ans3));

    }
}
