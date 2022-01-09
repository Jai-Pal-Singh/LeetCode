package group_anagrams;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        helper.ArrayFunctions.printListListString(solution.groupAnagrams(strs));
    }
}
