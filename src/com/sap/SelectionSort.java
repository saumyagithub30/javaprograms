package com.sap;

class SelectionSort {
	
	public static void main(String args[]) {
		int arr[] = {10, 50, 30, 40, 60, 80};
		SelectionSort ss = new SelectionSort();
		ss.sort(arr);
		ss.printArray(arr);
	}

	private void printArray(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i <= arr.length-1; i++) {
			System.out.println(arr[i]);
		}
	}

	private void sort(int[] arr) {
		// TODO Auto-generated method stub
		for (int i=0; i < arr.length-1; i++) {
			int minIndex = i;
			for (int j=i+1; j<arr.length-1; j++) {
				if(arr[j] < arr[minIndex]) {
					int temp = arr[j];
					arr[j] = arr[minIndex];
					arr[minIndex] = temp;
					minIndex = j;
				}
			}
		}
	}
}