package simplify_path;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String path = "/home/";
        BasicFunctions.print(solution.simplifyPath(path));
    }
}
