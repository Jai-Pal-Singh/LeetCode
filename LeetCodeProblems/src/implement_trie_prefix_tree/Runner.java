package implement_trie_prefix_tree;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        BasicFunctions.print(trie.search("apple"));   // return True
        BasicFunctions.print(trie.search("app"));     // return False
        BasicFunctions.print(trie.startsWith("app")); // return True
        trie.insert("app");
        BasicFunctions.print(trie.search("app"));     // return True
    }
}
