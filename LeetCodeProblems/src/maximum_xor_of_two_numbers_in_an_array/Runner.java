package maximum_xor_of_two_numbers_in_an_array;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        int[] nums = {3,10,5,25,2,8};
        BasicFunctions.print(new Solution().findMaximumXOR(nums));
    }
}
