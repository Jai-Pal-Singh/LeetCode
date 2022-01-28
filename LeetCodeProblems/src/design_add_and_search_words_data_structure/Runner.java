package design_add_and_search_words_data_structure;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        BasicFunctions.print(obj.search("pad"));
        BasicFunctions.print(obj.search("bad"));
        BasicFunctions.print(obj.search(".ad"));
        BasicFunctions.print(obj.search("p.."));
    }
}
