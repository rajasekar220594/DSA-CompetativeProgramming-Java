package com.dsa.tree.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.dsa.tree.util.BinaryTree;
import com.dsa.tree.util.Node;

public class _05ZigZagTraversalOrSpiralTraversal {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(new int[] {1, 2, 3, 4, 5, -1, 6,7,8,9,10});
		System.out.println(zigZagTraversalOrSpiralTraversal(tree.root));

	}

	public static List<List<Integer>> zigZagTraversalOrSpiralTraversal(Node root) {
		
		List<List<Integer>> groups = new ArrayList<List<Integer>>();
		if(root==null) return groups;
		
		boolean flag=true;
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size=queue.size();
			List<Integer> group = new ArrayList<Integer>();
			for(int i=0; i<size; i++) {
				root = queue.poll();
				group.add(root.data);
				if(root != null && root.left != null) queue.offer(root.left);
				if(root != null && root.right != null) queue.offer(root.right);
			}
			if(!flag) {
				Collections.reverse(group);
			}
			flag = !flag;
			groups.add(group);
		}
		return groups;
	}
}
