package palindrome_partitioning;

import java.util.*;
import java.util.List;

// Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

// A palindrome string is a string that reads the same backward as forward.

 

// Example 1:

// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]
// Example 2:

// Input: s = "a"
// Output: [["a"]]
 

// Constraints:

// 1 <= s.length <= 16
// s contains only lowercase English letters.

/**
 * Solution
Overview
The aim to partition the string into all possible palindrome combinations. To achieve this, we must generate all possible substrings of a string by partitioning at every index until we reach the end of the string. Example, abba can be partitioned as ["a","ab","abb","abba"]. Each generated substring is considered as a potential candidate if it a Palindrome.

Let's look at a few approaches to implement this idea.

Approach 1: Backtracking
Intuition

The idea is to generate all possible substrings of a given string and expand each possibility if is a potential candidate. The first thing that comes to our mind is Depth First Search. In Depth First Search, we recursively expand potential candidate until the defined goal is achieved. After that, we backtrack to explore the next potential candidate.

Backtracking incrementally build the candidates for the solution and discard the candidates (backtrack) if it doesn't satisfy the condition.

The backtracking algorithms consists of the following steps:

Choose: Choose the potential candidate. Here, our potential candidates are all substrings that could be generated from the given string.

Constraint: Define a constraint that must be satisfied by the chosen candidate. In this case, the constraint is that the string must be a palindrome.

Goal: We must define the goal that determines if have found the required solution and we must backtrack. Here, our goal is achieved if we have reached the end of the string.

Algorithm

In the backtracking algorithm, we recursively traverse over the string in depth-first search fashion. For each recursive call, the beginning index of the string is given as \text{start}start.

Iteratively generate all possible substrings beginning at \text{start}start index. The \text{end}end index increments from \text{start}start till the end of the string.

For each of the substring generated, check if it is a palindrome.

If the substring is a palindrome, the substring is a potential candidate. Add substring to the \text{currentList}currentList and perform a depth-first search on the remaining substring. If current substring ends at index \text{end}end, \text{end}+1end+1 becomes the \text{start}start index for the next recursive call.

Backtrack if \text{start}start index is greater than or equal to the string length and add the \text{currentList}currentList to the result.

Current
1 / 10
Implementation


Complexity Analysis

Time Complexity : \mathcal{O}(N \cdot 2^{N})O(N⋅2 
N
 ), where NN is the length of string ss. This is the worst-case time complexity when all the possible substrings are palindrome.
Example, if = s = aaa, the recursive tree can be illustrated as follows:

img

Hence, there could be 2^{N}2 
N
  possible substrings in the worst case. For each substring, it takes \mathcal{O}(N)O(N) time to generate substring and determine if it a palindrome or not. This gives us time complexity as \mathcal{O}(N \cdot 2^{N})O(N⋅2 
N
 )

Space Complexity: \mathcal{O}(N)O(N), where NN is the length of the string ss. This space will be used to store the recursion stack. For s = aaa, the maximum depth of the recursive call stack is 3 which is equivalent to NN.
 */
public class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(0, result, new ArrayList<>(), s);
        return result;
    }

    void dfs(int start, List<List<String>> result, List<String> currentList, String s) {
        if (start >= s.length()) result.add(new ArrayList<>(currentList));
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                // add current substring in the currentList
                currentList.add(s.substring(start, end + 1));
                dfs(end + 1, result, currentList, s);
                // backtrack and remove the current substring from currentList
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}