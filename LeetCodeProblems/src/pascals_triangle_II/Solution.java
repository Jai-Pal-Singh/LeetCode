package pascals_triangle_II;

import java.util.ArrayList;
import java.util.List;

// Given an integer rowIndex,return the rowIndexth(0-indexed)row of the Pascal'striangle.

// In Pascal'striangle,each number is the sum of the two numbers directly above it as shown:

// Example 1:

// Input:rowIndex=3 Output:[1,3,3,1]Example 2:

// Input:rowIndex=0 Output:[1]Example 3:

// Input:rowIndex=1 Output:[1,1]

// Constraints:

// 0<=rowIndex<=33

// Follow up:Could you optimize your algorithm to use only O(rowIndex)extra space?

/**
 * Solution
 */
public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            ans.add(i, getPascalTriangleValue(rowIndex, i));
        }
        return ans;
    }

    private Integer getPascalTriangleValue(Integer row, Integer column) {
        if (row == 0)
            return 1;
        if (column == 0 || column.equals(row))
            return 1;
        return getPascalTriangleValue(row - 1, column - 1) + getPascalTriangleValue(row - 1, column);
    }
}