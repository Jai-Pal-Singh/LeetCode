package binary_search;

/**
 * Solution
 */

//  Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

// You must write an algorithm with O(log n) runtime complexity.
public class Solution {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        return binarySearch(nums, target, start, end);
    }
    
    public int binarySearch(int[] nums, int target, int start, int end) {
        if(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                return binarySearch(nums, target, mid+1, end);
            }
            else{
                return binarySearch(nums, target, start, mid-1);
            }
        }
        return -1;
    }
}