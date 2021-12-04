package unique_paths;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        BasicFunctions.print(new Solution().uniquePaths(m, n));
    }
}
