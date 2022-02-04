package DP.knapsack;

import static java.lang.Math.max;

public class Memoziation
{
	public static void main(String[] args)
	{
		int wt[] = new int[] {1, 3, 4, 5};
		int val[] = new int[] {1, 4, 5, 7};
		int W =  7;
		int N = val.length;
		System.out.println(knapsack(wt, val, W, N));
	}

	private static int knapsack(int[] wt, int[] val, int W, int N) {
		int[][] t = new int[N+1][W+1];
		for (int i=0; i < N+1; i++) {
			for (int j=0; j<W+1; j++) {
				t[i][j]=-1;
			}
		}
		return knapsackRec(wt, val, W, N, t);
	}

	private static int knapsackRec(int[] wt, int[] val, int W, int N, int[][] t)
	{
		if(N==0 || W==0)
			return 0;

		if(t[N][W] != -1)
			return t[N][W];

		if( wt[N-1] > W)
			return t[N][W] = knapsackRec(wt, val, W, N-1, t);
		else
			return t[N][W] = max(val[N-1] + knapsackRec(wt, val, W-wt[N-1], N-1, t), knapsackRec(wt, val, W, N-1, t));
	}
}
