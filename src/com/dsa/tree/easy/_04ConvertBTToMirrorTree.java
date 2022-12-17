package com.dsa.tree.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.dsa.tree.util.BinaryTree;
import com.dsa.tree.util.Node;

public class _04ConvertBTToMirrorTree {

	public static void main(String[] args) {
		int arr[]   = {1, 2, 3, 4, 5, 6, 7};
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(arr);
		tree.levelOrder(tree.root);
		System.out.println();
		convertBTToMirrorTree(tree.root);
		tree.levelOrder(tree.root);
		convertBTToMirrorTreeIterative(tree.root);
		System.out.println();
		tree.levelOrder(tree.root);
	}
	
	public static Node convertBTToMirrorTree(Node root) {
		if(root != null) {
			Node left = convertBTToMirrorTree(root.left);
			Node right = convertBTToMirrorTree(root.right);
			root.left = right;
			root.right = left;
		}
		return root;
	}
	public static Node convertBTToMirrorTreeIterative(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		while(!q.isEmpty()) {
			Node temp = q.poll();
			if(temp.left != null) q.offer(temp.left);
			if(temp.right != null) q.offer(temp.right);
			
			Node left = temp.left;
			Node right = temp.right;
			temp.left = right;
			temp.right = left;
			
		}
		return root;
	}
}
