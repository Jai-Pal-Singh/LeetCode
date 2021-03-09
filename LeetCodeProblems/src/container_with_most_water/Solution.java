package container_with_most_water;

/**
 * @author hp
 * @implNote Given n non-negative integers a1, a2, ..., an , where each
 *           represents a point at coordinate (i, ai). n vertical lines are
 *           drawn such that the two endpoints of the line i is at (i, ai) and
 *           (i, 0). Find two lines, which, together with the x-axis forms a
 *           container, such that the container contains the most water. Notice
 *           that you may not slant the container.
 * 
 * @implSpec 
 * n == height.length 
 * 2 <= n <= 3 * 104 
 * 0 <= height[i] <= 3 * 104
 */
public class Solution {
	public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while(left<right){
            int currArea = Math.min(height[left], height[right]) *(right - left);
            maxArea  = Math.max(maxArea, currArea);
            if(height[left] < height[right]){
                left++;
            } else{
                right--;
            }
        }
        return maxArea;
    }
//	public int maxArea(int[] height) {
//      
//		Integer left = 0;
//		Integer right = height.length - 1;
//		Integer maximumArea = 0;
//		maximumArea = findMaxArea(height, left, right, maximumArea);
//		System.out.println("MaxArea : "+maximumArea);
//		return maximumArea;
//    }
//
//	private Integer findMaxArea(int[] height, Integer left, Integer right, Integer maximumArea) {
//		
//		if(left > right) {
//			return maximumArea;
//		}
//		Integer shorterLine = height[left] < height[right] ? left : right;
//		Integer area = height[shorterLine]*(right - left);
//		maximumArea = maximumArea > area ? maximumArea : area;
//		System.out.println("left : "+left + " , right : " + right + " , height[left] : " + height[left] + " , height[right] : " +height[right]);
//		System.out.println("area : "+area + " , MaxArea : "+maximumArea);
//		System.out.println();
////		if(shorterLine == left && shorterLine != right) {
////			maximumArea = findMaxArea(height, left+1, right, maximumArea);
////		}
////		else if (shorterLine == right && shorterLine != left){
////			maximumArea = findMaxArea(height, left, right-1, maximumArea);
////		}
////		else {
////			maximumArea = height[left+1] > height[right-1] ? findMaxArea(height, left+1, right, maximumArea) : findMaxArea(height, left, right-1, maximumArea);
////		}
//		if(shorterLine == left && shorterLine != right) {
//			maximumArea = findMaxArea(height, left+1, right, maximumArea);
//		}
//		else {
//			maximumArea = findMaxArea(height, left, right-1, maximumArea);
//		}
//		return maximumArea;
//	}
}
