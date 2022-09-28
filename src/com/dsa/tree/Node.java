package com.dsa.tree;


public class Node {
	public Node left;
	public Node right;
	public int data, height;
	
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public Node(int data, boolean isAvlTree) {
		this.data = data;
		this.left = null;
		this.right = null;
		if(isAvlTree) {
			this.height = 1;
		}
	}
}
