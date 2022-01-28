package design_add_and_search_words_data_structure;

public class Trie {
    String word = "";
    Trie[] next = new Trie[26];

    public void addWord(String word, Trie head) {
        Trie ptr = head;
        for (char c : word.toCharArray()) {
            if (ptr.next[c - 'a'] == null) {
                ptr.next[c - 'a'] = new Trie();
            }
            ptr = ptr.next[c - 'a'];
        }
        ptr.word = word;
    }

    public boolean searchWord(String word, int index, Trie ptr) {
        if (index > word.length()) {
            return false;
        }
        if (index == word.length()) {
            if (!ptr.word.equals("")) {
                return true;
            } else {
                return false;
            }
        } else {
            char c = word.charAt(index);
            if (c == '.') {
                for (int i = 0; i < 26; i++) {
                    if (ptr.next[i] != null && searchWord(word, index + 1, ptr.next[i])) {
                        return true;
                    }
                }
                return false;
            } else {
                if (ptr.next[c - 'a'] != null) {
                    return searchWord(word, index + 1, ptr.next[c - 'a']);
                } else {
                    return false;
                }
            }
        }
    }
}
