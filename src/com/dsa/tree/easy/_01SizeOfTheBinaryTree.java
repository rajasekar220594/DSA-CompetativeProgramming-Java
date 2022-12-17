package com.dsa.tree.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.dsa.tree.util.BinaryTree;
import com.dsa.tree.util.Node;

public class _01SizeOfTheBinaryTree {

	static int size = 0;
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree(new int[] {1,2,3,4,5,6,7,8,9,-1,-1,20});
		System.out.println(sizeUsingStack(binaryTree.root));
	}
	
	public static int sizeUsingRecursion(Node root) {
		if(root != null) {
			return 1+sizeUsingRecursion(root.left)+sizeUsingRecursion(root.right);
		}
		return 0;
	}
	
	// Pre-order traversal method
	public static int sizeUsingTraversal(Node root) {
		if(root != null) {
			size++;
			sizeUsingTraversal(root.left);
			sizeUsingTraversal(root.right);
		}
		return size;
	}
	public static int sizeUsingQueue(Node root) {
		// Using level order Traversal.
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		Node temp;
		int size=1;
		while(!q.isEmpty()) {
			temp = q.poll();
			 // when the queue is empty: the poll() method returns null.
			if(temp != null) {
				if(temp.left != null) {
					size++; // Increment count
					q.offer(temp.left); // Enqueue left child
				}
				if(temp.right != null) {
					size++; // Increment count
					q.offer(temp.right); // Enqueue right child
				}
			}
		}
		return size;
	}
	public static int sizeUsingStack(Node root) {
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		Node temp;
		int size = 1;
		while(!s.isEmpty()) {
			temp = s.pop();
			if(temp != null) {
				if(temp.left != null) {
					size++; // Increment count
					s.push(temp.left); // push left child
				}
				if(temp.right != null) {
					size++; // Increment count
					s.push(temp.right); // push right child
				}
			}
		}
		return size;
	}
}
