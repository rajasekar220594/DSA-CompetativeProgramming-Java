package com.dsa.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


import com.dsa.tree.util.BinaryTree;
import com.dsa.tree.util.Node;

public class _01PreOrderTraversal {
	// Root Left Right
	static List<Integer> preOrder = new ArrayList<Integer>();
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(new int[] { 1, 2, 7, 3, 4, -1, -1, -1, -1, 5, 6 });
		
		preOrderTraversalRecursion(tree.root);
		System.out.println(preOrder);
		
		System.out.println(preOrderTraversalIteration(tree.root));
	}
	
	public static void preOrderTraversalRecursion(Node root) {
		if(root == null) return;
		preOrder.add(root.data);
		preOrderTraversalRecursion(root.left);
		preOrderTraversalRecursion(root.right);
	}
	
	public static List<Integer> preOrderTraversalIteration(Node root) {
		List<Integer> preOrder = new ArrayList<Integer>();
		Stack<Node> stack = new Stack<Node>();
		while(root != null || !stack.isEmpty()) {
			if(root != null) {
				preOrder.add(root.data);
				stack.push(root);
				root = root.left;
			} else {
				root=stack.pop();
				root=root.right;
			}
		}
		return preOrder;
	}

}
