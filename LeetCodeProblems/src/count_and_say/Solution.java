package count_and_say;

public class Solution {
    public String countAndSay(int n) {
        String result = "" ;
        if(n>1){
            result = countAndSay(n-1);
            return say(result);
        }
        return "1";
    }

    private String say(String result) {
        StringBuilder say = new StringBuilder();
        char currentChar = result.charAt(0);
        int count = 0;
        for (int i = 0; i < result.length(); i++) {
            if(currentChar == result.charAt(i)){
                count++;
            }
            else{
                say.append(count).append(currentChar);
                currentChar = result.charAt(i);
                count = 1;
            }
        }
        say.append(count).append(currentChar);
        return say.toString();
    }
}
