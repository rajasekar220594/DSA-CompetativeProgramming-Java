package com.dsa.tree.easy;

import com.dsa.tree.util.BinaryTree;
import com.dsa.tree.util.Node;

public class _13LowestCommonAncestorBST {

	public static void main(String[] args) {
		int arr[]   = {20,7,21,3,11,-1,-1, -1,-1,9,13};
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(arr);
		//System.out.println(recursiveLCA(tree.root, 3, 21).data);
		System.out.println(iterativeLCA(tree.root, 3, 21).data);
	}
	
	public static Node recursiveLCA(Node root, int p, int q) {
		if(root != null) {
			if(p < root.data && q < root.data) {
				return recursiveLCA(root.left, p, q);
			}
			if(p > root.data && q > root.data) {
				return recursiveLCA(root.right, p, q);
			}
		}
		return root;
	}
	public static Node iterativeLCA(Node root, int p, int q) {
		while(root != null) {
			if(p < root.data && q < root.data) {
				root = root.left;
			} else if(p > root.data && q > root.data) {
				root = root.right;
			} else {
				break;
			}
		}
		return root;
	}
}
