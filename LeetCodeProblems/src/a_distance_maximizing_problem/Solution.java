package a_distance_maximizing_problem;

/**
 * Given an array arr[], find the maximum j – i such that arr[j] > arr[i].

Examples : 

  Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
  Output: 6  (j = 7, i = 1)

  Input: {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}
  Output: 8 ( j = 8, i = 0)

  Input:  {1, 2, 3, 4, 5, 6}
  Output: 5  (j = 5, i = 0)

  Input:  {6, 5, 4, 3, 2, 1}
  Output: -1
 */


/**
 * Solution
 * 
 * To solve this problem, we need to get two optimum indexes of arr[]: left index i and right index j. For an element arr[i], we do not need to consider arr[i] for left index if there is an element smaller than arr[i] on left side of arr[i]. Similarly, if there is a greater element on right side of arr[j] then we do not need to consider this j for right index. So we construct two auxiliary arrays LMin[] and RMax[] such that LMin[i] holds the smallest element on left side of arr[i] including arr[i], and RMax[j] holds the greatest element on right side of arr[j] including arr[j]. After constructing these two auxiliary arrays, we traverse both of these arrays from left to right. While traversing LMin[] and RMax[] if we see that LMin[i] is greater than RMax[j], then we must move ahead in LMin[] (or do i++) because all elements on left of LMin[i] are greater than or equal to LMin[i]. Otherwise we must move ahead in RMax[j] to look for a greater j – i value.

Thanks to celicom for suggesting the algorithm for this method. 

Working Example:

Lets consider any example [7 3 1 8 9 10 4 5 6]

what is maxRight ?

Filling from right side 6 is first element now 6 > 5 so again we fill 6 till we reach 10 > 6 :

[10 10 10 10 10 10 6 6 6] this is maxR

[7 3 1 1 1 1 1 1 1 ] this is minL

now we see that how to reach answer from these to and its proof !!!

lets compare first elements of the arrays now we see 10 > 7,

now we increase maxR by 1 till it becomes lesser than 7 i.e at index 5

hence answer till now is. 5-0 = 5

now we will increase minL we get 3 which is lesser than 6 so we increase maxR till it reaches last index and the answer becomes 8-1= 7

so we see how we are getting correct answer.

As we need the max difference j – i such that A[i]<= A[j], hence we do not need to consider element after the index j and element before index i.

in previous hint, make 2 arrays,

First, will store smallest occurring element before the element

Second, will store largest occurring element after the element

Traverse the Second array, till the element in second array is larger than or equal to First array, and store the index difference. And if it becomes smaller, traverse the first array till it again becomes larger.

And store the max difference of this index difference.
 */

public class Solution {

    public int maxIndexDiff(int[] arr, int n) {
        int maxDiff;
        int i, j;
        int[] rightMax = new int[n];
        int[] leftMin = new int[n];

        leftMin[0] = arr[0];
        for (i = 1; i < n; ++i)
            leftMin[i] = Math.min(arr[i], leftMin[i - 1]);
        rightMax[n - 1] = arr[n - 1];
        for (j = n - 2; j >= 0; --j)
            rightMax[j] = Math.max(arr[j], rightMax[j + 1]);

        i = 0;
        j = 0;
        maxDiff = -1;
        while (j < n && i < n) {
            if (leftMin[i] <= rightMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j = j + 1;
            } else
                i = i + 1;
        }
        return maxDiff;
    }
}