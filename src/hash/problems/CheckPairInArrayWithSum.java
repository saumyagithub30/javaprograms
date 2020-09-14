package hash.problems;

import java.util.HashSet;

public class CheckPairInArrayWithSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {8, 2, 6, 3, 4, 5};
		int k = 10;
		CheckPairInArrayWithSum check = new CheckPairInArrayWithSum();
		check.findPair(arr, k); 
	}

	private void findPair(int[] arr, int k) {
		// TODO Auto-generated method stub
		HashSet<Integer> hset = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++ ) {
			int temp = k - arr[i];
			if(hset.contains(temp)) {
				System.out.println("Pair for " + k + " is : " + arr[i] + " " + temp);
			} else {
				hset.add(arr[i]);
			}
		}
		
	}

}
