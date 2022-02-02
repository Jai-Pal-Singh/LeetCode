package alien_dictionary;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a sorted dictionary (array of words) of an alien language, find order of characters in the language.

Examples:  

Input:  words[] = {"baa", "abcd", "abca", "cab", "cad"}
Output: Order of characters is 'b', 'd', 'a', 'c'
Note that words are sorted and in the given language "baa" 
comes before "abcd", therefore 'b' is before 'a' in output.
Similarly we can find other orders.

Input:  words[] = {"caa", "aaa", "aab"}
Output: Order of characters is 'c', 'a', 'b'
 */


/**
  * Approach:
     * - build a set of all characters in words
     * - each pair of adjacent words (might) give a relation between two characters
     *   -> build a directed graph from these relations: x comes before y --> there is a directed graph from x to y
     * - use topological sorting to order the graph nodes
     *   -> run DFS on the graph. when we're done with a node add it to the beginning of a list
     *   -> the order of characters in the list is the alphabetical order
     *     ->> note that nodes in this list will only have edges pointing "forward"
 * 
 * @Link: https://leetcode.com/discuss/interview-question/248131/microsoft-interview-round-1-alien-dictionary
 * 
 */

public class Solution {

    public char[] getAlphabet(String[] sortedWords) {
        if (sortedWords == null || sortedWords.length == 0) {
            return new char[0];
        }
        Set<Character> nodes = new HashSet<>();
        for (String w : sortedWords) {
            addChars(nodes, w);
        }
        // map from a node to all its neighbours = those it has edges to them
        // { a --> {b, c} } = edges are: a-->b and a-->c
        Map<Character, Set<Character>> outgoingEdges = new HashMap<>();
        // get a relation (=edge) from pairs of adjacent words
        for (int i = 1; i < sortedWords.length; i++) {
            char[] relation = getRelation(sortedWords[i - 1], sortedWords[i]);
            if (relation.length != 0) {
                addEdge(outgoingEdges, relation[0], relation[1]);
            }
        }
        List<Character> sortedChars = topologicalSort(nodes, outgoingEdges);
        char[] alphabet = new char[sortedChars.size()];
        int i = 0;
        for (char c : sortedChars) {
            alphabet[i++] = c;
        }
        return alphabet;
    }

    // make sure all characters in s are in chars set
    private void addChars(Set<Character> chars, String s) {
        for (char c : s.toCharArray()) {
            chars.add(c);
        }
    }

    // w1 comes before w2 in lexicographic order
    // extract a relation between chars and return it
    // {x, y} means that x comes before y. null means we could not get a relation
    private char[] getRelation(String w1, String w2) {
        int len1 = w1.length();
        int len2 = w2.length();
        int len = Math.min(len1, len2);
        for (int i = 0 ; i < len; i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                return new char[] { w1.charAt(i), w2.charAt(i) };
            }
        }
        // could not find a relation
        return new char[] {};
    }

    private void addEdge(Map<Character, Set<Character>> outgoingEdges, char from, char to) {
        Set<Character> neighbours = outgoingEdges.get(from);
        if (neighbours == null) {
            neighbours = new HashSet<>();
            outgoingEdges.put(from, neighbours);
        }
        neighbours.add(to);
    }

    // for each unvisited node, run DFS starting from that node.
    // add nodes we're done with to the sortedNodes list
    private List<Character> topologicalSort(Set<Character> nodes, Map<Character, Set<Character>> outgoingEdges) {
        LinkedList<Character> sortedNodes = new LinkedList<>();
        Set<Character> visited = new HashSet<>();
        for (Character node : nodes) {
            if (!visited.contains(node)) {
                dfs(sortedNodes, outgoingEdges, visited, node);
            }
        }
        return sortedNodes;
    }

    private void dfs(LinkedList<Character> sortedNodes, Map<Character, Set<Character>> outgoingEdges,
            Set<Character> visited, Character curNode) {

        visited.add(curNode);
        for (Character neighbour : outgoingEdges.getOrDefault(curNode, Collections.emptySet())) {
            if (!visited.contains(neighbour)) {
                dfs(sortedNodes, outgoingEdges, visited, neighbour);
            }
        }
        sortedNodes.addFirst(curNode);
    }
}
