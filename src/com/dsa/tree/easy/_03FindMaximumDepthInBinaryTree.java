package com.dsa.tree.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.dsa.tree.util.BinaryTree;
import com.dsa.tree.util.Node;

public class _03FindMaximumDepthInBinaryTree {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32 });
		
		System.out.println("***Find maximum depth in a binary tree***");
		System.out.println(maximumDepthRecursion(tree.root));
		System.out.println(maximumDepthIterative(tree.root));
	}
	
	public static int maximumDepthRecursion(Node root) {
		if(root == null) return 0;
		
		int left = maximumDepthRecursion(root.left);
		int right = maximumDepthRecursion(root.right);
		return 1+ Math.max(left, right);
	}

	public static int maximumDepthIterative(Node root) {
		int count = 0;
		
		if(root == null) return count;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			count++;
			for(int i=0; i<size; i++) {
				root = queue.poll();
				if(root.left != null) queue.offer(root.left);
				if(root.right != null) queue.offer(root.right);
			}
		}
		
		return count;
	}
	
}
