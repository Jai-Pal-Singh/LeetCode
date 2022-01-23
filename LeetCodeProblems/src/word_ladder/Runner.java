package word_ladder;

import java.util.ArrayList;
import java.util.List;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        String beginWord = "hit";
        String endWord = "cog";
        BasicFunctions.print(new Solution().ladderLength(beginWord, endWord, wordList));
    }
}
