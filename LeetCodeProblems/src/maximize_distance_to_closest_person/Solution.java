package maximize_distance_to_closest_person;

/**
 * You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 

Return that maximum distance to the closest person.

 

Example 1:


Input: seats = [1,0,0,0,1,0,1]
Output: 2
Explanation: 
If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.
Example 2:

Input: seats = [1,0,0,0]
Output: 3
Explanation: 
If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats away.
This is the maximum distance possible, so the answer is 3.
Example 3:

Input: seats = [0,1]
Output: 1
 

Constraints:

2 <= seats.length <= 2 * 104
seats[i] is 0 or 1.
At least one seat is empty.
At least one seat is occupied.
 */
public class Solution {

    public int maxDistToClosest(int[] seats) {
        if(seats == null || seats.length == 0) return -1;
        int left = -1, right = -1;
        int len = seats.length;
        int dist = 0;

        int i = 0;
        while(i < len) {
            // while 1 
            while (i < len && seats[i] == 1) {
                i++;
            }
            left = i;
            //while 0
            while(i < len && seats[i] == 0) {
                i++;
            }
            right = i;
            // if start index 0 or end last,dist is (right - left)
            // or dist is Math.ceil((right - left) / 2.0)
            if(left == 0 || right == len) {
                dist = Math.max(right - left, dist);
            } else {
                dist = Math.max((int) Math.ceil((right - left) / 2.0), dist);
            }
        }
        return dist;
    }
}