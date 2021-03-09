package k_weakest_matrix_rows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author hp
 * {@summary: Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians), return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest.

A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row j, or they have the same number of soldiers but i is less than j. Soldiers are always stand in the frontier of a row, that is, always ones may appear first and then zeros.}
 *@implNote m == mat.length
			n == mat[i].length
			2 <= n, m <= 100
			1 <= k <= m
			matrix[i][j] is either 0 or 1.
 */
public class Solution {
//	public int[] kWeakestRows(int[][] mat, int k) {
//		final int maxValue = 101;
//		Integer length = mat.length;
//		int[] soldierCount = new int[length];
//		int[] kWeakestSoldiers = new int[k];
//		for(int row = 0; row < length; row++) {
//			int count  = 0;
//			for(int col = 0; col < mat[row].length && mat[row][col] != 0 ; col++) {
//				count++;
//			}
//			soldierCount[row] = count;
//		}
//		for(int i = 0; i<k ; i++) {
//			int index = getMinimumValueIndex(soldierCount);
//			kWeakestSoldiers[i] = index;
//			soldierCount[index] = maxValue;
//		}
//		for(int weakestSoldier : kWeakestSoldiers) {
//			System.out.println(weakestSoldier);
//		}
//		return kWeakestSoldiers;
//    }
//
//	private int getMinimumValueIndex(int[] soldierCount) {
//		int minIndex = 0;
//		for(int i = 0 ; i < soldierCount.length; i++) {
//			if(soldierCount[i] < soldierCount[minIndex]) {
//				minIndex = i;
//			}
//		}
//		return minIndex;
//	}

    public int[] kWeakestRows(int[][] mat, int k) {
        
        // Create HashMap that can hold multiple values per key
        HashMap<Integer, ArrayList<Integer>> soldiersToRows = new HashMap<>();
        
        // Traverse through each row of the matrix, and fill the HashMap
        for (int row = 0; row < mat.length; row++) {
            
            // Perform Binary Search on the entire row to find the last '1'
            int rowSoldierCount = countSoldiers(mat[row]);
            
            // Key not added yet
            if (!(soldiersToRows.containsKey(rowSoldierCount))) {
                soldiersToRows.put(rowSoldierCount, new ArrayList<>());
            }
            
            // Retrieve mapped ArrayList
            List<Integer> list = soldiersToRows.get(rowSoldierCount);
            
            // Add index to the mapped ArrayList
            list.add(row);
            
        }
        
        // Add the first k indices from the HashMap to the result array
        
        int[] result = new int[k];
        
        int resIndex = 0;
        
        boolean foundWeakest = false;
        
        
        // Go through each key in the HashMap (each possible soldier count)
        for (int soldierCount = 0; soldierCount <= mat[0].length; soldierCount++) {
            
            
            // List of row indices that have the current soldier count (weakest to strongest)
            List<Integer> list = soldiersToRows.get(soldierCount);
            
            // Current soldier count does not exist as a key
            if (list == null) {
                continue;
            }
            
            for (int mRow : list) {
                
                result[resIndex++] = mRow;
                
                if (resIndex == k) {
                    foundWeakest = true;
                    break;
                }
                
            }
            
            if (foundWeakest) {
                break;
            }
        }
        
        return result;
    }
    
    int countSoldiers(int[] arr) {
        
        int low = 0;
        int high = arr.length - 1;
        
        int soldierCount = 0;
        
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            
            if (arr[mid] == 0) {
                
                // Found last 1
                if (mid == 0 || arr[mid - 1] == 1) {
                    
                    soldierCount = mid;
                    break;
                }
                
                // Discard the right half
                high = mid - 1;
            }
            
            else {
                
                
                // Found last 1
                if (mid == arr.length - 1 || arr[mid + 1] == 0) {
                    
                    soldierCount = mid + 1;
                    break;
                }
                
                // Discard the left half
                low = mid + 1;
            }
        }
        
        return soldierCount;
    }
}
