package com.dsa.tree.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import com.dsa.tree.util.BinaryTree;
import com.dsa.tree.util.Node;

public class _12PrintRootToLeafNode {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});

		List<String> ans = new ArrayList<String>();
		printRootToLeafNode(binaryTree.root, new ArrayList<Integer>(), ans);
		System.out.println(ans);
	}
	
	public static void printRootToLeafNode(Node root, List<Integer> values, List<String> ans) {
		if(root == null) return;
		values.add(root.data);
		if(root != null && root.left == null && root.right == null) {
			//String str = String.join("->", values);
			StringJoiner sj = new StringJoiner("->");
			for(Integer val: values) sj.add(val+"");
			ans.add(sj.toString());
			//ans.add(sb.substring(0, sb.length()-2));
		}
		printRootToLeafNode(root.left, values, ans);
		printRootToLeafNode(root.right, values, ans);
		values.remove(values.size()-1);
	}

}
