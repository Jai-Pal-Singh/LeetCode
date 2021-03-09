package short_encoding_of_words;

public class Runner {
    public static void main(String [] args) {
        Solution s = new Solution();
        String [] words = {"me", "time", "bell"};
        // String [] words = {"t"};
        System.out.println(s.minimumLengthEncoding(words));
    }
}
