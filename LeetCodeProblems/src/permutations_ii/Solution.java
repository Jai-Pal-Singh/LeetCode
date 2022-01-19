package permutations_ii;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10
 */

public class Solution {
    HashSet <List<Integer>> set = new HashSet<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean used[] = new boolean[nums.length];
        permute(new ArrayList<>(),nums, used);
        return new ArrayList<>(set);
    }
    
    public void permute(List<Integer> permutation, int []nums,  boolean used[]){
                
        if(permutation.size() == nums.length){
            set.add(new ArrayList<>(permutation));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                permutation.add(nums[i]);
                used[i] = true;
                permute(permutation, nums, used);
                permutation.remove(permutation.size()-1);
                used[i] =false;
            }
        }        
    }
}
