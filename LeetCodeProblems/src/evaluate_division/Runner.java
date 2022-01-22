package evaluate_division;

import java.util.List;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"));
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x"));
        ArrayFunctions.print(solution.calcEquation(equations, values, queries));
    }
}
