package spiral_matrix_ii;
/* 
Approach 2: Optimized spiral traversal
Intuition

Our main aim is to walk in a spiral form and fill the array in a particular pattern. In the previous approach, we used a separate loop for each direction. Here, we discuss another optimized to achieve the same result.

Algorithm

We have to walk in 4 directions forming a layer. We use an array dirdir that stores the changes in xx and yy co-ordinates in each direction.
Example

In left to right walk ( direction #1 ), xx co-ordinates remains same and yy increments (x = 0x=0, y = 1y=1).

In right to left walk ( direction #3 ), xx remains same and yy decrements (x = 0x=0, y = -1y=−1).

Using this intuition, we pre-define an array dirdir having xx and yy co-ordinate changes for each direction. There are a total of 4 directions as discussed in the previous approach.

The \text{row}row and colcol variables represent the current xx and yy co-ordinates respectively. It updates based on the direction in which we are moving.
How do we know when we have to change the direction?

When we find the next row or column in a particular direction has a non-zero value, we are sure it is already traversed and we change the direction.

Let dd be the current direction index. We go to next direction in array dirdir using (d+ 1) \% 4(d+1)%4. Using this we could go back to direction 1 after completing one circular traversal from direction 1 to direction 4 .

It must be noted that we use floorMod in Java instead of modulo \%% to handle mod of negative numbers. This is required because row and column values might go negative and using \%% won't give desired results in such cases.


Complexity Analysis

Time Complexity: \mathcal{O}(n^2)O(n 
2
 ). Here, nn is given input and we are iterating over n\cdot nn⋅n matrix in spiral form.
Space Complexity: \mathcal{O}(1)O(1) We use constant extra space for storing cntcnt.
 */
public class Solution2 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int cnt = 1;
        int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int d = 0;
        int row = 0;
        int col = 0;
        while (cnt <= n * n) {
            result[row][col] = cnt++;
            int r = Math.floorMod(row + dir[d][0], n);
            int c = Math.floorMod(col + dir[d][1], n);

            // change direction if next cell is non zero
            if (result[r][c] != 0)
                d = (d + 1) % 4;

            row += dir[d][0];
            col += dir[d][1];
        }
        return result;
    }
}
