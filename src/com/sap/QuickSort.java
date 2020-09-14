package com.sap;

public class QuickSort {
	
	public static void main(String args[]) {
		int[] arr = {10,20,80,60,40,50,30,70};
		int low = 0;
		int high = arr.length-1;
		sort(arr, low , high);
		printArray(arr);
	}

	private static void printArray(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length-1; i++) {
			System.out.println(arr[i]);
		}
	}

	private static void sort(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		if (low < high) {
			int pi = partition(arr, low, high);
			sort(arr, low, pi-1);
			sort(arr, pi+1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		int pivot = arr[high];
		int i = low -1;
		for (int j = low ; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[high];
		arr[high] = arr[i+1];
		arr[i+1]= temp;
		return i+1;
	}
}