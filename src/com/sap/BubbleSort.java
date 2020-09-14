package com.sap;

class BubbleSort {
	
	public static void main(String args[]) {
		
		int arr [] = {10, 80, 40, 20, 60, 90};
		BubbleSort bs = new BubbleSort();
		bs.sort(arr);
		bs.printArray(arr);
	}

	private void printArray(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i<=arr.length-1; i++) {
			System.out.println(arr[i]);
		}
	}

	private void sort(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if (arr[j] > arr[j+1]  ) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}