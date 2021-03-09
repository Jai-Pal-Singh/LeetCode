package roman_to_integer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jai Pal Singh
 * @implNote Roman numerals are represented by seven different symbols: I, V, X,
 *           L, C, D and M.
 * 
 *           Symbol Value I 1 V 5 X 10 L 50 C 100 D 500 M 1000 For example, 2 is
 *           written as II in Roman numeral, just two one's added together. 12
 *           is written as XII, which is simply X + II. The number 27 is written
 *           as XXVII, which is XX + V + II.
 * 
 *           Roman numerals are usually written largest to smallest from left to
 *           right. However, the numeral for four is not IIII. Instead, the
 *           number four is written as IV. Because the one is before the five we
 *           subtract it making four. The same principle applies to the number
 *           nine, which is written as IX. There are six instances where
 *           subtraction is used:
 * 
 *           I can be placed before V (5) and X (10) to make 4 and 9. X can be
 *           placed before L (50) and C (100) to make 40 and 90. C can be placed
 *           before D (500) and M (1000) to make 400 and 900. Given a roman
 *           numeral, convert it to an integer.
 * 
 * @implSpec Constraints:
 * 
 *           1 <= s.length <= 15 s contains only the characters ('I', 'V', 'X',
 *           'L', 'C', 'D', 'M'). It is guaranteed that s is a valid roman
 *           numeral in the range [1, 3999].
 *
 */
public class Solution {
	static Map<Character, Integer> values = new HashMap<>();
    static {
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);
    }

    public int romanToInt(String s) {
        int ans = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (i+1 < n && values.get(s.charAt(i)) < values.get(s.charAt(i+1))) {
				// If current is a small value and next is a bigger value -> It's a combine number
                ans -= values.get(s.charAt(i));
            } else {
                ans += values.get(s.charAt(i));
            }
        }
        return ans;
    }
//	public int romanToInt(String s) {
//		int length = s.length() - 1;
//		int result = 0;
//		while(length > -1) {
//			switch (s.charAt(length)) {
//			case 'I': {
//				result += 1;
//				length -=1;
//				break;
//			}
//			case 'V': {
//				if(((length-1) > -1) && (s.charAt(length-1) == 'I')) {
//					result += 4;
//					length -= 2;
//				}
//				else {
//					result += 5;
//					length -= 1;
//				}
//				break;
//			}
//			case 'X': {
//				if(((length-1) > -1) && (s.charAt(length-1) == 'I')) {
//					result += 9;
//					length -= 2;
//				}
//				else {
//					result += 10;
//					length -= 1;
//				}
//				break;
//			}
//			case 'L': {
//				if(((length-1) > -1) && (s.charAt(length-1) == 'X')) {
//					result += 40;
//					length -= 2;
//				}
//				else {
//					result += 50;
//					length -= 1;
//				}
//				break;
//			}
//			case 'C': {
//				if(((length-1) > -1) && (s.charAt(length-1) == 'X')) {
//					result += 90;
//					length -= 2;
//				}
//				else {
//					result += 100;
//					length -= 1;
//				}
//				break;
//			}
//			case 'D': {
//				if(((length-1) > -1) && (s.charAt(length-1) == 'C')) {
//					result += 400;
//					length -= 2;
//				}
//				else {
//					result += 500;
//					length -= 1;
//				}
//				break;
//			}
//			case 'M': {
//				if(((length-1) > -1) && (s.charAt(length-1) == 'C')) {
//					result += 900;
//					length -= 2;
//				}
//				else {
//					result += 1000;
//					length -= 1;
//				}
//				break;
//			}
//			default:
//				throw new IllegalArgumentException("Unexpected value: " + s.charAt(length));
//			}
//		}
//		return result;
//	}
}
