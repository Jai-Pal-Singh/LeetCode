package next_greater_element_ii;

import java.util.Stack;

/**
 * This approach makes use of a stack. This stack stores the indices of the appropriate elements from numsnums array. The top of the stack refers to the index of the Next Greater Element found so far. We store the indices instead of the elements since there could be duplicates in the numsnums array. The description of the method will make the above statement clearer.

We start traversing the numsnums array from right towards the left. For an element nums[i]nums[i] encountered, we pop all the elements stack[top]stack[top] from the stack such that nums\big[stack[top]\big] ≤ nums[i]. We continue the popping till we encounter a stack[top]stack[top] satisfying nums\big[stack[top]\big] > nums[i]nums[stack[top]]>nums[i]. Now, it is obvious that the current stack[top]stack[top] only can act as the Next Greater Element for nums[i]nums[i](right now, considering only the elements lying to the right of nums[i]nums[i]).

If no element remains on the top of the stack, it means no larger element than nums[i]nums[i] exists to its right. Along with this, we also push the index of the element just encountered(nums[i]nums[i]), i.e. ii over the top of the stack, so that nums[i]nums[i](or stack[topstack[top) now acts as the Next Greater Element for the elements lying to its left.

We go through two such passes over the complete numsnums array. This is done so as to complete a circular traversal over the numsnums array. The first pass could make some wrong entries in the resres array since it considers only the elements lying to the right of nums[i]nums[i], without a circular traversal. But, these entries are corrected in the second pass.

Further, to ensure the correctness of the method, let's look at the following cases.

Assume that nums[j]nums[j] is the correct Next Greater Element for nums[i]nums[i], such that i < j ≤ stack[top]. Now, whenever we encounter nums[j]nums[j], if nums[j] > nums\big[stack[top]\big]nums[j]>nums[stack[top]], it would have already popped the previous stack[top]stack[top] and jj would have become the topmost element. On the other hand, if nums[j] < nums\big[stack[top]\big]nums[j]<nums[stack[top]], it would have become the topmost element by being pushed above the previous stack[top]stack[top]. In both the cases, if nums[j] > nums[i]nums[j]>nums[i], it will be correctly determined to be the Next Greater Element.

The following example makes the procedure clear:

Current
4 / 25
As the animation above depicts, after the first pass, there are a number of wrong entries(marked as \text{-1}-1) in the resres array, because only the elements lying to the corresponding right(non-circular) have been considered till now. But, after the second pass, the correct values are substituted.


Complexity Analysis

Time complexity : O(n)O(n). Only two traversals of the numsnums array are done. Further, atmost \text{2n}2n elements are pushed and popped from the stack.

Space complexity : O(n)O(n). A stack of size nn is used. resres array of size nn is used.
 */

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }
}
