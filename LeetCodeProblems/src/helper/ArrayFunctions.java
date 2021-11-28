package helper;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArrayFunctions {
    
    private static final Logger logger = Logger.getLogger(ArrayFunctions.class.getName());
    private static final String OUTPUT_STRING = "Output : {0}";

    private ArrayFunctions() {
        super();
    }

    public static void print(int[] nums){
        logger.log(Level.INFO, OUTPUT_STRING, Arrays.toString(nums));
    }

    public static void print(List<Integer> nums){
        logger.log(Level.INFO, OUTPUT_STRING, nums.toString());
    }

    public static void print(int[][] nums){
        for (int[] num : nums) {
            logger.log(Level.INFO, OUTPUT_STRING, Arrays.toString(num));
        }       
    }

    public static void print(char[] s){
        logger.log(Level.INFO, OUTPUT_STRING, Arrays.toString(s));
    }

    public static void print(char[][] s){
        for (char[] c : s) {
            logger.log(Level.INFO, OUTPUT_STRING, Arrays.toString(c));
        }       
    }
}
