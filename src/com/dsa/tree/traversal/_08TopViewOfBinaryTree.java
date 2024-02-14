package com.dsa.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

import com.dsa.tree.util.Node;

public class _08TopViewOfBinaryTree {
	public static void main(String[] args) {
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        System.out.println(topViewOfBinaryTree(root));
	}
	
	public static List<Integer> topViewOfBinaryTree(Node root) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		List<Integer> list = new ArrayList<Integer>();
		
		if(root == null) return list;
		
		// Only Row required Column Not required
		Queue<Tuple> queue = new LinkedList<Tuple>();
		queue.offer(new Tuple(root, 0, 0));
		
		while(!queue.isEmpty()) {
			Tuple tuple = queue.poll();
			Node node = tuple.node;
			int row = tuple.row;
			if(!map.containsKey(row)) {
				map.put(row, node.data);
			}
			if(node.left != null) {
				queue.offer(new Tuple(node.left, row-1, 0));
			}
			if(node.right != null) {
				queue.offer(new Tuple(node.right, row+1, 0));
			}
		}
		
		for(Integer i : map.values()) {
			list.add(i);
		}
		return list;
	}
}
