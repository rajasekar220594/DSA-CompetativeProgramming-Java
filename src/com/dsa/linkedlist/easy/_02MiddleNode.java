package com.dsa.linkedlist.easy;

import com.dsa.linkedlist.util.SinglyLinkedList;
import com.dsa.linkedlist.util.SinglyLinkedList.Node;

public class _02MiddleNode {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertAll(new int[] {1,2,3,4,5,6});
		System.out.println(middleNode(list.head));
	}
	
	public static int middleNode(Node head) {

		Node slow_ptr = head;
		Node fast_ptr = head;

		while (fast_ptr != null && fast_ptr.next != null)
		{
			fast_ptr = fast_ptr.next.next;
			slow_ptr = slow_ptr.next;
		}
		System.out.println("The middle element is [" + slow_ptr.data + "] \n");

		return slow_ptr.data;
	}
}
