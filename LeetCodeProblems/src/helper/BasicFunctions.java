package helper;

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
}
