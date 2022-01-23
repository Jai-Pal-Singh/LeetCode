package sequential_digits;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        ArrayFunctions.print(new Solution().sequentialDigits(100, 300));
        ArrayFunctions.print(new Solution2().sequentialDigits(134, 18907));
    }
}
