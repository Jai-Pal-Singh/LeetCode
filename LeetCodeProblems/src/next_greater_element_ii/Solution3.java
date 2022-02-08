package next_greater_element_ii;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Explanation
Loop once, we can get the Next Greater Number of a normal array.
Loop twice, we can get the Next Greater Number of a circular array


Complexity
Time O(N) for one pass
Spce O(N) in worst case
 */
public class Solution3 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < 2 * nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peekLast()] < nums[i % nums.length]){
                res[stack.pollLast()] = nums[i % nums.length];
            }
            stack.offer(i % nums.length);
        }
        return res;
    }
}
