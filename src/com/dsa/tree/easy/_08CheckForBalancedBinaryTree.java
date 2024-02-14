package com.dsa.tree.easy;

import com.dsa.tree.util.BinaryTree;
import com.dsa.tree.util.Node;

public class _08CheckForBalancedBinaryTree {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32 });
		System.out.println(isBalancedBianryTree1(tree.root));
		System.out.println(isBalancedBianryTree2(tree.root) != -1);
		
		BinaryTree tree1 = new BinaryTree();
		tree1.createBinaryTree(new int[] {1, 2, -1, 4, -1, 6});
		System.out.println(isBalancedBianryTree1(tree1.root));
		System.out.println(isBalancedBianryTree2(tree1.root) != -1);
	}
	
	public static int height(Node root) {
		if(root == null) return 0;
		int left = height(root.left);
		int right = height(root.right);
		return 1+Math.max(left, right);
	}
	
	// T.C -> O(n*n)
	public static boolean isBalancedBianryTree1(Node root) {
		if(root == null) return true;
		
		int left = height(root.left);
		int right = height(root.right);
		
		if(Math.abs(left-right) <= 1 && isBalancedBianryTree1(root.left) 
				&& isBalancedBianryTree1(root.right)) {
			return true;
		}
		
		return false;
		
		/*
		 if(Math.abs(left-right)>1) return false;
		 boolean leftBalanced = isBalancedBianryTree1(root.left);
		 boolean rightBalanced = isBalancedBianryTree1(root.right);
		 
		 if(!left || !right) return false;
		 
		 return true;
		 */
		
	}
	
	public static int isBalancedBianryTree2(Node root) {
		if(root == null) return 0;
		
		int left = height(root.left);
		if(left == -1) return -1;
		
		int right = height(root.right);
		if(right == -1) return -1;
		
		//if(left == -1 || right == -1) return -1;
		
		if(Math.abs(left-right) > 1) return -1;
		return 1+Math.max(left, right);
	}
	
}
