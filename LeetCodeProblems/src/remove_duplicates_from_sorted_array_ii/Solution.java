package remove_duplicates_from_sorted_array_ii;

/**
 * Solution
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        int s = 2;
        // slow pointer
    
        for (int f = 2 ; f < nums.length ; f++){
            // Must compare nums[f] and nums[s-2]
            if (nums[f] != nums[s-2]){
                nums[s] = nums[f];
                s = s+1;
                
            }
        }
        return s;
    }
}