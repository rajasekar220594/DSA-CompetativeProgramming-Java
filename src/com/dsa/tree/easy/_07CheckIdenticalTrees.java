package com.dsa.tree.easy;

import com.dsa.tree.util.BinaryTree;
import com.dsa.tree.util.Node;

public class _07CheckIdenticalTrees {

	public static void main(String[] args) {
		BinaryTree binaryTree1 = new BinaryTree();
		binaryTree1.createBinaryTree(new int[] {1,2,3,4,5});
		
		BinaryTree binaryTree2 = new BinaryTree();
		binaryTree2.createBinaryTree(new int[] {1,4,3,4,7});
		
		System.out.println(isIdentical(binaryTree1.root, binaryTree2.root));
	}
	
	public static boolean isIdentical(Node root1, Node root2) {
		if(root1 == null && root2 == null) return true;
		if(root1 != null && root2 != null) {
			/*
			 if(root1.data != root2.data) return false;
			 */
			return (root1.data == root2.data) && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
		}
		return false;
	}

}
