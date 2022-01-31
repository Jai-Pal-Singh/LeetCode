package richest_customer_wealth;

import helper.BasicFunctions;

/**
 * Runner
 */
public class Runner {

    public static void main(String[] args) {
        BasicFunctions.print(new Solution().maximumWealth(new int[][] {
            {1, 2, 3},
            {3, 2, 1}
        }));
    }
}