package top_k_frequent_elements;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        ArrayFunctions.print(new Solution().topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2));
    }
}
