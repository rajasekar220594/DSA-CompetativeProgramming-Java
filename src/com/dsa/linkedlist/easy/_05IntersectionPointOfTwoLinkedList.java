package com.dsa.linkedlist.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.dsa.linkedlist.util.SinglyLinkedList;
import com.dsa.linkedlist.util.SinglyLinkedList.Node;

public class _05IntersectionPointOfTwoLinkedList {

	public static void main(String[] args) {
		SinglyLinkedList common = new SinglyLinkedList();
		common.insertAll(new int[] {8,9,10,11});
		
		SinglyLinkedList list1 = new SinglyLinkedList();
		list1.insertAll(new int[] {1,2,3,4});
		list1.insertLast(common.head);
		
		SinglyLinkedList list2 = new SinglyLinkedList();
		list2.insertAll(new int[] {5,6,7});
		list2.insertLast(common.head);
		
		usingTwoPointers(list1.head, list2.head);
	}

	public static void usingBruteForce(Node node1, Node node2) {
		while(node1 != null) {
			Node temp = node2;
			while(temp != null) {
				if(node1 == temp) {
					System.out.println("True >>>> "+node1.data);
					return;
				}
				temp = temp.next;
			}
			node1 = node1.next;
		}
	}
	public static void usingHash(Node node1, Node node2) {
		Map<Node, Integer> hash = new HashMap<>();
		while(node1 != null) {
			hash.put(node1, null);
			node1 = node1.next;
		}
		while(node2 != null) {
			if(hash.containsKey(node2)) {
				System.out.println("True");
				break;
			}
			node2 = node2.next;
		}
	}
	public static void usingStack(Node node1, Node node2) {
		Stack<Node> stack1 = new Stack<SinglyLinkedList.Node>();
		Stack<Node> stack2 = new Stack<SinglyLinkedList.Node>();
		while(node1 != null) {
			stack1.push(node1);
			node1 = node1.next;
		}
		while(node2 != null) {
			stack2.push(node2);
			node2 = node2.next;
		}
		Node intersectionPoint = null;
		while(!stack1.isEmpty() && !stack2.isEmpty()) {
			if(stack1.peek() == stack2.peek()) {
				intersectionPoint = stack1.pop();
				stack2.pop();
			} else {
				System.out.println(intersectionPoint.data);
				break;
			}
		}
	}
	public static void usingTwoPointers(Node node1, Node node2) {
		int length1 = 0, length2 = 0;
		Node temp1 = node1, temp2 = node2;
		while(temp1 != null) {
			temp1 = temp1.next;
			length1++;
		}
		while(temp2 != null) {
			temp2 = temp2.next;
			length2++;
		}
		int diff = 0;
		if(length1>length2){
			diff = length1 - length2;
			temp1 = node1;
			temp2 = node2;
		} else {
			diff = length2 - length1;
			temp1 = node2;
			temp2 = node1;
		}
		for(int i=0; i<diff; i++) {
			temp1 = temp1.next;
		}
		while(temp1 != null && temp2 != null) {
			if(temp1 == temp2) {
				System.out.println("True >>>> "+temp1.data);
				return;
			}
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
	}
}
