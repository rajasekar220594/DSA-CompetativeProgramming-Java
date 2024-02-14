package com.dsa.tree.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.dsa.tree.util.BinaryTree;
import com.dsa.tree.util.Node;

public class _11PrintRootToNodePath {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
		
		for(int i=1; i<=15; i++) {
			printRootToNodePathIteration(binaryTree.root, i);
		}
		for(int i=1; i<=15; i++) {
			List<Node> ans = new ArrayList<Node>();
			System.out.println(printRootToNodePathRecursion1(binaryTree.root, i, ans));
			System.out.println(ans);
			for(Node node : ans) System.out.print(node.data+" ");
		}
		
		for(int i=1; i<=15; i++) {
			List<Integer> ans = new ArrayList<>();
			System.out.println(printRootToNodePathRecursion2(binaryTree.root, i, ans));
			System.out.println(ans);
		}
		
	}
	
	public static boolean printRootToNodePathRecursion1(Node root, int val, List<Node> ans) {
		if(root == null) return false;
		ans.add(root);
		if(root.data == val) return true;
		
		if(printRootToNodePathRecursion1(root.left, val, ans) || printRootToNodePathRecursion1(root.right, val, ans)) {
			return true;
		}
		ans.remove(root);
		return false;
	}
	public static boolean printRootToNodePathRecursion2(Node root, int val, List<Integer> ans) {
		if(root == null) return false;
		ans.add(root.data);
		if(root.data == val) return true;
		
		if(printRootToNodePathRecursion2(root.left, val, ans) || printRootToNodePathRecursion2(root.right, val, ans)) {
			return true;
		}
		
		ans.remove(ans.size() - 1); // ans.removeLast();
		return false;
	}
	
	public static List<Integer> printRootToNodePathIteration(Node root, int target) {
		List<Integer> ans = new ArrayList<Integer>();
		if(root == null) return ans;
		
		Node curr = root;
        Node prev = null;
        Stack<Node> stack = new Stack<>();
        
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                ans.add(curr.data);
                curr = curr.left;
            }
 
            curr = stack.pop();
 
            if (curr.right != null && curr.right != prev) {
                curr = curr.right;
            } else {
                if (curr.data == target) {
                    break;
                }
                ans.remove(ans.size() - 1);
                prev = curr;
                curr = null;
            }
        }
		
		System.out.println(ans);
		return ans;
	}
}
