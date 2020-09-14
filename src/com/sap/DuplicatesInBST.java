package com.sap;

public class DuplicatesInBST {

	static class node {
		int key;
		int count;
		node left, right;
	}
	
	static node newNode(int item) {
		node temp = new node();
		temp.key = item;
		temp.left = temp.right = null;
		temp.count = 1;
		return temp;
	}
	
	static node insert(node node, int key) {
		if (node == null) {
			return newNode(key);
		}
		
		if (key == node.key) {
			(node.count)++;
			return node;
		}
		
		if(key < node.key) {
			node.left = insert(node.left, key);
		} else {
			node.right = insert(node.right, key);
		}
		return node;
	}
	
	static void inorder(node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.key + "(" + root.count + ")");
			inorder(root.right);
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root = null;
		root = insert(root, 12);
		root = insert(root, 10);
		root = insert(root, 20);
		root = insert(root, 9);
		root = insert(root, 11);
		root = insert(root, 10);
		root = insert(root, 12);
		root = insert(root, 12);
		root = insert(root, 9);
		
		System.out.print("Inorder traversal of the given tree" + "\n");
		inorder(root);
		
		System.out.print("\nDelete 20\n");
		root = deleteNode(root, 20);
		
		System.out.print("Inorder traversal of the given tree" + "\n");
		inorder(root);
	}

	private static node deleteNode(node root, int key) {
		// TODO Auto-generated method stub
		if(root == null) {
			return root;
		}
		if (key < root.key) {
			root.left = deleteNode(root.left, key);
		}
		else if (key > root.key) {
			root.right = deleteNode(root.right, key);
		}
		else {
			if (root.count > 1) {
				(root.count)--;
				return root;
			}
			if (root.left == null) {
				node temp = root.right;
				root = null;
				return temp;
			}
			if (root.right == null) {
				node temp = root.left;
				root = null;
				return temp;
			}
			
			node temp = minValueNode(root.right);
			root.key = temp.key;
			root.right = deleteNode(root.right, temp.key);
		}
		return root;
	}

	private static node minValueNode(node node) {
		// TODO Auto-generated method stub
		node current = node;
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

}
