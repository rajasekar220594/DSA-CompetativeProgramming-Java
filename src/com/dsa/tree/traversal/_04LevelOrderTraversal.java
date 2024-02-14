package com.dsa.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.dsa.tree.util.BinaryTree;
import com.dsa.tree.util.Node;

public class _04LevelOrderTraversal {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(new int[] { 1, 2, 7, 3, 4, 8, 9, -1, 11, 5, 6 });
		System.out.println(levelOrderTraversal(tree.root));
		System.out.println(levelOrderTraversal1(tree.root));
		System.out.println(levelOrderTraversal2(tree.root));
	}
	
	public static List<Integer> levelOrderTraversal(Node root) {
		List<Integer> levelOrder = new ArrayList<Integer>();
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			root = queue.poll();
			levelOrder.add(root.data);
			if(root.left != null) queue.offer(root.left);
			if(root.right != null) queue.offer(root.right);
		}
		return levelOrder;
	}
	
	public static List<List<Integer>> levelOrderTraversal1(Node root) {
		Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> wrap = new LinkedList<List<Integer>>();
        if(root==null) return wrap;
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int num = queue.size();
            for(int i=0; i<num; i++){
                if(queue.peek().left!=null) queue.add(queue.peek().left);
                if(queue.peek().right!=null) queue.add(queue.peek().right);
                list.add(queue.remove().data);
            }
            wrap.add(list);
        }
        return wrap;
	}
	
	public static List<List<Integer>> levelOrderTraversal2(Node root) {
		Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> wrap = new LinkedList<List<Integer>>();
        if(root==null) return wrap;
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int num = queue.size();
            for(int i=0; i<num; i++){
            	root = queue.poll();
            	list.add(root.data);

            	if(root != null && root.left != null) queue.offer(root.left);
            	if(root != null && root.right != null) queue.offer(root.right);
            }
            wrap.add(list);
        }
        return wrap;
	}

}
