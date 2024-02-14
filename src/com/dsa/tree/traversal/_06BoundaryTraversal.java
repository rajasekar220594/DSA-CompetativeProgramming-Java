package com.dsa.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.dsa.tree.util.BinaryTree;
import com.dsa.tree.util.Node;

public class _06BoundaryTraversal {

	public static void main(String[] args) {
		// Let us construct the tree given in the above
        // diagram
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
 
        List<Integer> ans = boundary(tree.root);
 
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();

	}

	public static boolean isLeaf(Node root) {
		if(root.left == null && root.right == null) return true;
		return false;
	}

	public static void addLeftBound(Node root, List<Integer> res) {
		root = root.left;
		while(root != null) {
			if (!isLeaf(root)) {
				res.add(root.data);
			}
			if(root.left != null) {
				root = root.left;
			} else  {
				root = root.right;
			}
		}
	}

	public static void addRightBound(Node root, List<Integer> res)
	{
		// Go right right and no right then left but again
		// check from right
		root = root.right;
		// As we need the reverse of this for Anticlockwise
		Stack<Integer> stk = new Stack<>();
		while (root != null) {
			if (!isLeaf(root)) {
				stk.push(root.data);
			}
			if (root.right != null) {
				root = root.right;
			}
			else {
				root = root.left;
			}
		}

		while (!stk.isEmpty()) {
			res.add(stk.peek());
			stk.pop();
		}
	}

	// its kind of predorder
	public static void addLeaves(Node root, List<Integer> res)
	{
		if (root == null) {
			return;
		}

		if (isLeaf(root)) {
			res.add(root.data); // just store leaf nodes
			return;
		}

		addLeaves(root.left, res);
		addLeaves(root.right, res);
	}

	public static List<Integer> boundary(Node root)
	{
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		if (!isLeaf(root)) {
			res.add(root.data); // if leaf then its done by
		}

		addLeftBound(root, res);
		addLeaves(root, res);
		addRightBound(root, res);
		return res;
	}

}
