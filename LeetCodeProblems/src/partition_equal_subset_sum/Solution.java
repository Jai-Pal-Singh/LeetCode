package partition_equal_subset_sum;

import java.util.Arrays;

/**
 * @author hp
 * @implNote Given a non-empty array nums containing only positive integers,
 *           find if the array can be partitioned into two subsets such that the
 *           sum of elements in both subsets is equal.
 * 
 * 
 * 
 *           Example 1:
 * 
 *           Input: nums = [1,5,11,5] Output: true Explanation: The array can be
 *           partitioned as [1, 5, 5] and [11]. Example 2:
 * 
 *           Input: nums = [1,2,3,5] Output: false Explanation: The array cannot
 *           be partitioned into equal sum subsets.
 * 
 * 
 *           Constraints:
 * 
 *           1 <= nums.length <= 200; 1 <= nums[i] <= 100
 *           
 *           																					
Column1	0	1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20
	2	0	0	1	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0
	3	0	0	1	1	0	1	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0
	4	0	0	1	1	1	1	1	1	0	1	0	0	0	0	0	0	0	0	0	0	0
	8	0	0	1	1	1	1	1	1	1	1	1	1	1	1	1	1	0	1	0	0	0
	9	0	0	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1
	14	0	0	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1

 *
 */
public class Solution {
	public boolean canPartition(int[] nums) {
		int subsetTotalSum = Arrays.stream(nums).sum();
		if(subsetTotalSum%2==0) {
			subsetTotalSum /=2;
		}
		else {
			return false;
		}
		Arrays.sort(nums);
		int[][] sum = new int[nums.length][subsetTotalSum+1];
		
		for(int j = 0; j< subsetTotalSum+1; j++) {
			if(j==0) {
				sum[0][j] = 0;
			}
			else if(j==nums[0]) {
				sum[0][j] = 1;
			}
			else {
				sum[0][j] = 0;
			}
		}
		for(int i =1; i<nums.length; i++) {
			for(int j = 0; j< subsetTotalSum+1; j++) {
				if(j < nums[i]) {
					sum[i][j] = sum[i-1][j];
				}
				else if(j==nums[i]) {
					sum[i][j] = 1;
				}
				else {
					sum[i][j] = Math.max(sum[i-1][j], sum[i-1][j-nums[i]]);
				}
			}
		}
//		
//		for(int i =0; i<nums.length; i++) {
//			for(int j = 0; j< subsetTotalSum+1; j++) {
//				System.out.print(sum[i][j] +" ");
//			}
//			System.out.println();
//		}
//		System.out.println("Final result: "+sum[nums.length-1][subsetTotalSum]);
		if(sum[nums.length-1][subsetTotalSum]==1) { return true;}
		return false;
	}
//	public boolean canPartition(int[] nums) {
//		int subsetTotalSum = Arrays.stream(nums).sum();
//		if(subsetTotalSum%2==0) {
//			subsetTotalSum /=2;
//		}
//		else {
//			return false;
//		}
//		Arrays.sort(nums);
//		int length = nums.length;
//		int start= 0;
//		int end = 1;
//		int currentSum = nums[start];
//		while(end < length && start <= end) {
//			if(currentSum == subsetTotalSum) {
//				return true;
//			}
//			else if(currentSum < subsetTotalSum) {
//				currentSum += nums[end];
//				end++;
//			}
//			else {
//				currentSum -= nums[start];
//				start++;
//			}
//		}
//		return false;
//	}

	public boolean subSetSum(int[] nums, int subsetTotalSum) {
		Arrays.sort(nums);
		int[][] sum = new int[nums.length][subsetTotalSum+1];
		
		for(int j = 0; j< subsetTotalSum+1; j++) {
			if(j==0) {
				sum[0][j] = 0;
			}
			else if(j==nums[0]) {
				sum[0][j] = 1;
			}
			else {
				sum[0][j] = 0;
			}
		}
		for(int i =1; i<nums.length; i++) {
			for(int j = 0; j< subsetTotalSum+1; j++) {
				if(j < nums[i]) {
					sum[i][j] = sum[i-1][j];
				}
				else if(j==nums[i]) {
					sum[i][j] = 1;
				}
				else {
					sum[i][j] = Math.max(sum[i-1][j], sum[i-1][j-nums[i]]);
				}
			}
		}
//		
//		for(int i =0; i<nums.length; i++) {
//			for(int j = 0; j< subsetTotalSum+1; j++) {
//				System.out.print(sum[i][j] +" ");
//			}
//			System.out.println();
//		}
//		System.out.println("Final result: "+sum[nums.length-1][subsetTotalSum]);
		if(sum[nums.length-1][subsetTotalSum]==1) { return true;}
		return false;
	}
}
