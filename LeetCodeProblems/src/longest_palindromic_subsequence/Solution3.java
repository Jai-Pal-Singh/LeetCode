package longest_palindromic_subsequence;

public class Solution3 {
    int[][] mat;

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        mat = new int[len + 1][len + 1];
        for (int i = 0; i < len + 1; i++) {
            mat[i][0] = 0;
        }
        for (int j = 0; j < len + 1; j++) {
            mat[0][j] = 0;
        }

        String r = new StringBuilder(s).reverse().toString();
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                if (s.charAt(i - 1) == r.charAt(j - 1)) {
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                } else {
                    mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
                }
            }
        }
        return mat[len][len];
    }
}
