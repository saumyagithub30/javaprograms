package com.sap;

import java.util.ArrayList;

public class BirthdayChoclate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BirthdayChoclate bc = new BirthdayChoclate();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(3);
		list.add(2);
		bc.printList(list);
		int count = bc.birthday(list, 3, 2);
		System.out.println();
		System.out.println("count is " + count);
	}

	private int birthday(ArrayList<Integer> list, int d, int m) {
		// TODO Auto-generated method stub
		int ways = 0; 
		int sum =0;
		for (int i =0 ; i<m ; i++) {
			sum = sum + list.get(i);
		}
		if (sum == d) {
			ways++;
		}
		 
		for(int i = 0; i < list.size()-m; i++)
	        {
	            sum = sum - list.get(i) + list.get(i+m);
	            if(sum == d) {
	            	ways++;
	            }
	        }
		 
		return ways;

	}

	private void printList(ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		for (int i=0 ; i<list.size(); i++) {
			System.out.print(" " + list.get(i) + " ");
		}
	}

}
