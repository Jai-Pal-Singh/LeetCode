package magical_sequence;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt(); 
        for (int i = 0; i < t; i++) {
            int len = sc.nextInt();
            int[] num = new int[len];
            for (int j = 0; j < num.length; j++) {
                num[j] = sc.nextInt();
            }
            System.out.println(sol.magicalSequence(len, num));
        }
        // int[] num = new int[]{4,1,2,0,1,9,5,3,7,8,8,9,6,3,8,2,4,0,3,3,5,5,6,5,5,5,6,7,2};
        // System.out.println(sol.magicalSequence(29, num));
        sc.close();
    }

    public int magicalSequence(int len, int[] num){
        int count = 0;
        int[] oddSequence = this.getNumSquence(len, num, 0);
        int[] evenSequence = this.getNumSquence(len, num, 1);
        // System.out.println("oddSequence : " + Arrays.toString(oddSequence));
        // System.out.println("evenSequence : " + Arrays.toString(evenSequence));
        int currSum = 0;
        // if(len%2==0){
        //     currSum = oddSequence[len-1];
        // }
        // else{
        //     currSum = evenSequence[len-1];
        // }
            // System.out.println("Before loop");
        for (int i = len-1; i >=0 ; i--) {
            // System.out.println("inside loop: " + i);
            if(i%2==0){
                // evenSequence[i]
                // System.out.println("inside evenSequence : " + evenSequence[i]);
                currSum = evenSequence[i];
                count = this.isSequenceMagical(currSum) ? ++count : count;
                for (int j = i-1; j >= 0; j--) {
                    currSum += evenSequence[j]; 
                    // System.out.println("inside inside loop: " + j + " ; currentSum : "+currSum);
                    count = this.isSequenceMagical(currSum) ? ++count : count;
                }
            }
            else{
                // oddSequence[i]
                // System.out.println("inside oddSequence : "+oddSequence[i]);
                currSum = oddSequence[i];
                count = this.isSequenceMagical(currSum) ? ++count : count;
                for (int j = i-1; j >= 0; j--) {
                    currSum += oddSequence[j]; 
                    // System.out.println("inside inside loop: " + j+ " ; currentSum : "+currSum);
                    count = this.isSequenceMagical(currSum) ? ++count : count;
                }
            }
        }
        // System.out.println("After loop");
        return count;
    }

    private int[] getNumSquence(int len, int[] numArray, int evenOdd) {  
        int [] num = Arrays.copyOf(numArray, len);    
        for (int i = evenOdd; i < num.length; i+=2) {
            int twice = num[i]*2;
            if(twice > 9){
                int n = twice%10;
                num[i] = n + (twice/10);
            }
            else{
                num[i] = twice;
            }
        }
        return num;
    }

    private boolean isSequenceMagical(int sum){
        return (sum%10) == 0;
    }
}
