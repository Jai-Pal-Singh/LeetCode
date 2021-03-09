package shortest_unsorted_continuous_subarray;

public class Runner {

	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] nums = {2,6,4,8,10,9,15};
//		int[] nums = {1,2,3,4,5};
		int[] nums = {1,3,2,3,3};
//		int[] nums = {1,3,2,2,2};
		System.out.println(solution.findUnsortedSubarray(nums));
	}

}
