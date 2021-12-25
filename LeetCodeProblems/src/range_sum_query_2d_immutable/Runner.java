package range_sum_query_2d_immutable;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args){
        NumMatrix numMatrix = new NumMatrix(new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}});
        BasicFunctions.print(numMatrix.sumRegion(2,1,4,3));
        BasicFunctions.print(numMatrix.sumRegion(1,1,2,2));
        BasicFunctions.print(numMatrix.sumRegion(1,2,2,4));
    }
}
