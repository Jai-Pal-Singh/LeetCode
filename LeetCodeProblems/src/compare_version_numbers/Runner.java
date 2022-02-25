package compare_version_numbers;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        BasicFunctions.print(new Solution().compareVersion("1.01", "1.001"));
    }
}
