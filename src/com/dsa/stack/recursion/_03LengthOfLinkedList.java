package com.dsa.stack.recursion;

import java.util.LinkedList;

import com.dsa.linkedlist.util.SinglyLinkedList;
import com.dsa.linkedlist.util.SinglyLinkedList.Node;

public class _03LengthOfLinkedList {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertAll(new int[] {1,2,3,4,5,6,7});
		System.out.println(lengthOfLinkedListUsingRecursion(list.head));
		System.out.println(lengthOfLinkedListUsingIterative(list.head));
	}
	
	public static int lengthOfLinkedListUsingIterative(Node node) {
		int length = 0;
		while(node!=null) {
			node = node.next;
			length++;
		}
		return length;
	}
	public static int lengthOfLinkedListUsingRecursion(Node node) {
		if(node == null) {
			return 0;
		} else {
			return lengthOfLinkedListUsingRecursion(node.next)+1;
		}
	}
	

}
