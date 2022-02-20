package remove_covered_intervals;

import java.util.Arrays;

/**
 * Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove all intervals that are covered by another interval in the list.

The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.

Return the number of remaining intervals.

 

Example 1:

Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2
Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
Example 2:

Input: intervals = [[1,4],[2,3]]
Output: 1
 

Constraints:

1 <= intervals.length <= 1000
intervals[i].length == 2
0 <= li <= ri <= 105
All the given intervals are unique.
 */

 /**
  * Intuition
Imagine that, after removing all covered intervals,
all intervals must have different bounds,
After sorting, their left and right bound are increasing at the same time.


Test Case
Here are some useful small test cases for debugging.
[[1,2],[1,3]]
[[1,3],[1,8],[5,8]]
[[1,6],[4,6],[4,8]]

Solution 2, sort left ascending and right decending
In this solution, we sort on left first.
When left are same, we sort right in decending order.

For example: [[1,5],[1,4],[1,3],[1,2]]

Complexity: time O(sort), space O(sort)
  */
public class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int res = 0, right = 0;
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        for (int[] v : intervals) {
            if (v[1] > right) {
                ++res;
                right = v[1];
            }
        }
        return res;
    }
}
