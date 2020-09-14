package com.sap;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {10, 80, 40, 20, 60, 90};
		InsertionSort is = new InsertionSort();
		is.sort(arr);
		is.printArray(arr);
	}

	private void sort(int[] arr) {
		// TODO Auto-generated method stub
		int n = arr.length;
		for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
	}

	private void printArray(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i<=arr.length-1; i++) {
			System.out.println(arr[i]);
		}
	}
}
