package hash.problems;

import java.util.HashMap;

public class SubArrayWithEqZerosAndOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 0, 1, 0, 1, 1 , 0, 1, 1, 1, 1, 0};
		findEqZerosAndOnes(arr);
	}

	private static void findEqZerosAndOnes(int[] arr) {
		// TODO Auto-generated method stub

		// Creates an empty hashMap hmap
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>(); 

		int sum = 0;     // Initialize sum of elements 
		int max_len = 0; // Initialize result 
		int ending_index = -1; 
		int n = arr.length;

		for (int i = 0; i < n; i++)  
		{ 
			arr[i] = (arr[i] == 0) ? -1 : 1; 
		} 

		// Traverse through the given array 
		for (int i = 0; i < n; i++)  
		{ 						
			sum += arr[i];  // Add current element to sum 

			// To handle sum=0 at last index 

			if (sum == 0)  
			{ 
				max_len = i + 1; 
				ending_index = i; 
			} 

			// If this sum is seen before, then update max_len 
			// if required 

			if (hmap.containsKey(sum + n))  
			{ 
				if (max_len < i - hmap.get(sum + n))  
				{ 
					max_len = i - hmap.get(sum + n); 
					ending_index = i; 
				} 
			}  
			else // Else put this sum in hash table 
			hmap.put(sum + n, i); 
		} 

		for (int i = 0; i < n; i++)  
		{ 
			arr[i] = (arr[i] == -1) ? 0 : 1; 
		} 

		int end = ending_index - max_len + 1; 
		System.out.println(end + " to " + ending_index); 

		System.out.print(max_len);
	}

}
