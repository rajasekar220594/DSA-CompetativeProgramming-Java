package com.dsa.tree.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.print.attribute.standard.PrinterResolution;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import com.dsa.tree.util.Node;

class Tuple {
	Node node;
	int row;
	int col;
	
	public Tuple(Node node, int row, int col) {
		this.node = node;
		this.row = row;
		this.col = col;
	}

	@Override
	public String toString() {
		return "Tuple [node=" + node.data + ", row=" + row + ", col=" + col + "]";
	}	
}
public class _07VerticalOrderTraversal {

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
        verticalOrderTraversal(root);
	}
	
	public static void verticalOrderTraversal(Node root) {
		
		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mapGroups = new TreeMap<>();
		
		Queue<Tuple> queue = new LinkedList<>();
		queue.offer(new Tuple(root, 0, 0));

		while(!queue.isEmpty()) {
			
			Tuple tuple = queue.poll();
			Node node = tuple.node;
			int x = tuple.row;
			int y = tuple.col;
			
			if(!mapGroups.containsKey(tuple.row)) {
				mapGroups.put(x, new TreeMap<>());
			}
			
			if(!mapGroups.get(x).containsKey(y)) {
				mapGroups.get(x).put(y, new PriorityQueue<>());
			}
			
			mapGroups.get(x).get(y).offer(node.data);
			
			if(node.left != null) {
				queue.offer(new Tuple(node.left, x-1, y+1));
			}
			if(node.right != null) {
				queue.offer(new Tuple(node.right, x+1, y+1));
			}
			
			/*
			int size = queue.size();
			for(int i=0; i<size; i++) {
				Tuple tuple = queue.poll();
				Node node = tuple.node;
				int x = tuple.row;
				int y = tuple.col;
				
				if(!mapGroups.containsKey(tuple.row)) {
					mapGroups.put(x, new TreeMap<>());
				}
				
				if(!mapGroups.get(x).containsKey(y)) {
					mapGroups.get(x).put(y, new PriorityQueue<>());
				}
				
				mapGroups.get(x).get(y).offer(node.data);
				
				if(node.left != null) {
					queue.offer(new Tuple(node.left, x-1, y+1));
				}
				if(node.right != null) {
					queue.offer(new Tuple(node.right, x+1, y+1));
				}
			}
			*/
		}
		System.out.println(mapGroups);
		
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		for(TreeMap<Integer, PriorityQueue<Integer>> mapGroup : mapGroups.values()) {
			List<Integer> list = new ArrayList<Integer>();
			for(PriorityQueue<Integer> priorityQueue : mapGroup.values()) {
				while(!priorityQueue.isEmpty()) {
					list.add(priorityQueue.poll());
				}
			}
			lists.add(list);
		}
		
		System.out.println(lists);
	}

}
