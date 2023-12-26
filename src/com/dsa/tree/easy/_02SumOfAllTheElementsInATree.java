package com.dsa.tree.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.dsa.tree.util.BinaryTree;
import com.dsa.tree.util.Node;

public class _02SumOfAllTheElementsInATree {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(new int[] {1, 2, 3, 4, 5, 6, 7, 8, -1, 9, -1, -1, 10, -1, 11});
		
		System.out.println("***Sum of all the elements in a tree***");
		System.out.println(sumOfAllTheElementsInATreeRecursion(tree.root));
		System.out.println(sumOfAllTheElementsInATreeIterative(tree.root));
	}
	
	public static int sumOfAllTheElementsInATreeRecursion(Node root) {
		if(root != null) {
			int x=sumOfAllTheElementsInATreeRecursion(root.left);
			int y=sumOfAllTheElementsInATreeRecursion(root.right);
			return x+y+root.data;
		}
		return 0;
	}

	public static int sumOfAllTheElementsInATreeIterative(Node root) {		
		Queue<Node> queue = new LinkedList<Node>();
		int count=0;
		queue.offer(root);
 		while(!queue.isEmpty()) {
 			root = queue.poll();
 			count+=root.data;
 			if(root.left != null) queue.offer(root.left);
 			if(root.right != null) queue.offer(root.right);
		}
		return count;
	}
	
}
