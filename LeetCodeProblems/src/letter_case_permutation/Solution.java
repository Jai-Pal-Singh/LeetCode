package letter_case_permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hp
 * @implSpec 
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string. 
 * Return a list of all possible strings we could create. You can return the output in any order.
 * @implNote
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 */
public class Solution {
	public List<String> letterCasePermutation(String S) {
        Integer length = S.length();
        List<String> permutations = new ArrayList<>();
        permutations.add(S);
        generatePermutations(S, length, permutations);
		return permutations;
    }

	private void generatePermutations(String s, Integer length, List<String> permutations) {
		for(int i = 0; i<length; i++) {
			if(Character.isDigit(s.charAt(i))) {
				continue;
			}
			List<String> tempList = new ArrayList<>();
			for(String letter : permutations){
				
				String lowerCaseString = getLowerCaseString(letter, i, length); 
				String upperCaseString = getUpperCaseString(letter, i, length); 
				tempList.add(lowerCaseString);
				tempList.add(upperCaseString);
			}
			permutations.clear();
			permutations.addAll(tempList);
			tempList.clear();
		}
	}

	private String getUpperCaseString(String letter, int index, Integer length) {
		String lowerCase;
		if(index==0) {
			lowerCase = letter.substring(index, index+1).toLowerCase() + letter.substring(index+1);
		}
		else {
			lowerCase = letter.substring(0, index) + letter.substring(index, index+1).toLowerCase() + letter.substring(index+1);
		}
		return lowerCase;
	}

	private String getLowerCaseString(String letter, int index, Integer length) {
		String upperCase;
		if(index==0) {
			upperCase = letter.substring(index, index+1).toUpperCase() + letter.substring(index+1);
		}
		else {
			upperCase = letter.substring(0, index) + letter.substring(index, index+1).toUpperCase() + letter.substring(index+1);
		}
		return upperCase;
	}
}
