package linkedlist.problems;

import java.util.Scanner;

public class CircularLinkedList {

	public static void main(String[] args) {
		int n;
		String item;
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no. of nodes");
		n = sc.nextInt();
		System.out.println("Enter 0th nodes");
		item = sc.nextLine();
		SinglyNode newnode = new SinglyNode(item);
		SinglyNode head, pointer;
		head = newnode;
		pointer = newnode;
		
		for (int i=1; i<n ; i++) {
			System.out.print("Enter next node");
			item = sc.nextLine();
			newnode = new SinglyNode(item);
			pointer.next = newnode;
			pointer = pointer.next;
			newnode.next = head;
		}
		
		for (int i=0 ; i<n ; i++) {
			System.out.print(head.data);
			head = head.next;
		}
	}

}
