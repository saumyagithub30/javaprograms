package DP.knapsack;

import static java.lang.Math.max;

public class Recursive
{
	public static void main(String[] args)
	{
		int wt[] = new int[] {1, 3, 4, 5};
		int val[] = new int[] {1, 4, 5, 7};
		int W =  7;
		int n = val.length;
		System.out.println(knapsack(wt, val, W, n));
	}

	static int knapsack(int[] wt, int[] val, int capacity, int n)
	{
		//Base case
		if (n==0 || capacity == 0)
			return 0;

		//choice diagram
		if ( wt[n-1] > capacity)
			return knapsack(wt, val, capacity, n-1);
		else
			return max((val[n-1] + knapsack(wt, val, capacity-wt[n-1], n-1)), knapsack(wt, val, capacity, n-1));

	}
}
