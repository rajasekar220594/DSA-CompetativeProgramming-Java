package com.dsa.tree.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.dsa.array.util.ArraysUtil;
import com.dsa.tree.util.BinaryTree;
import com.dsa.tree.util.Node;

public class _13LowestCommonAncestorBT {

	
	public static void main(String[] args) {
		int arr[]   = {1,2,3,4,5,7,8,9,10,11,12,-1,-1,13,14};
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(arr);
		System.out.println(lowestCommonAncestorBTRecursion1(tree.root, 2, 12));
		System.out.println(lowestCommonAncestorBTRecursion3(tree.root, 2, 12));
	}
	
	// Best approach TC -> O(n)
	public static Integer lowestCommonAncestorBTRecursion1(Node root, int p, int q) {
		if(root == null) return null;
		if(root.data == p) return p;
		if(root.data == q) return q;
		Integer left = lowestCommonAncestorBTRecursion1(root.left, p, q);
		Integer right = lowestCommonAncestorBTRecursion1(root.right, p, q);
		if(left == null) {
			return right;
		} else if(right == null) {
			return left;
		} else {
			return root.data;
		}
	}
	
	// Best approach TC -> O(n)
	public static Node lowestCommonAncestorBTRecursion2(Node root, Node p, Node q) {
		if(root == null) return null;
		if(root == p || root == q) return root;

		Node left = lowestCommonAncestorBTRecursion2(root.left, p, q);
		Node right = lowestCommonAncestorBTRecursion2(root.right, p, q);
		if(left == null) {
			return right;
		} else if(right == null) {
			return left;
		} else {
			return root;
		}
	}
		
	// Brute force approach TC -> O(n) * O(n)
	public static Integer lowestCommonAncestorBTRecursion3(Node root, int p, int q) {
		
		List<Integer> left = new ArrayList<Integer>(), right = new ArrayList<Integer>();
		_11PrintRootToNodePath.printRootToNodePathRecursion2(root, p, left);
		_11PrintRootToNodePath.printRootToNodePathRecursion2(root, q, right);
		
		int lowestCommonAncestor = left.get(0); 
		for(int i=1; i<left.size() && i<right.size(); i++) {
			if(left.get(i) != right.get(i)) break;
			lowestCommonAncestor= left.get(i);
		}
		
		return lowestCommonAncestor;
		
	}

}
