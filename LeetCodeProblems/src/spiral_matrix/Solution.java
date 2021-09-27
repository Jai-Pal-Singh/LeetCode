package spiral_matrix;

import java.util.ArrayList;
import java.util.List;

// Given an m x n matrix, return all elements of the matrix in spiral order.

 

// Example 1:


// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]
// Example 2:


// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

// Constraints:

// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100
//    Hide Hint #1  
// Well for some problems, the best way really is to come up with some algorithms for simulation. Basically, you need to simulate what the problem asks us to do.
//    Hide Hint #2  
// We go boundary by boundary and move inwards. That is the essential operation. First row, last column, last row, first column and then we move inwards by 1 and then repeat. That's all, that is all the simulation that we need.
//    Hide Hint #3  
// Think about when you want to switch the progress on one of the indexes. If you progress on
// i
// out of
// [i, j]
// , you'd be shifting in the same column. Similarly, by changing values for
// j
// , you'd be shifting in the same row. Also, keep track of the end of a boundary so that you can move inwards and then keep repeating. It's always best to run the simulation on edge cases like a single column or a single row to see if anything breaks or not.

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowBegin = -1;
        int rowEnd = matrix.length;
        int colBegin = -1;
        int colEnd = matrix[0].length;
        int totalElements = rowEnd * colEnd;
        List<Integer> ans = new ArrayList<>();
        while(totalElements > 0){
            rowBegin++;
            for(int j=colBegin+1; j<colEnd; j++){
                ans.add(matrix[rowBegin][j]);
                totalElements--;
            }
            
            colEnd--;
            if(totalElements > 0){
                for(int i=rowBegin+1; i<rowEnd; i++){
                    ans.add(matrix[i][colEnd]);
                    totalElements--;
                }
            }
            
            rowEnd--;
            if(totalElements > 0){
                for(int j=colEnd-1; j>colBegin; j--){
                    ans.add(matrix[rowEnd][j]);
                    totalElements--;
                }
            }
            
            colBegin++;
            if(totalElements > 0){
                for(int i=rowEnd-1; i>rowBegin; i--){
                    ans.add(matrix[i][colBegin]);
                    totalElements--;
                }
            }
        }
        return ans;
    }
}