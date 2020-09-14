package hash.problems;

import java.util.Arrays;
import java.util.HashSet;

public class ArraySubsetOfAnotherArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {10, 30 ,60, 90, 20, 80, 40, 50, 70,30};
		int arr2[] = {30, 70 , 20, 30};
		
		ArraySubsetOfAnotherArray sub = new ArraySubsetOfAnotherArray();
		Boolean answer = sub.isSubSet(arr1, arr2);
		System.out.println(answer);
		Boolean answer1 = sub.usingHash(arr1, arr2);
		System.out.println(answer1);
		Boolean answer2 = sub.usingSort(arr1, arr2);
		System.out.println(answer2);
	}

	//Duplicates are taken care of in this method
	private Boolean usingSort(int[] arr1, int[] arr2) {
		// TODO Auto-generated method stub
		Boolean ans = null;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int n = arr1.length;
		int m = arr2.length;
		if (n < m) {
			ans = false;
		}
		for (int i =0, j=0; i<n && j<m; i++, j++) {
			if(arr1[i] < arr2[j]) {
				i++;
			} else {
				if (arr1[i] == arr2[j]) {
					ans = true;
				} else {
					ans = false;
					break;
				}
			}
		}
		return ans;
	}

	//DrawBack Duplicates are not handled && TimeComplexity O(n) SpaceComplexity O(n)
	private Boolean usingHash(int[] arr1, int[] arr2) {
		// TODO Auto-generated method stub
		HashSet<Integer> h = new HashSet<Integer>();
		for (int i =0; i < arr1.length; i++) {
			if(!h.contains(arr1[i])) {
				h.add(arr1[i]);
			}
		}
		for (int i=0; i<arr2.length; i++) {
			if(!h.contains(arr2[i])) {
				return false;
			}
		}
		
		return true;
	}

	//DrawBack Duplicates are not handled && TimeComplexity O(m*n)
	private Boolean isSubSet(int[] arr1, int[] arr2) {
		Boolean ans = null;
		// TODO Auto-generated method stub
		int n = arr1.length;
		int m = arr2.length;
		if (m > n) {
			ans = false;
		} 
		for (int oValue: arr2) {
			ans = null;
				for (int oVal : arr1) {
					if (oVal == oValue) {
						ans = true;
					}
				}
				if (ans == null) {
					ans = false;
					return ans;
				}
		}
		return ans;
	}
	
}
