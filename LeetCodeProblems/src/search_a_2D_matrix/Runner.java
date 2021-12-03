package search_a_2D_matrix;

public class Runner {

	public static void main(String[] args) {
		int [][] arr= {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		helper.BasicFunctions.print(new Solution().searchMatrix(arr, -5));
	}

}
