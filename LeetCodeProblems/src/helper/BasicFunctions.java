package helper;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BasicFunctions {
    
    private static final Logger logger = Logger.getLogger(BasicFunctions.class.getName());
    private static final String OUTPUT_STRING = "Output : {0}";

    private BasicFunctions() {
        super();
    }

    public static void print(int num){
        logger.log(Level.INFO, OUTPUT_STRING, num);
    }

    public static void print(double num){
        logger.log(Level.INFO, OUTPUT_STRING, num);
    }

    public static void print(boolean num){
        logger.log(Level.INFO, OUTPUT_STRING, num);
    }

    public static void print(String str){
        logger.log(Level.INFO, OUTPUT_STRING, str);
    }

    public static void print(Map<Character, Integer> map) {
        logger.log(Level.INFO, OUTPUT_STRING, map.toString());
    }
}
