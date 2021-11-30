package permutation_in_string;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        BasicFunctions.print(new Solution().checkInclusion("ab", "eidbaooo")); //true
        BasicFunctions.print(new Solution().checkInclusion("ab", "eidboaooo")); //false
        BasicFunctions.print(new Solution().checkInclusion("adc", "dcda")); //true
        BasicFunctions.print(new Solution().checkInclusion("hello", "ooolleoooleh")); //false
    }
}
