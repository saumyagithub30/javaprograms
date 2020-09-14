package com.sap;

class Node 
{ 
    int key; 
    Node left, right; 
  
    public Node(int item) 
    { 
        key = item; 
        left = right = null; 
    } 
} 

public class BSTTraversals {

	 Node root; 
	  
	 BSTTraversals() 
	    { 
	        root = null; 
	    } 
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTTraversals tree = new BSTTraversals(); 
	        tree.root = new Node(10); 
	        tree.root.left = new Node(8); 
	        tree.root.right = new Node(12); 
	        tree.root.left.left = new Node(4); 
	        tree.root.left.right = new Node(5); 
	  
	        System.out.println("Preorder traversal of binary tree is "); 
	        tree.printPreorder(); 
	  
	        System.out.println("\nInorder traversal of binary tree is "); 
	        tree.printInorder(); 
	  
	        System.out.println("\nPostorder traversal of binary tree is "); 
	        tree.printPostorder(); 
	}
	
	 // Wrappers over above recursive functions 
    void printPostorder()  {     printPostorder(root);  } 
    void printInorder()    {     printInorder(root);   } 
    void printPreorder()   {     printPreorder(root);  } 

	/* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        /* first print data of node */
        System.out.print(node.key + " "); 
  
        /* then recur on left sutree */
        printPreorder(node.left); 
  
        /* now recur on right subtree */
        printPreorder(node.right); 
    } 

    void printPostorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        // first recur on left subtree 
        printPostorder(node.left); 
  
        // then recur on right subtree 
        printPostorder(node.right); 
  
        // now deal with the node 
        System.out.print(node.key + " "); 
    } 
  
    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        /* first recur on left child */
        printInorder(node.left); 
  
        /* then print the data of node */
        System.out.print(node.key + " "); 
  
        /* now recur on right child */
        printInorder(node.right); 
    } 
}
