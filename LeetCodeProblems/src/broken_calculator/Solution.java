package broken_calculator;

/**
 * @author hp
 * @implNote On a broken calculator that has a number showing on its display, we
 *           can perform two operations:
 * 
 *           Double: Multiply the number on the display by 2, or; Decrement:
 *           Subtract 1 from the number on the display. Initially, the
 *           calculator is displaying the number X.
 * 
 *           Return the minimum number of operations needed to display the
 *           number Y.
 * 
 * 
 * 
 *           Example 1:
 * 
 *           Input: X = 2, Y = 3 Output: 2 Explanation: Use double operation and
 *           then decrement operation {2 -> 4 -> 3}. 
 *           
 *           Example 2:
 * 
 *           Input: X = 5, Y = 8 Output: 2 Explanation: Use decrement and then
 *           double {5 -> 4 -> 8}. 
 *           
 *           Example 3:
 * 
 *           Input: X = 3, Y = 10 Output: 3 Explanation: Use double, decrement
 *           and double {3 -> 6 -> 5 -> 10}. 
 *           
 *           Example 4:
 * 
 *           Input: X = 1024, Y = 1 Output: 1023 Explanation: Use decrement
 *           operations 1023 times.
 *           
 * @implSpec Note:
 * 
 *           1 <= X <= 10^9, 1 <= Y <= 10^9
 *
 */
public class Solution {
	public int brokenCalc(int X, int Y) {
		int res = 0;
		while (Y > X) {
			res += (Y%2) + 1;
			if(Y%2==0) {
				Y = Y/2;
			}
			else {
				Y = (Y+1)/2;
			}
		}
		return res + X - Y;
	}
//	public int brokenCalc(int X, int Y) {
//		int minOperations = 0;
//		Queue<Integer> queue = new LinkedList<>();
//		queue.add(X);
//		
//		while(!queue.isEmpty()) {
//			int queueSize = queue.size();
//			if(queueSize == 0 || queue.contains(Y)) {
//				return minOperations;
//			}
//			minOperations++;
//			while(queueSize>0) {
//				int x = queue.remove();
//				System.out.println("X :" + x + ", minOperations : " + minOperations + ", queueSize : " + queueSize);
//				if(x>0 && x>Math.floor(Y/2) && x<=1000000000) {
//					queue.add(x-1);
//				}
//				if(x>0 && x<2*Y  && x<=1000000000) {
//					queue.add(x*2);
//				}
//				queueSize--;
//			}
//			queue.stream().forEach(System.out::println);
//		}
//		return minOperations;
////		return findMinOperations(queue, Y, minOperations, distanceFromX+1);
//	}
//
//	private int findMinOperations(Queue<Integer> queue, int y, int minOperations, int distanceFromX) {
//		int x = queue.remove();
//		System.out.println("X : "+ x + ", Y : "+y + " , distance : " + distanceFromX);
//		if(x==y || minOperations < distanceFromX) {
//			return 0;
//		}
//		
//		if(minOperations < distanceFromX) {
//			return distanceFromX;
//		}
//
////		distanceFromX++;
//		int doubleOperations =  (int) 10e9;
////		int decrementOperations =  (int) 10e9;
//		if(x>0 && x>Math.floor(y/2)) {
////			System.out.println("Calling decrement X : "+ (x-1) + ", Y : "+y);
//			queue.add(x-1);
////			decrementOperations = findMinOperations(x-1, y, minOperations);
////			System.out.println("response decrement X : "+ (x-1) + ", is : "+decrementOperations);
//		}
//		if(x>0 && x<2*y) {
////			System.out.println("Calling Double X : "+ (x*2) + ", Y : "+y);
//			queue.add(x*2);
////			doubleOperations = findMinOperations(x*2, y, minOperations);
////			System.out.println("response double X : "+ (x*2) + ", is : "+doubleOperations);
//		}
//		doubleOperations = findMinOperations(queue, y, minOperations, distanceFromX+1);
//		minOperations = Math.min(distanceFromX, doubleOperations)
//	}
}
