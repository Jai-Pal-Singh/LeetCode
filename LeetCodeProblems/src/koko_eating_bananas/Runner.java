package koko_eating_bananas;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        BasicFunctions.print(new Solution().minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 6));
    }
}
