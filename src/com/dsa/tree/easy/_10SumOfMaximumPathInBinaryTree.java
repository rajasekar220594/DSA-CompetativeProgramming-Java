package com.dsa.tree.easy;

import com.dsa.tree.util.BinaryTree;
import com.dsa.tree.util.Node;

public class _10SumOfMaximumPathInBinaryTree {

	public static void main(String[] args) {
		BinaryTree tree1 = new BinaryTree();
		tree1.createBinaryTree(new int[] {10, -9, 20, -1, -1, 15, 7});
		
		int arr[] = new int[1];
		sumOfMaximumPathInBinaryTree1(tree1.root, arr);
		System.out.println(arr[0]);
		
	}
	
	public static int sumOfMaximumPathInBinaryTree1(Node root, int[] maximum) {
		if(root == null) return 0;
		
		int leftSum = Math.max(0, sumOfMaximumPathInBinaryTree1(root.left, maximum));
		int rightSum = Math.max(0, sumOfMaximumPathInBinaryTree1(root.right, maximum));
		
		maximum[0] = Math.max(maximum[0], leftSum+rightSum+root.data);
		
		return root.data+Math.max(leftSum, rightSum);
	}
}
