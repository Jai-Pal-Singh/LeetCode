package shortest_unsorted_continuous_subarray;

/**
 * @author hp
 * @implNote Given an integer array nums, you need to find one continuous
 *           subarray that if you only sort this subarray in ascending order,
 *           then the whole array will be sorted in ascending order.
 * 
 *           Return the shortest such subarray and output its length.
 * 
 * 
 * 
 *           Example 1:
 * 
 *           Input: nums = [2,6,4,8,10,9,15] Output: 5 Explanation: You need to
 *           sort [6, 4, 8, 10, 9] in ascending order to make the whole array
 *           sorted in ascending order. Example 2:
 * 
 *           Input: nums = [1,2,3,4] Output: 0 Example 3:
 * 
 *           Input: nums = [1] Output: 0
 * 
 * 
 *           Constraints:
 * 
 *           1 <= nums.length <= 104 -105 <= nums[i] <= 105
 * 
 * 
 *           Follow up: Can you solve it in O(n) time complexity?
 *
 * 
 */
public class Solution {
	public int findUnsortedSubarray(int[] nums) {
       int start = nums.length;
       int end = -1;
       int i = 0;
       int j = nums.length-1;
       while((i<=j) && (i<nums.length-1) && (j>0)) {
//    	   System.out.println("i :"+i+" , j :"+j);
    	   if(nums[i]>nums[i+1]) {
//    		   System.out.println("nums[i] : "+nums[i] + " , nums[i+1] : "+nums[i+1]);
    		   start = Math.min(start, i);
    	   }
    	   if(nums[j]<=nums[j-1]) {
//    		   System.out.println("nums[j] : "+nums[j] + " , nums[j-1] : "+nums[j-1]);
    		   end = Math.max(end, j);
    	   }
    	   i++;
    	   j--;
       }
//       System.out.println("Start :"+start+" , End :"+end);
       if(start != nums.length && end != -1) {
//    	   int count = 0;
//    	   for(int k = start; i<=end;i++) {
//    		   count++;
//    	   }
    	   return end-start+1;
       }
       return 0;
    }
}
