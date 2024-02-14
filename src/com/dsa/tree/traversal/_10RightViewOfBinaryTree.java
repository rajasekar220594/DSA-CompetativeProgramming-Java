package com.dsa.tree.traversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.dsa.tree.util.BinaryTree;
import com.dsa.tree.util.Node;

public class _10RightViewOfBinaryTree {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
        rightViewOfBinaryTreeIterative1(tree.root);
        rightViewOfBinaryTreeIterative2(tree.root);
        
        Map<Integer, Integer> ans = new HashMap<>();
        rightViewOfBinaryTreeRecursion1(tree.root, 0, ans);
        System.out.println(ans);
        
        List<Integer> list = new ArrayList<Integer>();
        rightViewOfBinaryTreeRecursion2(tree.root, 0, list);
        System.out.println(list);
	}

	// Using level order approach and finding last value of the level
	public static List<Integer> rightViewOfBinaryTreeIterative1(Node root) {
		List<Integer> ans = new ArrayList<Integer>();
		if(root == null) return ans;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			int lastValue=0;
			for(int i=0; i<size; i++) {
				root = queue.poll();
				if(root != null) {
					lastValue = root.data;
					if(root.left != null) {
						queue.offer(root.left);
					}
					if(root.right != null) {
						queue.offer(root.right);
					}
				}
			}
			ans.add(lastValue);
		}
		System.out.println(ans);
		return ans;
	}
	// Using level order approach from opposite direction and finding first value of the level
	// TC-> O(n) 
	public static List<Integer> rightViewOfBinaryTreeIterative2(Node root) {
		List<Integer> ans = new ArrayList<Integer>();
		if(root == null) return ans;

		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			boolean valueInsertedAlready=false;
			for(int i=0; i<size; i++) {
				root = queue.poll();
				if(root != null) {
					if(!valueInsertedAlready) {
						ans.add(root.data);
						valueInsertedAlready = true;
					}
					if(root.right != null) {
						queue.offer(root.right);
					}
					if(root.left != null) {
						queue.offer(root.left);
					}

				}
			}
		}
		System.out.println(ans);
		return ans;
	}
	
	// Using reverse preorder traversal (Root, Right, Left)
	public static void rightViewOfBinaryTreeRecursion1(Node root, int level, Map<Integer, Integer> result) {
		if(root == null) return;
		if(!result.containsKey(level)) {
			result.put(level, root.data);
		}
		rightViewOfBinaryTreeRecursion1(root.right, level+1, result);
		rightViewOfBinaryTreeRecursion1(root.left, level+1, result);
	}
	
	public static void rightViewOfBinaryTreeRecursion2(Node root, int level, List<Integer> result) {
		if(root == null) return;
		if(level == result.size()) {
			result.add(root.data);
		}
		rightViewOfBinaryTreeRecursion2(root.right, level+1, result);
		rightViewOfBinaryTreeRecursion2(root.left, level+1, result);
	}
}
