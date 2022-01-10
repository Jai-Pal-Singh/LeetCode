package subsets_ii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

 

// Example 1:

// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
// Example 2:

// Input: nums = [0]
// Output: [[],[0]]
 

// Constraints:

// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10

public class Solution {
    Set<List<Integer>> output = new HashSet<>();
    int n, k;
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; ++k) {
          backtrack(0, new ArrayList<Integer>(), nums);
        }
        return new ArrayList<>(output);
    }
    
    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        // if the combination is done
        if (curr.size() == k) {
          ArrayList<Integer> res = new ArrayList<>(curr);
          Collections.sort(res);
          output.add(res);
          return;
        }
        for (int i = first; i < n; ++i) {
          // add i into the current combination
          curr.add(nums[i]);
          // use next integers to complete the combination
          backtrack(i + 1, curr, nums);
          // backtrack
          curr.remove(curr.size() - 1);
        }
    }
}
