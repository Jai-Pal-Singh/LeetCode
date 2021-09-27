package binary_gap;

public class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        String bin = Integer.toBinaryString(N);
        int len = bin.lastIndexOf('1');
        int i = bin.indexOf('1');
        if(i==len || i==-1 || len == -1){
            return 0;
        }
        int count = 0;
        while(i<len){
            if(bin.charAt(i) == '0'){
                int temp = 1;
                i++;
                while(i<len && bin.charAt(i) == '0'){
                    temp++;
                    i++;
                }
                count = Math.max(count, temp);
            }
            i++;
        }
        return count;
    }
}
