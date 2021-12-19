package decode_string;

public class Runner {
    public static void main(String[] args) {
        helper.BasicFunctions.print(new Solution().decodeString("3[a]2[bc]"));
        helper.BasicFunctions.print(new Solution().decodeString("3[a2[c]]"));
        helper.BasicFunctions.print(new Solution().decodeString("2[abc]3[cd]ef"));
        helper.BasicFunctions.print(new Solution().decodeString("abc3[cd]xyz"));
    }
}
