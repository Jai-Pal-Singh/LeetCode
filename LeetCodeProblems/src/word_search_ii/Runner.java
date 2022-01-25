package word_search_ii;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        char[][] board = new char[][] {
                { 'o', 'a', 'a', 'n' }, 
                { 'e', 't', 'a', 'e' }, 
                { 'i', 'h', 'k', 'r' }, 
                { 'i', 'f', 'l', 'v' }
        };
        String[] words = new String[]{"oath","pea","eat","rain"};
        ArrayFunctions.printListString(new Solution().findWords(board, words));
    }
}
