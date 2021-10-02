package pascals_triangle_II;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            ans.add(i, getRow(ans, i));
        }
        return ans.get(rowIndex);
    }

    private ArrayList<Integer> getRow(ArrayList<ArrayList<Integer>> ans, Integer row) {
        ArrayList<Integer> temp = new ArrayList<>(row + 1);
        for (int i = 0; i <= row; i++) {
            temp.add(i, getPascalTriangleValue(ans, row, i));
        }
        return temp;
    }

    private Integer getPascalTriangleValue(ArrayList<ArrayList<Integer>> ans, Integer row, Integer column) {
        if (row == 0)
            return 1;
        if (column == 0 || column.equals(row))
            return 1;
        return ans.get(row - 1).get(column - 1) + ans.get(row - 1).get(column);
    }
}
