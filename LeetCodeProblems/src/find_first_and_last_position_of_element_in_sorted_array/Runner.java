package find_first_and_last_position_of_element_in_sorted_array;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        ArrayFunctions.print(new Solution().searchRange(new int[] {5,7,7,8,8,10}, 8));
    }
}
