package search_insert_position;

// Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [1,3,5,6], target = 5
// Output: 2
// Example 2:

// Input: nums = [1,3,5,6], target = 2
// Output: 1
// Example 3:

// Input: nums = [1,3,5,6], target = 7
// Output: 4
// Example 4:

// Input: nums = [1,3,5,6], target = 0
// Output: 0
// Example 5:

// Input: nums = [1], target = 0
// Output: 0
 

// Constraints:

// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums contains distinct values sorted in ascending order.
// -104 <= target <= 104

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target<nums[0]) return 0;
        int len = nums.length - 1;
        if(target>nums[len]) return len+1;
        int start = 0;
        return modifiedBinarySearch(nums, target, start, len);
    }
    
    public int modifiedBinarySearch(int[] nums, int target, int start, int n) {
        if(start<=n){
            int mid = start + (n-start)/2;
            if((nums[mid]==target) || ((mid-1 >= 0) && nums[mid-1]<target && nums[mid]>target) ){
                return mid;
            }
            else if(nums[mid]<target){
                return modifiedBinarySearch(nums, target, mid+1, n);
            }
            else{
                return modifiedBinarySearch(nums, target, start, mid-1);
            }
        }
        return -1;
    }
}
