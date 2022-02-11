package kth_largest_element_in_an_array;

public class Solution5 {
    public int findKthLargest(int[] nums, int k) {
        MaxHeap mh = new MaxHeap(nums, nums.length);
        for (int i = 0; i < k - 1; i++)
            mh.extractMax();
        return mh.getMax();
    }
}
