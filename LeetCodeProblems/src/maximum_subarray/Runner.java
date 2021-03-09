package maximum_subarray;

public class Runner {

	public static void main(String[] args) {
		Solution solution = new Solution();
//		int [] arr = {-2,1,-3,4,-1,2,1,-5,4};
		int [] arr = {1, -1};
		System.out.println(solution.maxSubArray(arr));
	}

}
