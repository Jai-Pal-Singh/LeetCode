package _3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Given an integer array nums,return all the triplets[nums[i],nums[j],nums[k]]such that i!=j,i!=k,and j!=k,and nums[i]+nums[j]+nums[k]==0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input:nums=[-1,0,1,2,-1,-4]Output:[[-1,-1,2],[-1,0,1]]Example 2:

Input:nums=[]Output:[]Example 3:

Input:nums=[0]Output:[]

Constraints:

0<=nums.length<=3000-105<=nums[i]<=105
 */
public class Solution {
    Set<List<Integer>> res;

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        res = new HashSet<>();
        if (nums.length < 3)
            return new ArrayList<>(res);

        for (int i = 0; i < nums.length; i++) {
            findNumbers(nums, -nums[i], i);
        }

        return new ArrayList<>(res);
    }

    public void findNumbers(int[] arr, int k, int n) {
        int len = arr.length;
        int s = n + 1;
        int e = len - 1;
        while (s < e) {
            int cs = arr[s] + arr[e];
            if (cs == k) {
                res.add(Arrays.asList(arr[n], arr[s], arr[e]));
            }
            if (cs < k) {
                s++;
            } else {
                e--;
            }
        }
    }
}
