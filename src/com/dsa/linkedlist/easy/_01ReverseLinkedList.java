package com.dsa.linkedlist.easy;

import com.dsa.linkedlist.util.SinglyLinkedList;
import com.dsa.linkedlist.util.SinglyLinkedList.Node;

public class _01ReverseLinkedList {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertAll(new int[] {1,2,3,4,5});
		//reverseLinkedListUsingArray(list.head, list.length());
		list.head = reverseLinkedList(list.head);
		list.display();
	}

	public static void reverseLinkedListUsingArray(Node head, int length) {
	    int arr[] = new int[length];
	    int i=0;
	    Node temp = head;
	    while(temp != null) {
	    	arr[i++] = temp.data;
	    	temp = temp.next;
	    }
	    temp = head;
	    i=length-1;
	    while(temp != null) {
	    	temp.data = arr[i--];
	    	temp = temp.next;
	    }
	    head = temp;
	}
	
	public static Node reverseLinkedList(Node head) {
		Node prev = null, current = head, next;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
}
