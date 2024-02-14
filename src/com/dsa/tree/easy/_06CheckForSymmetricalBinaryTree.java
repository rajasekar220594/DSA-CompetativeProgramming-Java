package com.dsa.tree.easy;

import com.dsa.tree.util.BinaryTree;
import com.dsa.tree.util.Node;

public class _06CheckForSymmetricalBinaryTree {

	public static void main(String[] args) {
		int arr[]   = {1, 2, 2, 3, 4, 4, 3};
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(arr);
		System.out.println(isSymmetricalBinaryTree(tree.root, tree.root));

	}
	
	public static boolean isSymmetricalBinaryTree(Node leftNode, Node rightNode) {
		if(leftNode == null || rightNode == null) return leftNode == rightNode;
		if(leftNode.data != rightNode.data) return false;
		return isSymmetricalBinaryTree(leftNode.left, rightNode.right) && isSymmetricalBinaryTree(leftNode.right, rightNode.left);
	}

}
