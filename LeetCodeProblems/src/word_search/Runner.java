package word_search;

public class Runner {
    public static void main(String[] args) {
        helper.BasicFunctions.print(new Solution().exist(new char[][] {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        }, "ABCCED"));
    }
}
