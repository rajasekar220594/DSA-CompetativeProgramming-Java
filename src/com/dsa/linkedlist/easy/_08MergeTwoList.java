package com.dsa.linkedlist.easy;

import com.dsa.linkedlist.util.SinglyLinkedList;
import com.dsa.linkedlist.util.SinglyLinkedList.Node;

public class _08MergeTwoList {

	public static void main(String[] args) {
		SinglyLinkedList list1 = new SinglyLinkedList();
		list1.insertAll(new int[] {1,2,3,4,5,7});
		
		SinglyLinkedList list2 = new SinglyLinkedList();
		list2.insertAll(new int[] {6,8});
		mergeList(list1.head, list2.head);
	}
	
	public static void mergeList(Node node1, Node node2) {
		Node mergeList = null, temp;
		if(node1.data <= node2.data) {
			mergeList = node1;
			node1 = node1.next;
		} else {
			mergeList = node2;
			node2 = node2.next;
		}
		temp = mergeList;
		while(node1 != null && node2 != null) {
			if(node1.data == node2.data) {
				temp.next = node1;
				temp = node1; // temp.next
				node1 = node1.next;
				node2 = node2.next;
			} else if(node1.data < node2.data) {
				temp.next = node1;
				temp = node1; // temp.next
				node1 = node1.next;
			} else {
				temp.next = node2;
				temp = node2; // temp.next
				node2 = node2.next;
			}
		}
		
		if(node1 != null) {
			temp.next = node1;
		} else if(node2 != null) {
			temp.next = node2;
		}
	}
}
