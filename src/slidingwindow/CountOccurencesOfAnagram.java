package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CountOccurencesOfAnagram
{
	public static void main(String[] args)
	{
		String input = "fxoraxofxo";
		String pattern = "fox";
		int countOccurence = countOccOfAnagram(input, pattern);
		System.out.println(countOccurence);
	}

	private static int countOccOfAnagram(String input, String pattern)
	{
		if (pattern == null || pattern.equals("") || input == null || input.equals("")) {
			return -1;
		}
		int windowSize = pattern.length();
		int i=0, j=0, count=0, result=0;

		Map<Character, Integer> countMap = new HashMap<>();

		//populate map
		for (int k=0; k<windowSize; k++) {
			Integer charCount = countMap.get(pattern.charAt(k));
			if (charCount == null) {
				countMap.put(pattern.charAt(k), 1);
			} else {
				countMap.put(pattern.charAt(k), charCount+1);
			}
		}

		//count of distinct characters
		count = countMap.keySet().size();

		//sliding window code
		while (j < input.length()) {
			char endChar = input.charAt(j);
			if (countMap.containsKey(endChar)) {
				countMap.put(endChar, countMap.get(endChar) -1);
			}
			if (countMap.get(endChar)!=null && countMap.get(endChar)==0) {
				count--;
			}
			if (j-i+1 == windowSize) {
				if (count==0) {
					result++;
				}
				char startchar = input.charAt(i);
				// calculation for character at moving out of window
				if(countMap.containsKey(startchar)){
					countMap.put(startchar,countMap.get(startchar)+1);
				}
				if(countMap.get(startchar) !=null && countMap.get(startchar) == 1){
					count ++;
				}
				i++;
			}
			j++;
		}
		return result;
	}
}
