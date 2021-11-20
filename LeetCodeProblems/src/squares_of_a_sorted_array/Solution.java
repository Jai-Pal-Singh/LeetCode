package squares_of_a_sorted_array;

import java.util.Arrays;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        return Arrays.stream(nums).map(i -> i * i).sorted().toArray();
    }    
}
