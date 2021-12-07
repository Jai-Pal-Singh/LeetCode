package print_all_subarrays_with_0_sum;
    
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Given an array of integers, find all possible continuous subarrays where the
 * sum of all the values is zero. Print the starting and ending indexes of all
 * such possible sub-arrays
 * 
 * Input
 * [-1, 1, 2, -2, -1, 3]
 * 
 * Output
 * [0,1]
 * [2,3]
 * [0,3]
 * [1,4]
 * [3,5]
 * 
 * [-1, 0, 2, 0, -1, 2]
 */

class Solution {
    public void ContinuousSubarray(int[] input) {
        int len = input.length;
        Map<Integer, List<Integer>> prefix = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += input[i];
            if (prefix.containsKey(sum)) {
                List<Integer> indexes = prefix.get(sum);
                indexes.add(i);
                prefix.put(sum, indexes);
            } else {
                List<Integer> indexes = new LinkedList<>();
                indexes.add(i);
                prefix.put(sum, indexes);
            }
        }

        // 0 -> 1,3
        // -1 -> 0, 4
        // 2 -> 2, 5
        prefix.entrySet().stream().forEach((entry) -> {
            List<Integer> indexes = entry.getValue();
            if (indexes.size() > 1) {
                if (entry.getKey().equals(0)) {
                    for (int i = 0; i < indexes.size(); i++) {
                        System.out.println("[ " + 0 + ", " + indexes.get(i) + "]");
                    }
                }
                for (int i = 0; i < indexes.size() - 1; i++) {
                    for (int j = 1; j < indexes.size(); j++) {
                        System.out.println("[ " + (indexes.get(i) + 1) + ", " + indexes.get(j) + "]");
                    }
                }
            }
        });

    }
}

