package com.dsa.tree.traversal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.dsa.tree.util.Node;

public class _09BottomViewOfBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        System.out.println("Bottom view Order traversal is");
        bottomViewOfBinaryTree(root);
	}

	public static List<Integer> bottomViewOfBinaryTree(Node root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) return list;
		
		// Replace old value to new value output will be the last value
		TreeMap<Integer, Integer> mapGroups = new TreeMap<>();
		
		Queue<Tuple> queue = new LinkedList<Tuple>();
		queue.offer(new Tuple(root, 0, 0));
		while(!queue.isEmpty()) {
			Tuple tuple = queue.poll();
			Node node = tuple.node;
			int row = tuple.row, col = tuple.col;

			mapGroups.put(row, node.data);
			
			if(node.left != null) {
				queue.offer(new Tuple(node.left, row-1, col+1));
			}
			if(node.right != null) {
				queue.offer(new Tuple(node.right, row+1, col+1));
			}
		}
		
		
		System.out.println(mapGroups);
		
		list = mapGroups.values().stream().collect(Collectors.toList());
		System.out.println(list);
		return list;
	}
}
