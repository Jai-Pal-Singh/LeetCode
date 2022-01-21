package max_points_on_a_line;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

 

Example 1:


Input: points = [[1,1],[2,2],[3,3]]
Output: 3
Example 2:


Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
 

Constraints:

1 <= points.length <= 300
points[i].length == 2
-104 <= xi, yi <= 104
All the points are unique.
 */

public class Solution {
    public int maxPoints(int[][] points) {
        Map<Double, Integer> slope = new HashMap<>();
        int max = 0;
        for(int i = 0; i<points.length-max; i++){
            int iMax = 0;
            for(int j = i+1; j<points.length; j++){
                Double currSlope = (points[j][0]-points[i][0])==0 ? Double.MAX_VALUE : (points[j][0]>points[i][0]) ? ((double)(points[j][1]-points[i][1])/(double)(points[j][0]-points[i][0])) : ((double)(points[i][1]-points[j][1])/(double)(points[i][0]-points[j][0]));
                slope.put(currSlope, slope.getOrDefault(currSlope, 0)+1);
                iMax = Math.max(iMax, slope.get(currSlope));
            }
            slope.clear();
            max = Math.max(max, iMax);
        }
        return max+1;
    }
}
