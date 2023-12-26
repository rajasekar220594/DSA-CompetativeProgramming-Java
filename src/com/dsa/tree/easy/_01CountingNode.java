package com.dsa.tree.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.dsa.tree.util.BinaryTree;
import com.dsa.tree.util.Node;

public class _01CountingNode {

	public static void main(String[] args) {		
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(new int[] {1, 2, 3, 4, 5, 6, 7, 8, -1, 9, -1, -1, 10, -1, 11});
		
		System.out.println("***Counting Node***");
		System.out.println(countingNodeRecursion(tree.root));
		System.out.println(countingNodeIterative(tree.root));
		
		System.out.println("***Counting Node With Degree One***");
		System.out.println(countingNodeWithDegreeOneRecursion(tree.root));
		System.out.println(countingNodeWithDegreeOneIterative(tree.root)); 
		
		System.out.println("***Counting Node With Degree Two***");
		System.out.println(countingNodeWithDegreeTwoRecursion(tree.root));
		System.out.println(countingNodeWithDegreeTwoIterative(tree.root));
		 	
		System.out.println("***Counting Leaf Node***");
		System.out.println(countingLeafNodeRecursion(tree.root));
		System.out.println(countingLeafNodeIterative(tree.root));
	}
	
	public static int countingNodeRecursion(Node root) {
		int x,y;
		if(root != null) {
			x = countingNodeRecursion(root.left);
			y = countingNodeRecursion(root.right);
			return 1+x+y;
		}
		return 0;
	}
	
	public static int countingNodeIterative(Node root) {		
		Queue<Node> queue = new LinkedList<Node>();
		int count=0;
		queue.offer(root);
 		while(!queue.isEmpty()) {
 			root = queue.poll();
 			count++;
 			if(root.left != null) queue.offer(root.left);
 			if(root.right != null) queue.offer(root.right);
		}
		return count;
	}	
	
	public static int countingNodeWithDegreeOneRecursion(Node root) {
		if(root != null) {
			int x = countingNodeWithDegreeOneRecursion(root.left);
			int y = countingNodeWithDegreeOneRecursion(root.right);
			if(root.left != null ^ root.right != null) {
				return 1+x+y;
			} else {
				return x+y;
			}
		} 
		return 0;
	}

	public static int countingNodeWithDegreeOneIterative(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		int count=0;
		queue.offer(root);
		while(!queue.isEmpty()) {
 			root = queue.poll();
 			if(root.left != null) queue.offer(root.left);
 			if(root.right != null) queue.offer(root.right);
 			if(root.left != null ^ root.right != null) {
 				count++;
 			}
		}
		return count;
	}
	
	public static int countingNodeWithDegreeTwoRecursion(Node root) {
		int x,y;
		if(root != null) {
			x = countingNodeWithDegreeTwoRecursion(root.left);
			y = countingNodeWithDegreeTwoRecursion(root.right);
			if(root.left != null && root.right != null) {
				return 1+x+y;
			} else {
				return x+y;
			}
		}
		return 0;
	}
	
	public static int countingNodeWithDegreeTwoIterative(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		int count=0;
		queue.offer(root);
		while(!queue.isEmpty()) {
 			root = queue.poll();
 			if(root.left != null) queue.offer(root.left);
 			if(root.right != null) queue.offer(root.right);
 			if(root.left != null && root.right != null) {
 				count++;
 			}
		}
		return count;
	}
	
	public static int countingLeafNodeRecursion(Node root) {
		if(root != null) {
			int x = countingNodeWithDegreeOneRecursion(root.left);
			int y = countingNodeWithDegreeOneRecursion(root.right);
			if(root.left == null && root.right == null) {
				return 1+x+y;
			} else {
				return x+y;
			}
		} 
		return 0;
	}

	public static int countingLeafNodeIterative(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		int count=0;
		queue.offer(root);
		while(!queue.isEmpty()) {
 			root = queue.poll();
 			if(root.left != null) queue.offer(root.left);
 			if(root.right != null) queue.offer(root.right);
 			if(root.left == null && root.right == null) {
 				count++;
 			}
		}
		return count;
	}
}
