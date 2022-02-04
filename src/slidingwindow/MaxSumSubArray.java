package slidingwindow;

public class MaxSumSubArray
{
	// Find the subarray of window size 3 which has the maximum sum
	public static void main(String[] args)
	{
		int arr[] = {2, 5, 1, 8, 2, 9, 1 };
		int windowSize = 3;
		int sum = maxSum(arr, windowSize);
		System.out.println("maxsum = " + sum);
	}

	private static int maxSum(int[] arr, int windowSize)
	{
		int n = arr.length;
		int i=0, j=0;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		while (j < n) {
			sum = sum + arr[j];
			if(j-i+1 == windowSize) {
				max = Math.max(sum,max);
				sum = sum - arr[i];
				i++;
			}
			j++;
		}
		return max;
	}

}
