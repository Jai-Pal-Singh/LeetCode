package word_ladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
 */

/**
 * 
 * Solution
 * 
 * 
 * 
 * We are given a beginWord and an endWord. Let these two represent start node and end node of a graph. We have to reach from the start node to the end node using some intermediate nodes/words. The intermediate nodes are determined by the wordList given to us. The only condition for every step we take on this ladder of words is the current word should change by just one letter.


We will essentially be working with an undirected and unweighted graph with words as nodes and edges between words which differ by just one letter. The problem boils down to finding the shortest path from a start node to a destination node, if there exists one. Hence it can be solved using Breadth First Search approach.

One of the most important step here is to figure out how to find adjacent nodes i.e. words which differ by one letter. To efficiently find the neighboring nodes for any given word we do some pre-processing on the words of the given wordList. The pre-processing involves replacing the letter of a word by a non-alphabet say, *.


This pre-processing helps to form generic states to represent a single letter change.

For e.g. Dog ----> D*g <---- Dig

Both Dog and Dig map to the same intermediate or generic state D*g.

The preprocessing step helps us find out the generic one letter away nodes for any word of the word list and hence making it easier and quicker to get the adjacent nodes. Otherwise, for every word we will have to iterate over the entire word list and find words that differ by one letter. That would take a lot of time. This preprocessing step essentially builds the adjacency list first before beginning the breadth first search algorithm.

For eg. While doing BFS if we have to find the adjacent nodes for Dug we can first find all the generic states for Dug.

Dug => *ug
Dug => D*g
Dug => Du*
The second transformation D*g could then be mapped to Dog or Dig, since all of them share the same generic state. Having a common generic transformation means two words are connected and differ by one letter.

Approach 1: Breadth First Search
Intuition

Start from beginWord and search the endWord using BFS.

Algorithm

Do the pre-processing on the given wordList and find all the possible generic/intermediate states. Save these intermediate states in a dictionary with key as the intermediate word and value as the list of words which have the same intermediate word.

Push a tuple containing the beginWord and 1 in a queue. The 1 represents the level number of a node. We have to return the level of the endNode as that would represent the shortest sequence/distance from the beginWord.

To prevent cycles, use a visited dictionary.

While the queue has elements, get the front element of the queue. Let's call this word as current_word.

Find all the generic transformations of the current_word and find out if any of these transformations is also a transformation of other words in the word list. This is achieved by checking the all_combo_dict.

The list of words we get from all_combo_dict are all the words which have a common intermediate state with the current_word. These new set of words will be the adjacent nodes/words to current_word and hence added to the queue.

Hence, for each word in this list of intermediate words, append (word, level + 1) into the queue where level is the level for the current_word.

Eventually if you reach the desired word, its level would represent the shortest transformation sequence length.

Termination condition for standard BFS is finding the end word.


Complexity Analysis

Time Complexity: O({M}^2 \times N)O(M 
2
 ×N), where MM is the length of each word and NN is the total number of words in the input word list.

For each word in the word list, we iterate over its length to find all the intermediate words corresponding to it. Since the length of each word is MM and we have NN words, the total number of iterations the algorithm takes to create all_combo_dict is M \times NM×N. Additionally, forming each of the intermediate word takes O(M)O(M) time because of the substring operation used to create the new string. This adds up to a complexity of O({M}^2 \times N)O(M 
2
 ×N).

Breadth first search in the worst case might go to each of the NN words. For each word, we need to examine MM possible intermediate words/combinations. Notice, we have used the substring operation to find each of the combination. Thus, MM combinations take O({M} ^ 2)O(M 
2
 ) time. As a result, the time complexity of BFS traversal would also be O({M}^2 \times N)O(M 
2
 ×N).

Combining the above steps, the overall time complexity of this approach is O({M}^2 \times N)O(M 
2
 ×N).

Space Complexity: O({M}^2 \times N)O(M 
2
 ×N).

Each word in the word list would have MM intermediate combinations. To create the all_combo_dict dictionary we save an intermediate word as the key and its corresponding original words as the value. Note, for each of MM intermediate words we save the original word of length MM. This simply means, for every word we would need a space of {M}^2M 
2
  to save all the transformations corresponding to it. Thus, all_combo_dict would need a total space of O({M}^2 \times N)O(M 
2
 ×N).
Visited dictionary would need a space of O(M \times N)O(M×N) as each word is of length MM.
Queue for BFS in worst case would need a space for all O(N)O(N) words and this would also result in a space complexity of O(M \times N)O(M×N).
Combining the above steps, the overall space complexity is O({M}^2 \times N)O(M 
2
 ×N) + O(M * N)O(M∗N) + O(M * N)O(M∗N) = O({M}^2 \times N)O(M 
2
 ×N) space.

Optimization: We can definitely reduce the space complexity of this algorithm by storing the indices corresponding to each word instead of storing the word itself.
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Since all words are of same length.
    int L = beginWord.length();

    // Dictionary to hold combination of words that can be formed,
    // from any given word. By changing one letter at a time.
    Map<String, List<String>> allComboDict = new HashMap<>();

    wordList.forEach(
        word -> {
          for (int i = 0; i < L; i++) {
            // Key is the generic word
            // Value is a list of words which have the same intermediate generic word.
            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
            List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
            transformations.add(word);
            allComboDict.put(newWord, transformations);
          }
        });

    // Queue for BFS
    Queue<Pair<String, Integer>> Q = new LinkedList<>();
    Q.add(new Pair(beginWord, 1));

    // Visited to make sure we don't repeat processing same word.
    Map<String, Boolean> visited = new HashMap<>();
    visited.put(beginWord, true);

    while (!Q.isEmpty()) {
      Pair<String, Integer> node = Q.remove();
      String word = node.getKey();
      int level = node.getValue();
      for (int i = 0; i < L; i++) {

        // Intermediate words for current word
        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

        // Next states are all the words which share the same intermediate state.
        for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
          // If at any point if we find what we are looking for
          // i.e. the end word - we can return with the answer.
          if (adjacentWord.equals(endWord)) {
            return level + 1;
          }
          // Otherwise, add it to the BFS Queue. Also mark it visited
          if (!visited.containsKey(adjacentWord)) {
            visited.put(adjacentWord, true);
            Q.add(new Pair(adjacentWord, level + 1));
          }
        }
      }
    }

    return 0;
    }
}
