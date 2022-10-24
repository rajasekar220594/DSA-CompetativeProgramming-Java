package com.dsa.tree.util;

public class BinarySearchTree {
	
	private Node root;
	
	public Node recursiveBinarySearch(Node node, int key) {
		if(node == null) return null;
		if(key == node.data) {
			return node;
		} else if(key < node.data) {
			return recursiveBinarySearch(node.left, key);
		} else {
			return recursiveBinarySearch(node.right, key);
		}
	}
	
	public Node iterativeBinarySearch(Node node, int key) {
		while(node != null) {
			if(node.data == key) {
				return node;
			} else if(key < node.data) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return null;
	}
	
	public void createBinarySearchTree(int arr[]) {
		root = new Node(arr[0]);
		Node current, previous;
		for(int i=1; i<arr.length; i++) {
			current = root;
			previous = null;
			while(current != null) {
				previous = current;
				if(current.data == arr[i]) {
					break;
				} else if(arr[i] < current.data) {
					current = current.left;
				} else {
					current = current.right;
				}
			}
			Node newNode = new Node(arr[i]);
			if(current == null && arr[i] < previous.data) {
				previous.left = newNode;
			} else {
				previous.right = newNode;
			}
		}
	}
	
	public Node insertBinarySearchTree(int value) {
		if(root == null) {
			root = new Node(value);
			return root;
		}
		Node current = root, previous = null;
		while(current != null) {
			previous = current;
			if(current.data == value) {
				return current;
			} else if(value < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		
		Node newNode = new Node(value);
		if(current == null && value < previous.data) {
			previous.left = newNode;
		} else {
			previous.right = newNode;
		}
		return newNode;
	}
	
	public Node insertRecursiveBST(Node currentNode, int value) {
		Node newNode = null;
		if(currentNode == null) {
			newNode = new Node(value);
			return newNode;
		}
		if(value < currentNode.data) {
			currentNode.left = insertRecursiveBST(currentNode.left, value);
		} else if(value > currentNode.data) {
			currentNode.right = insertRecursiveBST(currentNode.right, value);
		}
		return currentNode;
	}
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		int arr[] = {30,20,40,10,25,35,50};
		
		tree.createBinarySearchTree(arr);
		
		BinaryTree.iterativeInOrder(tree.root);
		Node n = tree.recursiveBinarySearch(tree.root, 21);
		System.out.println(n);
	}
	
}
