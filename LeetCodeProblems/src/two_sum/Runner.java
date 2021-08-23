package two_sum;

public class Runner {
    public static void main(String[] args) {
        // Solution sol = new Solution();
        // System.out.println(sol.twoSum(new int[]{2,7,11,15}, 9));

        Solution2 sol2 = new Solution2();
        helper.ArrayFunctions.print(sol2.twoSum(new int[]{2,7,11,15}, 9));
    }
}
