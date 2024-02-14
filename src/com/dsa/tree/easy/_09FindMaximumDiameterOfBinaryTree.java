package com.dsa.tree.easy;

import com.dsa.tree.util.BinaryTree;
import com.dsa.tree.util.Node;

public class _09FindMaximumDiameterOfBinaryTree {

	static int maximum=0;
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32 });
		
		BinaryTree tree1 = new BinaryTree();
		tree1.createBinaryTree(new int[] {1, 2, -1, 4, -1, 6});
		
		maximum=0;
		findMaximumDiameterOfBinaryTree1(tree.root);
		System.out.println(maximum);
		
		maximum=0;
		findMaximumDiameterOfBinaryTree1(tree1.root);
		System.out.println(maximum);
		
		int arr[] = new int[1];
		findMaximumDiameterOfBinaryTree2(tree.root, arr);
		System.out.println(arr[0]);
		
		arr[0] = 0;
		findMaximumDiameterOfBinaryTree2(tree1.root, arr);
		System.out.println(arr[0]);
		
	}
	
	public static int height(Node root) {
		if(root == null) return 0;
		int left = height(root.left);
		int right = height(root.right);
		return 1+Math.max(left, right);
	}
	// T.c -> O(n*n)
	public static void findMaximumDiameterOfBinaryTree1(Node root) {
		if(root == null) return;
		int left = height(root.left);
		int right = height(root.right);
		
		maximum = Math.max(maximum, left+right);
		findMaximumDiameterOfBinaryTree1(root.left);
		findMaximumDiameterOfBinaryTree1(root.right);
	}
	
	// T.c -> O(n)
	public static int findMaximumDiameterOfBinaryTree2(Node root, int[] maximum) {
		if(root == null) return 0;
		int left = height(root.left);
		int right = height(root.right);
		
		maximum[0] = Math.max(maximum[0], left+right);
		
		return 1+Math.max(left, right);
	}
 
}
