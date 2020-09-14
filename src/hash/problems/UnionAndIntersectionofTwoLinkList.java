package hash.problems;

import java.util.HashMap;
import java.util.HashSet;

public class UnionAndIntersectionofTwoLinkList {

	Node head;
	
	static class Node {
		int data;
		Node next;
		Node (int d) {
			this.data = d;
			this.next = null;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnionAndIntersectionofTwoLinkList list1 = new UnionAndIntersectionofTwoLinkList();
		UnionAndIntersectionofTwoLinkList list2 = new UnionAndIntersectionofTwoLinkList();
		UnionAndIntersectionofTwoLinkList unin = new UnionAndIntersectionofTwoLinkList(); 
		UnionAndIntersectionofTwoLinkList intersecn = new UnionAndIntersectionofTwoLinkList(); 
		list1.insertAtFront(10);
		list1.insertAtFront(20);
		list1.insertAtFront(30);
		list2.insertAtFront(30);
		list2.insertAtFront(40);
		list2.insertAtFront(50);
		System.out.println("LinkList 1 is as below");
		list1.printList();
		System.out.println("LinkList 2 is as below");
		list2.printList();
		System.out.println("Intersection of Two LinkList is as below");
		intersecn.getIntersection(list1.head, list2.head);
		System.out.println("Union of Two LinkList is as below");
		unin.getUnion(list1.head, list2.head);
		System.out.println("\n" + "Intersection of Two LinkList Using Hashing is as below");
		intersecn.getInterSectionUsingHashing(list1.head, list2.head);
		System.out.println("Union of Two LinkList Using Hashing is as below");
		unin.getUnionUsingHashing(list1.head, list2.head);
	}

	private void getUnionUsingHashing(Node head1, Node head2) {
		// TODO Auto-generated method stub
		    HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		    Node temp1 = head1;
		    Node temp2 = head2;
		    
		    while(temp1 != null) {
		    	if(hmap.containsKey(temp1.data)) {
		    		int value = hmap.get(temp1.data);
		    		hmap.put(temp1.data, value+1);
		    	} else {
		    		hmap.put(temp1.data, 1);
		    	}
		    	temp1 = temp1.next;
		    }
		    
		    while(temp2 != null) {
		    	if(hmap.containsKey(temp2.data)) {
		    		int value = hmap.get(temp2.data);
		    		hmap.put(temp2.data, value + 1);
		    	} else {
		    		hmap.put(temp2.data, 1);
		     	}
		    	temp2 = temp2.next;
		    }
		    
		    for(Integer x: hmap.keySet()) {
		    	System.out.print(x + " ");
		    }
	}

	private void getInterSectionUsingHashing(Node head1, Node head2) {
		// TODO Auto-generated method stub
	    
	    HashSet<Integer> hset = new HashSet<Integer>();
	    Node temp1 = head1;
	    Node temp2 = head2;
	    
	    while (temp1 != null) {
	    	hset.add(temp1.data);
	    	temp1 = temp1.next;
	    }
	    
	    while(temp2 !=null) {
	    	if(hset.contains(temp2.data)) {
	    		System.out.println(temp2.data + " ");
	    	}
	    	temp2 = temp2.next;
	    }
	}

	private void getUnion(Node head1, Node head2) {
		// TODO Auto-generated method stub
		Node temp1 = head1;
		Node temp2 = head2;
		while(temp1!=null) {
			System.out.print(temp1.data + " ");
			temp1 = temp1.next;
		}
		while(temp2!=null) {
			Boolean isPresent = isPresent(temp2.data, head1);
			if(!isPresent) {
				System.out.print(temp2.data + " ");
			}
			temp2=temp2.next;
		}
	}

	private Boolean isPresent(int data, Node head1) {
		// TODO Auto-generated method stub
		Node temp1 = head1;
		while(temp1!=null) {
			if(temp1.data == data) {
				return true;
			}
			temp1 = temp1.next;
		}
		return false;
	}

	private void getIntersection(Node head1, Node head2) {
		// TODO Auto-generated method stub
		Node temp1 = head1;
		Node temp2 = head2;
		while (temp2!=null && temp1!=null) {
			if (temp1.data == temp2.data) {
				System.out.println(temp1.data);
			}
			temp2 = temp2.next;
			if(temp2==null && temp1.next!=null) {
				temp1 = temp1.next;
				temp2 = head2;
			}
		}
	}

	void printList() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	private void insertAtFront(int data) {
		// TODO Auto-generated method stub
		Node  newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}


}
