package maximum_number_of_balloons;

public class Solution2 {
    public int maxNumberOfBalloons(String text) {
        int[] letters = new int[26];
        
        for(char c: text.toCharArray()) letters[c - 'a']++;
   
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++) {
            char c = (char)(i + 'a');
            if(c == 'b' || c == 'a' || c == 'n') {
                min = Math.min(min, letters[i]);
            }
            if(c == 'l' || c == 'o') {
                min = Math.min(min, letters[i]/2);
            }
        }

        return min;
    }
}
