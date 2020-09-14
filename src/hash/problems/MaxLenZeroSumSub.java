package hash.problems;

import java.util.HashMap;

public class MaxLenZeroSumSub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {15,2,-2,4, 5, -5, -4, 0 , 6};
		MaxLenZeroSumSub sumZero = new MaxLenZeroSumSub();
		sumZero.lengthSubArray(arr);
	}

	private void lengthSubArray(int[] arr) {
		// TODO Auto-generated method stub
		int sum =0;
		int sublength = 0;
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		for (int i = 0 ; i < arr.length ; i++) {
			sum = sum + arr[i];
			
			if (sublength == 0 && arr[i] == 0) {
				sublength = sublength + 1;
			}
			
			if(sum == 0) {
				sublength = i + 1;
			}
			
			Integer prev_i = hmap.get(sum);
			
			if (prev_i != null) {
				sublength = Math.max(sublength,i - prev_i) ;
			} else {
				hmap.put(sum, i);
			}

		}
		System.out.println("Maximum SubArray with sum zero is : " + sublength);
	}

}
