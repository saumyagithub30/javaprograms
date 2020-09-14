package com.sap;

public class LinkedList {
	
	Node head;
	
	public static class Node {
		int data;
		Node next;
		Node(int d) {
			this.data = d;
			this.next = null;
		}
	}
	
	void insertAtFront (int data) {
		Node  newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	void insertAtEnd (int data) {
		Node newNode = new Node(data);
		Node temp = head;
		Node prev = head;
		while(temp != null) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = newNode;
	}
	
	void search (int data) {
		if (head == null) {
			return;
		}
		Node temp = head;
		while (temp != null) {
			if (temp.data == data) {
				System.out.println("Node is found");
				return;
			}
			temp = temp.next;
		}
	}
	
	void remove (int data) {
		if (head == null) {
			System.out.println("Linked List is empty");
			return;
		}
		Node temp = head;
		Node prev = null;
		
		if (temp.data == data) {
			head = temp.next;
			return;
		}
		
		while (temp.next != null) {
			prev = temp;
			temp = temp.next;
			if(temp.data == data) {
				prev.next = temp.next;
				temp = prev;
			}
		}
	}
	
	void printList() {
		Node temp = head;
		System.out.println("LinkList is as below");
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList Llist = new LinkedList();
		Llist.insertAtFront(1);
		Llist.insertAtFront(2);
		Llist.insertAtFront(3);
		Llist.insertAtFront(4);
		Llist.insertAtFront(5);
		Llist.insertAtEnd(6);
//		Llist.printList();
//		Llist.search(3);
//		Llist.remove(5);
//		Llist.remove(6);
		Llist.printList();
		Llist.reverse();
		Llist.printList();
	}

	private void reverse() {
		// TODO Auto-generated method stub
		head = reverseLinkList(head);
	}

	private Node reverseLinkList(Node node) {
		// TODO Auto-generated method stub
		if(node == null) {
			return null;
		}
		Node curr = node;
		Node prev = null;
		Node next = null;
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}	
		node = prev;
		return node;
	}

}
