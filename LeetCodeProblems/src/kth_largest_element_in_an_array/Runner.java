package kth_largest_element_in_an_array;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        BasicFunctions.print(new Solution().findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
        BasicFunctions.print(new Solution5().findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
    }
}
