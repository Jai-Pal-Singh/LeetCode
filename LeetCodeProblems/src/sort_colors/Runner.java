package sort_colors;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        helper.ArrayFunctions.print(nums);
    }
}
