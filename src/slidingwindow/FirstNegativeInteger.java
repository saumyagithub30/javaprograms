package slidingwindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Find the first negative integer in every window of size k
public class FirstNegativeInteger
{
	public static void main(String[] args)
	{
		int arr[] = {12, -1, -7, 8, -15, 30, 16, 28 };
		int k = 3;
		ArrayList<Integer> list = firstNegativeInSubArray(arr, k);
		for(int i=0; i< list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

	private static ArrayList<Integer> firstNegativeInSubArray(int[] arr, int k)
	{
		ArrayList<Integer> negativeNumberList = new ArrayList<>();
		Queue<Integer> list = new LinkedList<Integer>();
		int i =0, j=0;
		int n = arr.length;
		while(j < n) {
			if (arr[j] < 0) {
				list.add(arr[j]);
			}
			if (j - i + 1 == k ) {
				if (list.isEmpty()) {
					negativeNumberList.add(0);
				} else {
					if(arr[i] < 0) {
						negativeNumberList.add(list.poll());
					}
				}
				i++;
			}
			j++;
		}
		return negativeNumberList;
	}
}
