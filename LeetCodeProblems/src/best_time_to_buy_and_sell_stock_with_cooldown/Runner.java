package best_time_to_buy_and_sell_stock_with_cooldown;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        BasicFunctions.print(new Solution().maxProfit(new int[] { 1, 2, 3, 0, 2 }));
    }
}
