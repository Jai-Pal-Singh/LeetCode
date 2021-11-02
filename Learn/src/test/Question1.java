package test;

public class Question1 {
    public static void main(String[] args) {
        Question1 q1 = new Question1();
        // Test case 1 : sorted array with one pair of correct answer
        // Output : true 
        System.out.println(q1.twoSum(new int[]{-4, -3, -2, 0, 1 , 4}));

        // Test case 2 : sorted array with two pair of correct answer
        // Output : true 
        System.out.println(q1.twoSum(new int[]{-4, -3, -2, 0, 2 , 4}));

        // Test case 3 : sorted array with no pair of correct answer
        // Output : false 
        System.out.println(q1.twoSum(new int[]{-4, -3, -2, 0, 1 , 5}));

        // Test case 4 : empty array 
        // Output : false 
        System.out.println(q1.twoSum(new int[]{}));

        // Test case 5 : array with one element
        // Output : false 
        System.out.println(q1.twoSum(new int[]{0}));
    }

    // Time Complexity : O(n)
    // Space Complexity : O(1)
    public boolean twoSum(int[] numbers) {
        int target = 0;
        int l = 0, r = numbers.length-1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if(sum == target)
                return true;
            if (sum > target) 
                r--;
            else
                l++;
        }
        return false;
    }
}
