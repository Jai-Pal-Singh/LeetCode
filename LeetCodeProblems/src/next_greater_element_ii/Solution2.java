package next_greater_element_ii;

/**
 * Instead of making a double length copy of numsnums array , we can traverse circularly in the numsnums array by making use of the \text{%(modulus)} operator. For every element nums[i]nums[i], we start searching in the numsnums array(of length nn) from the index (i+1)%n(i+1) and look at the next(cicularly) n-1n−1 elements. For nums[i]nums[i] we do so by scanning over nums[j]nums[j], such that (i+1)%n &leq; j &leq; (i+(n-1))%n(i+1), and we look for the first greater element found. If no such element is found, we put a \text{-1}-1 at the appropriate position in the resres array.


Complexity Analysis

Time complexity : O(n^2)O(n 
2
 ). The complete numsnums array of size nn is scanned for all the elements of numsnums in the worst case.

Space complexity : O(n)O(n). resres array of size nn is used.


 */
public class Solution2 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = -1;
            for (int j = 1; j < nums.length; j++) {
                if (nums[(i + j) % nums.length] > nums[i]) {
                    res[i] = nums[(i + j) % nums.length];
                    break;
                }
            }
        }
        return res;
    }
}
