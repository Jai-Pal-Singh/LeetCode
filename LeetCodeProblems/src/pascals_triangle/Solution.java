package pascals_triangle;

import java.util.ArrayList;
import java.util.List;
/* 
Given an integer numRows,return the first numRows of Pascal'striangle.

In Pascal'striangle,each number is the sum of the two numbers directly above it as shown:

Example 1:

Input:numRows=5 Output:[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]Example 2:

Input:numRows=1 Output:[[1]]

Constraints:

1<=numRows<=30
 */
public class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> generate(int numRows) {
        res = new ArrayList<>(numRows + 1);
        for (int i = 0; i < numRows; i++) {
            res.add(getRow(i));
        }
        return res;
    }

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
        return res.get(row - 1).get(column - 1) + res.get(row - 1).get(column);
    }
}
