package com.dsa.linkedlist.easy;

import java.util.HashMap;
import java.util.Map;

import com.dsa.linkedlist.util.SinglyLinkedList;
import com.dsa.linkedlist.util.SinglyLinkedList.Node;

public class _03FindKthNodeFromEndList {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertAll(new int[] {1,2,3,4});
		findKthNodeFromEndList3(list.head, 5);
	}
	
	public static void findKthNodeFromEndList1(Node head, int n) {
		int length=0;
		Node temp = head;
		while(temp != null) {
			length++;
			temp = temp.next;
		}
		length = length - n;
		temp = head;
		for(int i=0; i<length; i++) {
			temp = temp.next;
		}
		System.out.println(temp.data);
	}
	public static void findKthNodeFromEndList2(Node head, int n) {
		Node fastPointer = head, slowPointer = head;
		for(int i=0; i<n && fastPointer != null; i++) {
			fastPointer = fastPointer.next;
		}
		while(fastPointer != null) {
			fastPointer = fastPointer.next;
			slowPointer = slowPointer.next;
		}
		System.out.println(slowPointer.data);
	}
	public static void findKthNodeFromEndList3(Node head, int n) {
		Node temp = head;
		Map<Integer, Integer> hash = new HashMap<>();
		int i=0, length = 0;
		while(temp != null) {
			hash.put(i++, temp.data);
			temp = temp.next;
			length++;
		}
		i = length-n;
		System.out.println(hash.get(i));
	}
}
