package capacity_to_ship_packages_within_d_days;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] weights = {1, 2, 3, 1, 1};
        int days = 4;
        BasicFunctions.print(solution.shipWithinDays(weights, days));
    }
}
