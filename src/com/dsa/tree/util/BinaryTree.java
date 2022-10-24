package com.dsa.tree.util;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class BinaryTree {
	
	private Node root;
	
	public void createBinaryTree(int arr[]) {
		root = new Node(arr[0]);
		Deque<Node> queue = new LinkedList<>();
		queue.offer(root);
		Node pointer, temp;
		int i = 1;
		while(queue != null && i < arr.length) {
			pointer = queue.poll();
			if(i < arr.length  && arr[i] != -1) {
				temp = new Node(arr[i++]);
				pointer.left = temp;
				queue.offer(temp);
			} else {
				i++;
			}
			if(i < arr.length  && arr[i] != -1) {
				temp = new Node(arr[i++]);
				pointer.right = temp;
				queue.offer(temp);
			} else {
				i++;
			}
		}
	}
	
	public static void preOrder(Node node) {
		if(node != null) {
			System.out.print(node.data + " - " + node.height +" ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public static void iterativePreOrder(Node temp) {
		Stack<Node> stack = new Stack<>();
		while(temp != null || !stack.isEmpty()) {
			if(temp != null) {
				System.out.print(temp.data + " ");
				stack.push(temp);
				temp = temp.left;
			} else {
				temp = stack.pop();
				temp = temp.right;
			}
		}
	}
	public static void inOrder(Node node) {
		if(node != null) {
			inOrder(node.left);
			System.out.print(node.data + " ");
			inOrder(node.right);
		}
	}
	public static void iterativeInOrder(Node temp) {
		Stack<Node> stack = new Stack<>();
		while(temp != null || !stack.isEmpty()) {
			if(temp != null) {
				stack.push(temp);
				temp = temp.left;
			} else {
				temp = stack.pop();
				System.out.print(temp.data + " ");
				temp = temp.right; 
			}
		}
	}
	public static void postOrder(Node node) {
		if(node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data + " ");
		}
	}
	public static void iterativePostOrder(Node temp) {
		Stack<Node> stack = new Stack<>();
		int t;
		while(temp != null || !stack.isEmpty()) {
			if(temp != null) {
				stack.push(temp);
				temp = temp.left;
			} else {
				Node previousNode = stack.peek().right;
				if (previousNode == null) {
					previousNode = stack.pop();
					System.out.print(previousNode.data + " ");
					while (!stack.isEmpty() && previousNode == stack.peek().right) {
						previousNode = stack.pop();
						System.out.print(previousNode.data + " ");
					}
				} 
				else {
					temp = previousNode;
				}
			}
		}
	}
	public static void levelOrder(Node temp) {
		Deque<Node> queue = new LinkedList<>();
		queue.offer(temp);
		while(!queue.isEmpty()) {
			temp = queue.poll();
			if(temp != null) {
				System.out.print(temp.data+" ");
				queue.offer(temp.left);
				queue.offer(temp.right);
			}
		}
	}
	public static int count(Node node) {
		int x, y;
		if(node != null) {
			x = count(node.left);
			y = count(node.right);
			return x+y+1;
			
		}
		return 0;
	}
	public static int countOfLeftAndRightChild(Node node) {
		int x, y;
		if(node != null) {
			x = countOfLeftAndRightChild(node.left);
			y = countOfLeftAndRightChild(node.right);
			if(node.left != null && node.right != null) {
				return x+y+1;
			} else {
				return x+y;
			}			
		}
		return 0;
	}
	
	public static void main(String[] args) {
		
		/*System.out.println("Level Order");
		tree.levelOrder(tree.root);
		System.out.println();
		System.out.println("Preorder");
		tree.preOrder(tree.root);
		System.out.println();
		System.out.println("Iterative Preorder");
		tree.iterativePreOrder(tree.root);
		System.out.println();
		
		System.out.println("Inorder");
		tree.inOrder(tree.root);
		System.out.println();
		System.out.println("Iterative Inorder");
		tree.iterativeInOrder(tree.root);
		System.out.println();
		
		System.out.println("Postorder");
		tree.postOrder(tree.root);
		System.out.println();
		System.out.println("Iterative Postorder");
		tree.iterativePostOrder(tree.root);
		System.out.println();*/
	}

}
