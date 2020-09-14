package hash.problems;

import java.util.HashMap;
import java.util.Map;

public class findPairsAPlusBeqCPlusDInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3, 4, 7, 1, 2, 9, 8, 6}; 
		findPairsAPlusBeqCPlusDInArray find = new findPairsAPlusBeqCPlusDInArray();
		find.findPair(arr);
	}

	private void findPair(int[] arr) {
		// TODO Auto-generated method stub
		Map<Integer,pair> hmap = new HashMap<Integer, pair>();
		int n = arr.length;
		
		for (int i=0; i<n ; i++) {
			for (int j=i+1; j<n; j++) {
				int sum = arr[i] + arr[j];
				if (!hmap.containsKey(sum)) {
					hmap.put(sum, new pair(i, j));
				} else {
					pair p = hmap.get(sum);
					System.out.println("Pair is " + "(" + arr[p.first] + "," + arr[p.second] + ") " + "(" + arr[i] + "," + arr[j] + ")");
					break;
				}
			}
		}
	}

}
