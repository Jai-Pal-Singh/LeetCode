package helper;

import java.util.Arrays;

public class ArrayFunctions {
    
    public static void print(int[] nums){
        System.out.println(Arrays.toString(nums));
    }

    public static void print(int[][] nums){
        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }       
    }
}
