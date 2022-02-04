package DP.knapsack;

import static java.lang.Math.max;

public class TopDown
{
	public static void main(String[] args)
	{
		int wt[] = new int[] {1, 3, 4, 5};
		int val[] = new int[] {1, 4, 5, 7};
		int W =  7;
		int N = val.length;
		System.out.println(knapsack(wt, val, W, N));
	}

	private static int knapsack(int[] wt, int[] val, int w, int n)
	{
		int[][] t = new int[n+1][w+1];
		for (int i=0; i < n+1; i++) {
			for (int j=0; j < w+1; j++) {
				if(i==0 || j==0) {
					t[i][j] = 0;
				}
			}
		}

		for (int i=1; i<n+1; i++) {
			for (int j=1; j<w+1; j++) {
				if (wt[i-1] <= w) {
					t[i][j] = max(val[i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
				} else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][w];
	}
}
