package hash.problems;

import java.util.HashMap;

public class CountDistinctInWindowSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] =  {1, 2, 1, 3, 4, 2, 3}; 
		int k = 4; 
		countDistinct(arr, k); 
	}

	private static void countDistinct(int[] arr, int k) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		int dist_count = 0; 
		for (int i=0 ; i<k ; i++) {
			if (hmap.get(arr[i]) == null) {
				hmap.put(arr[i], 1);
				dist_count++;
			} else {
				int count = hmap.get(arr[i]);
				hmap.put(arr[i], count+1);
			}
		}

		// Print count of first window 
		System.out.println(dist_count);

		for (int i = k ; i<arr.length ; i++) {
			// Remove first element of previous window 
			// If there was only one occurrence, then 
			// reduce distinct count. 
			if (hmap.get(arr[i-k]) == 1) 
			{ 
				hmap.remove(arr[i-k]); 
				dist_count--; 
			} 
			else // reduce count of the removed element 
			{ 
				int count = hmap.get(arr[i-k]); 
				hmap.put(arr[i-k], count-1); 
			} 
			// Add new element of current window 
			// If this element appears first time, 
			// increment distinct element count 
			if (hmap.get(arr[i]) == null) 
			{ 
				hmap.put(arr[i], 1); 
				dist_count++; 
			} 
			else // Increment distinct element count 
			{ 
				int count = hmap.get(arr[i]); 
				hmap.put(arr[i], count+1); 
			} 
			
			// Print count of current window 
            System.out.println(dist_count);
		}
		
	}

}
