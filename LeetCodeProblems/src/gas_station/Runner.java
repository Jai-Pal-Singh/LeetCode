package gas_station;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        BasicFunctions.print(new Solution().canCompleteCircuit(new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 4, 5, 1, 2 }));
    }
}
