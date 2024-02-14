package com.dsa.tree.traversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dsa.tree.util.BinaryTree;
import com.dsa.tree.util.Node;

public class _11LeftViewOfBinaryTree {

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
        
        List<Integer> list = new ArrayList<Integer>();
        leftViewOfBinaryTreeRecursion(tree.root, 0, list);
        System.out.println(list);

	}
	
	public static void leftViewOfBinaryTreeRecursion(Node root, int level, List<Integer> result) {
		if(root == null) return;
		
		if(level == result.size()) result.add(root.data);
		leftViewOfBinaryTreeRecursion(root.left, level+1, result);
		leftViewOfBinaryTreeRecursion(root.right, level+1, result);
	}

}
