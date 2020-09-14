package hash.problems;

public class PalindromeSubStringQueries {
	static int p = 101; 
	static int MOD = 1000000007; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Compute Prefix Hash and Suffix Hash Arrays  

		String str = "abaaabaaaba";
		int n = str.length();

		//A Table to store power of 101
		int[] power = new int[n+1];

		computePowers(power, n);

		// Arrays to hold prefix and suffix hash values  
		int[] prefix = new int[n+1];
		int[] suffix = new int[n+1];

		computePrefixHash(str, n, prefix, power);
		computeSuffixHash(str, n, suffix, power);

		Query q[] = {new Query(0, 10), new Query(5, 8), new Query(2, 5), new Query(0, 2)};
		int m = q.length;

		queryResults(str, q, m, n, prefix, suffix, power);
	}

	private static void queryResults(String str, Query[] q, int m, int n, int[] prefix, int[] suffix, int[] power) {
		// TODO Auto-generated method stub
		for (int i = 0; i < m ; i++)  
		{ 
			int L = q[i].L; 
			int R = q[i].R; 

			// Hash Value of Substring [L,R]  
			long hash_LR 
			= ((prefix[R + 1] - prefix[L] + MOD) % MOD 
					* findMMI(power[L]) % MOD) % MOD; 

			// Reverse Hash Value of Substring [L,R]  
			long reverse_hash_LR 
			= ((suffix[n - L] - suffix[n - R - 1] + MOD) % MOD 
					* findMMI(power[n - R - 1]) % MOD) % MOD; 

			// If both are equal then the substring is a palindrome  
			if (hash_LR == reverse_hash_LR) 
			{ 
				if (isPalindrome(str, L, R) == true) 
				{ 
					System.out.printf("The Substring [%d %d] is a "
							+ "palindrome\n", L, R); 
				}  
				else
				{ 
					System.out.printf("The Substring [%d %d] is not a "
							+ "palindrome\n", L, R); 
				} 
			}  
			else 
			{ 
				System.out.printf("The Substring [%d %d] is not a "
						+ "palindrome\n", L, R); 
			} 
		} 

		return; 
	}

	private static boolean isPalindrome(String str, int L, int R) {
		// TODO Auto-generated method stub
		// Keep comparing characters while they are same  
        while (R > L)  
        { 
            if (str.charAt(L++) != str.charAt(R--)) 
            { 
                return (false); 
            } 
        } 
        return (true); 
	}

	private static int findMMI(int n) {
		// TODO Auto-generated method stub
		return modPow(n, MOD - 2); 
	}

	private static int modPow(int base, int exponent) {
		// TODO Auto-generated method stub
		 if (exponent == 0)  
	        { 
	            return 1; 
	        } 
	        if (exponent == 1)  
	        { 
	            return base; 
	        } 
	  
	        int temp = modPow(base, exponent / 2); 
	  
	        if (exponent % 2 == 0)  
	        { 
	            return (temp % MOD * temp % MOD) % MOD; 
	        }  
	        else 
	        { 
	            return (((temp % MOD * temp % MOD) % MOD) * base % MOD) % MOD; 
	        } 
	}

	// A Function to calculate the suffix hash  
	// Suffix hash is nothing but the prefix hash of  
	// the reversed string  
	private static void computeSuffixHash(String str, int n, int[] suffix, int[] power) {
		// TODO Auto-generated method stub
		suffix[0] = 0; 
		suffix[1] = str.charAt(n - 1); 

		for (int i = n - 2, j = 2; i >= 0 && j <= n; i--, j++)  
		{ 
			suffix[j] = (suffix[j - 1] % MOD + (str.charAt(i) % MOD *  power[j - 1] % MOD) % MOD) % MOD; 
		} 

		return; 
	}

	private static void computePrefixHash(String str, int n, int[] prefix, int[] power) {
		// TODO Auto-generated method stub
		prefix[0] = 0;
		prefix[1] = str.charAt(0);

		for (int i=2; i<=n; i++) {
			prefix[i] = (prefix[i-1] % MOD +(str.charAt(i-1) % MOD * power[i-1] % MOD) % MOD) % MOD;
		}

		return;
	}

	// A Dynamic Programming Based Approach to compute the  
	// powers of 101  
	private static void computePowers(int[] power, int n) {
		// TODO Auto-generated method stub        
		power[0] = 1;
		for(int i=1; i<=n; i++) {
			power[i] = (power[i-1] % MOD * p % MOD) % MOD;
		}
		return;
	}

}
