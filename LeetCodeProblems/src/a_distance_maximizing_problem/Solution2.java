package a_distance_maximizing_problem;

/**
 * Another Approach: ( only using one extra array )
We consider an auxiliary array : rightMax[] , such that, rightMax[i] = max element of the subarray arr[i…(n-1)], the largest or equal element after arr[i] element

Suppose (arr[i], arr[jLast] ) is a pair, such that arr[jLast] is the last greater or equal element than arr[i]. For the pairs ending with arr[jLast] :  ( arr[k], arr[jLast] ) for all k = (i+1) to jLast

we don’t need to consider (jLast – k) because (jLast – i ) > (jLast – k) for all such k’s.

So we can skip those pairs.

Traversing from left to right of both arrays : arr[] and rightMax[]  , when we first encounter rightMax[j] < arr[i[  , we know that jLast = j-1, and we can skip the pairs (arr[k], arr[jLast]) for all k = (i+1) to jLast. 

And also rightMax[] is non increasing sequence , so all elements at right side of rightMax[j] is smaller than or equal to rightMax[j]. But there may be arr[x]  after arr[i] (x > i) such that arr[x] < rightMax[j] for x > i, so increment i when rightMax[j] < arr[i] is encountered.

Time complexity : O(n) : As i and j pointers are traversing at most n elements, time complexity  = O(n) + O(n) = O(n)
Space Complexity : O(n)
 */
public class Solution2 {
    public int maxIndexDiff(int arr[], int n) {
        int[] rightMax = new int[n];
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);

        int maxDist = Integer.MIN_VALUE;
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (rightMax[j] >= arr[i]) {
                maxDist = Math.max(maxDist, j - i);
                j++;
            } else // if(rightMax[j] < leftMin[i])
                i++;
        }
        return maxDist;
    }
}
