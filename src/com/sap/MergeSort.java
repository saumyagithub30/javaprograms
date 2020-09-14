package com.sap;

public class MergeSort {

	public static void main(String args[]) {
		int[] arr = {20,10,80,60,40,50,30,70};
		int start = 0;
		int end = arr.length-1;
		sort(arr, start, end);
		printArray(arr);
	}

	private static void printArray(int[] arr) {
		// TODO Auto-generated method stub
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private static void sort(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if (start < end) {
			int mid = (start+end)/2;
			sort(arr, start, mid);
			sort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
	}

	private static void merge(int[] arr, int start, int mid, int end) {
		// TODO Auto-generated method stub
		int n1 = mid - start + 1;
		int n2 = end - mid;
		int[] temp1 = new int[n1];
		int[] temp2 = new int[n2];
		int midIndex = mid + 1;
		
		for(int i=0; i < n1 ; i++) {
			temp1[i] = arr[start + i];
		}
		
		for(int i=0; i<n2; i++) {
			temp2[i] = arr[midIndex + i];
		}
		
		int i=0, j=0, k=start;
		while(i<n1 && j<n2) {
			if(temp1[i] < temp2[j]) {
				arr[k++] = temp1[i++];
			} else {
				arr[k++] = temp2[j++];
			}
		}
		while(i<n1) {
			arr[k++] = temp1[i++];
		}
		while(j<n2) {
			arr[k++] = temp2[j++];
		}
	}
}
