package com.dsa.linkedlist.easy;

import com.dsa.linkedlist.util.SinglyLinkedList;
import com.dsa.linkedlist.util.SinglyLinkedList.Node;

public class _06AlternatingSplit {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertAll(new int[] {1,2,3,4,5,6,7,8});
		splitEvenAndOddSameList(list.head);
	}
	
	public static void splitEvenAndOddUsingTwoNewList(Node head) {
		SinglyLinkedList even = new SinglyLinkedList(), odd = new SinglyLinkedList();
		int i=1;
		while(head != null) {
			if(i%2 == 0) {
				even.insertLast(head.data);
			} else {
				odd.insertLast(head.data);
			}
			head = head.next;
			i++;
		}
	}
	public static void splitEvenAndOddSameList(Node head) {
		if(head == null || head.next == null) return;
		Node odd = head, even = head.next;
		Node current = head, next = null;
		while(current.next != null) {
			next = current.next;
			current.next = current.next.next;
			current = next;
		}
	}
}
