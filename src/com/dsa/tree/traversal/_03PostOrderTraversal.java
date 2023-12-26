package com.dsa.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.dsa.tree.util.BinaryTree;
import com.dsa.tree.util.Node;

public class _03PostOrderTraversal {

	// Left Right Root
	static List<Integer> postOrder = new ArrayList<Integer>();
		
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(new int[] { 1, 2, 7, 3, 4, -1, -1, -1, -1, 5, 6 });
		postOrderTraversalRecursion(tree.root);
		System.out.println(postOrder);
		System.out.println(postOrderTraversalIteration1(tree.root));
		System.out.println(postOrderTraversalIteration2(tree.root));
	}
	
	public static void postOrderTraversalRecursion(Node root) {
		if(root == null) return;
		postOrderTraversalRecursion(root.left);
		postOrderTraversalRecursion(root.right);
		postOrder.add(root.data);
	}
	
	// Using 2 stacks
	public static List<Integer> postOrderTraversalIteration1(Node root) {
		List<Integer> postOrder = new ArrayList<Integer>();
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		
		stack1.push(root);
		while(!stack1.isEmpty()) {
			root = stack1.pop();
			stack2.push(root);
			if(root.left != null) {
				stack1.push(root.left);
			}
			if(root.right != null) {
				stack1.push(root.right);
			}
		}
		while(!stack2.isEmpty()) {
			postOrder.add(stack2.pop().data);
		}
		return postOrder;
	}
	
	// Using 1 stack and changing the memory value to negative
	// T -> O(2n)
	public static List<Integer> postOrderTraversalIteration2(Node root) {
		List<Integer> postOrder = new ArrayList<Integer>();
		Stack<Node> stack = new Stack<Node>();
		while(root != null || !stack.isEmpty()) {
			if(root != null) {
				stack.push(root);
				root = root.left;
			} else {
				Node previousNode = stack.peek().right;
				if (previousNode == null) {
					previousNode = stack.pop();
					postOrder.add(previousNode.data);
					while (!stack.isEmpty() && previousNode == stack.peek().right) {
						previousNode = stack.pop();
						postOrder.add(previousNode.data);
					}
				} 
				else {
					root = previousNode;
				}
			}
		}
		return postOrder;
	}

}
