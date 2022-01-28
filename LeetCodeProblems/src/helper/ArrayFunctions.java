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

    public static void print(double[] nums){
        logger.log(Level.INFO, OUTPUT_STRING, Arrays.toString(nums));
    }

    public static void print(boolean[] nums){
        logger.log(Level.INFO, OUTPUT_STRING, Arrays.toString(nums));
    }

    public static void print(List<Integer> nums){
        logger.log(Level.INFO, OUTPUT_STRING, nums.toString());
    }

    public static void printListString(List<String> str) {
        logger.log(Level.INFO, OUTPUT_STRING, str.toString());
    }

    public static void printListListString(List<List<String>> str) {
        for (List<String> s : str) {
            logger.log(Level.INFO, OUTPUT_STRING, s.toString());
        }
    }

    public static void print(int[][] nums){
        for (int[] num : nums) {
            logger.log(Level.INFO, OUTPUT_STRING, Arrays.toString(num));
        }       
    }

    public static void print(boolean[][] nums){
        for (boolean[] num : nums) {
            logger.log(Level.INFO, OUTPUT_STRING, Arrays.toString(num));
        }       
    }

    public static void printList(List<List<Integer>> nums) {
        for (List<Integer> num : nums) {
            print(num);
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
