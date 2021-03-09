/**
 * 
 */
package main;

import k_weakest_matrix_rows.Solution;

/**
 * @author hp
 *
 */
public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//k_weakest_matrix_rows
		Solution solution = new Solution();
		int[][] mat = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
		int k = 3;
		solution.kWeakestRows(mat, k);
		
		//letter_case_permutation
		letter_case_permutation.Solution lSolution = new letter_case_permutation.Solution();
		lSolution.letterCasePermutation("a1b2");
	}

}
