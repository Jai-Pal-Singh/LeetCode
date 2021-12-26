package k_closest_points_to_origin;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the
 * X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 * 
 * The distance between two points on the X-Y plane is the Euclidean distance
 * (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * 
 * You may return the answer in any order. The answer is guaranteed to be unique
 * (except for the order that it is in).
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest k = 1 points from the origin, so the answer is just
 * [[-2,2]].
 * Example 2:
 * 
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 * 
 * 
 * Constraints:
 * 
 * 1 <= k <= points.length <= 104
 * -104 < xi, yi < 104
 * 
 */
/* 
 Overview 
 Finding the kk closest points to the origin will require us to first be able to calculate the distance of a given point to the origin before we can start to evaluate the relative closeness of any two points.

In order to evaluate the distance from the origin to a given point,we must use the Euclidean distance equation.This equation starts with the Pythagorean theorem,(a^2+b^2=c^2 a 2+b 2=c 2)which calculates the distance of the hypotenuse(cc)of a right triangle when the length of the other two sides(aa,bb)is known.

Given two Euclidean points,we can determine the values for aa and bb by taking the difference of the two xx coordinates(a=x_1-x_2a=x 1 ​−x 2 ​)and the two yy coordinates(b=y_1-y_2b=y 1 ​−y 2 ​).Plugging these values into the Pythagorean theorem and solving for the length of cc,we get the Euclidean distance equation(dist=\sqrt{(x_1-x_2)^2+(y_1-y_2)^2}dist=(x 1 ​−x 2 ​)2+(y 1 ​−y 2 ​)2

​).

In this problem,with one of the two Euclidean coordinates being the origin(0,00,0),this simplifies the Euclidean distance equation back to the original Pythagorean theorem(dist=\sqrt{(x-0)^2+(y-0)^2}=\sqrt{x^2+y^2}dist=(x−0)2+(y−0)2

​=x 2+y 2

​).

We can also simplify the process of comparing two points by using the squared Euclidean distance instead of the precise Euclidean distance,as both will yield the same result.This allows us to remove the square root from each side of the equation(\sqrt{{x_1}^2+{y_1}^2}<\sqrt{{x_2}^2+{y_2}^2}x 1 ​

2+y 1 ​

2

​<x 2 ​

2+y 2 ​

2

​)==({x_1}^2+{y_1}^2<{x_2}^2+{y_2}^2 x 1 ​

2+y 1 ​

2<x 2 ​

2+y 2 ​

2)which will significantly reduce the overall computational time for each comparison made.

Approach 1:Sort with Custom Comparator Intuition

We can reframe the problem as finding kk points with the smallest squared Euclidean distance from the origin.When seeking the smallest elements in a list,an intuitive first step is to sort the list,as this will bring the smallest elements to the front.

Therefore,in this problem,we can sort the entire points array using a custom comparator function that applies the squared Euclidean distance equation.After the sorting process is completed,we just return the first kk elements of the sorted array.

This solution is trivial,and while it gets the job done,it should not be considered an ideal candidate for an interview response.As we will see,there are more efficient options from which to choose.

Algorithm

Sort the array with a custom comparator function.The custom comparator function will use the squared Euclidean distance equation to compare two points.Return the first kk elements of the array.

Complexity Analysis

Here NN refers to the length of the given array points.

Time complexity:O(N\cdot\log N)O(N⋅logN)for the sorting of points.

While sorting methods vary between different languages,most have a worst-case or average time complexity of O(N\cdot\log N)O(N⋅logN).

Space complexity:O(\log N)O(logN)to O(N)O(N)for the extra space required by the sorting process.

As with the time complexity,the space complexity of the sorting method used can vary from language to language.C++'sSTL,for example,uses QuickSort most of the time but will switch to either HeapSort or InsertionSort depending on the nature of the data.Java uses a variant of QuickSort with dual pivots when dealing with arrays of primitive values.The implementation of both C++'s and Java's sort methods will require an average of O(\log N)O(logN)extra space.Python,on the other hand,uses TimSort,which is a hybrid of MergeSort and InsertionSort and requires O(N)O(N)extra space.Unlike most other languages,Javascript'ssort method will actually vary from browser to browser.Since the adoption of ECMAScript 2019,however,the sort method is required to be stable,which generally means MergeSort or TimSort and a space complexity of O(N)O(N).

Approach 2:Max Heap or Max Priority Queue Intuition

While we must iterate over all elements in the points array,we only need to keep track of the kk closest points encountered so far.We could therefore choose to store them in a separate data structure.In order to keep this data structure capped at kk elements,we will need to keep track of the point that is farthest away from the origin and thus the next point to be removed when a closer point is found.

The ideal data structure for this purpose is a max heap or max priority queue.These data structures allow access to the max value in constant time and perform replacements in logarithmic time.

Note:We can simulate max heap functionality in a min heap data structure by inserting-dist−dist instead of distdist,if necessary.

At the start of our iteration through points,we will insert the first kk elements into our heap.Once the heap is"full",we can then compare each new point to the farthest point stored in the heap.If the new point is closer,then we should remove the farthest point from the heap and insert the new point.

After the entire points array has been processed,we can create an array from the points stored in the heap and then return the answer.

Algorithm

Use a max heap(or max priority queue)to store points by distance.Store the first kk elements in the heap.Then only add new elements that are closer than the top point in the heap while removing the top point to keep the heap at kk elements.Return an array of the kk points stored in the heap.
 */
public class Solution {

    public int[][] kClosest(int[][] points, int k) {
        // Use a lambda comparator to sort the PQ by farthest distance
        Queue<int[]> maxPQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < points.length; i++) {
            int[] entry = { squaredDistance(points[i]), i };
            if (maxPQ.size() < k) {
                // Fill the max PQ up to k points
                maxPQ.add(entry);
            } else if (entry[0] < maxPQ.peek()[0]) {
                // If the max PQ is full and a closer point is found,
                // discard the farthest point and add this one
                maxPQ.poll();
                maxPQ.add(entry);
            }
        }

        // Return all points stored in the max PQ
        int[][] answer = new int[k][2];
        for (int i = 0; i < k; i++) {
            int entryIndex = maxPQ.poll()[1];
            answer[i] = points[entryIndex];
        }
        return answer;
    }

    private int squaredDistance(int[] point) {
        // Calculate and return the squared Euclidean distance
        return point[0] * point[0] + point[1] * point[1];
    }
}