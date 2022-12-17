package com.dsa.tree.easy;

import java.util.Stack;

import com.dsa.array.util.ArraysUtil;
import com.dsa.tree.util.BinaryTree;
import com.dsa.tree.util.Node;

public class _05LowestCommonAncestorBT {

	public static void main(String[] args) {
		int arr[]   = {1,2,3,4,5,7,8,9,10,11,12,-1,-1,13,14};
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(arr);
		System.out.println(iterativeLCAUsingStack(tree.root, 9, 10));

	}
	
	public static int iterativeLCAUsingStack(Node root, int p, int q) {
		Stack<Node> s = new Stack<Node>();
		int l_arr[], r_arr[];
		int i;
		Node temp = root;
		while(temp != null || !s.isEmpty()) {
			if(temp != null) {
				s.push(temp);
				if(temp.data == p) {
					break;
				}
				temp = temp.left;
			} else {
				temp = s.pop();
				temp = temp.right;
			}
		}
		
		l_arr = new int[s.size()];
		i = s.size()-1;
		while(!s.isEmpty()) {
			temp = s.pop();
			l_arr[i--] = temp.data;
		}
		ArraysUtil.display(l_arr);
		
		temp = root;
		while(temp != null || !s.isEmpty()) {
			if(temp != null) {
				s.push(temp);
				if(temp.data == q) {
					break;
				}
				temp = temp.left;
			} else {
				temp = s.pop();
				temp = temp.right;
			}
		}
		r_arr = new int[s.size()];
		i = s.size()-1;
		while(!s.isEmpty()) {
			temp = s.pop();
			r_arr[i--] = temp.data;
		}
		ArraysUtil.display(r_arr);
		for(i=0; i<l_arr.length && i<r_arr.length; i++) {
			if(l_arr[i] != r_arr[i]) break;
		}
		
		return 0;
	}

}
