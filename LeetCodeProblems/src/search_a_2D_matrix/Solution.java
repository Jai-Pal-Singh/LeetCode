package search_a_2D_matrix;

import java.util.Arrays;

/**
 * @author hp
 * @implNote Write an efficient algorithm that searches for a target value in an
 *           m x n integer matrix. The matrix has the following properties:
 * 
 *           Integers in each row are sorted in ascending from left to right.
 *           Integers in each column are sorted in ascending from top to bottom.
 * 
 * 
 *           Example 1:
 * 
 * 
 *           Input: matrix =
 *           [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],
 *           target = 5 Output: true Example 2:
 * 
 * 
 *           Input: matrix =
 *           [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],
 *           target = 20 Output: false
 * 
 * 
 *           Constraints:
 * 
 *           m == matrix.length n == matrix[i].length 1 <= n, m <= 300 -109 <=
 *           matix[i][j] <= 109 All the integers in each row are sorted in
 *           ascending order. All the integers in each column are sorted in
 *           ascending order. -109 <= target <= 109
 *
 * 
 */
public class Solution {

	public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length-1;
        int i= 0;
        while(i<=m && target>=matrix[i][0]) {
        	int index = Arrays.binarySearch(matrix[i], target);
        	System.out.println("arr[i][0] : "+matrix[i][0] + " ; index : "+index);
        	if (index >= 0) return true;
        	i++;
        }
		return false;
    }
	
//	int binarySearch(int arr[][], int l, int r, int x) 
//    { 
//        if (r>=l) 
//        { 
//            int mid = l + (r - l)/2; 
//            System.out.println("mid : "+mid);
//            int index = Arrays.binarySearch(arr[mid], x);
//            if (index >= 0) 
//               return mid; 
////            if ((mid < arr[mid].length) &&(arr[mid][0] > x)) 
//            System.out.println("arr[0][mid] : "+arr[0][mid]);
//            System.out.println("arr[mid][0] : "+arr[mid][0]);
//            if ((arr[mid][0] < x)) 
//               return binarySearch(arr, l, mid-1, x); 
//  
//            return binarySearch(arr, mid+1, r, x); 
//        } 
//        return -1; 
//    }
}
