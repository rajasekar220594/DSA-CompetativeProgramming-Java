package com.dsa.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.dsa.tree.util.BinaryTree;
import com.dsa.tree.util.Node;

public class _02InOrderTraversal {
	// Left Root Right
	static List<Integer> inOrder = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(new int[] { 1, 2, 7, 3, 4, -1, -1, -1, -1, 5, 6 });
		
		inOrderTraversalRecursion(tree.root);
		System.out.println(inOrder);
		System.out.println(inOrderTraversalIteration(tree.root));

	}
	
	public static void inOrderTraversalRecursion(Node root) {
		if(root == null) return;
		inOrderTraversalRecursion(root.left);
		inOrder.add(root.data);
		inOrderTraversalRecursion(root.right);
	}
	
	public static List<Integer> inOrderTraversalIteration(Node root) {
		List<Integer> inOrder = new ArrayList<Integer>();
		Stack<Node> stack = new Stack<Node>();
		while(root != null || !stack.isEmpty()) {
			if(root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				inOrder.add(root.data);
				root = root.right;
			}
		}
		return inOrder;
	}
	
}
