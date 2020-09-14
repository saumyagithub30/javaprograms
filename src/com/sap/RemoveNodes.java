package com.sap;

public class RemoveNodes {
	
	Node head;
	
	class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	void insertNode(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	private void removeNodes(int x) {
		// TODO Auto-generated method stub
		Node temp = head;
		if (head == null) {
			return;
		}
		Node prev = head;
		while(temp != null) {
			if (temp.data == x && temp == head) {
				head = temp.next;
				temp = head;
			} else if (temp.data == x) {
				prev.next = temp.next;
				temp = temp.next;
			} else {
				prev = temp;
				temp = temp.next;
			}
		}
	}
	
	void printList() {
		Node temp = head;
		System.out.println("LinkList is as below");
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveNodes rn = new RemoveNodes();
		rn.insertNode(3);
		rn.insertNode(5);
		rn.insertNode(5);
		rn.insertNode(2);
		rn.insertNode(1);
		
		// To Remove all the nodes in linked list that has value 10
		rn.printList();
		
		rn.removeNodes(5);
		rn.printList();
		
	}



}
