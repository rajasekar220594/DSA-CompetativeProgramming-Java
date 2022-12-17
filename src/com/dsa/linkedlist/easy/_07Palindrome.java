package com.dsa.linkedlist.easy;

import java.util.Stack;

import com.dsa.linkedlist.util.SinglyLinkedList;
import com.dsa.linkedlist.util.SinglyLinkedList.Node;

public class _07Palindrome {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertAll(new int[] {1,2,3,2,1});
		palindromeUsingTwoPointer(list.head);
	}
	
	public static void palindromeButeForceApproach(Node head) {
		SinglyLinkedList clonedList = new SinglyLinkedList();
		Node temp = head, clonedNode;
		int count=0;
		while(temp != null) {
			clonedList.insertLast(temp.data);
			temp = temp.next;
			count++;
		}
		count = count/2;
		clonedNode = _01ReverseLinkedList.reverseLinkedList(clonedList.head);
		temp = head;
		for(int i=0; i<count; i++, clonedNode = clonedNode.next, temp = temp.next) {
			if(clonedNode.data != temp.data) {
				System.out.println("False");
				break;
			}
		}
	}
	
	public static void palindromeUsingStack(Node head) {
		Node temp = head;
		Stack<Integer> stack = new Stack<Integer>();
		int count=0;
		while(temp != null) {
			stack.push(temp.data);
			temp = temp.next;
			count++;
		}
		count = count/2;
		temp = head;
		for(int i=0; i<count && !stack.isEmpty(); i++, temp = temp.next) {
			if(stack.pop() != temp.data) {
				System.out.println("False");
				break;
			}
		}
	}
	
	public static void palindromeUsingTwoPointer(Node head) {
		Node current = head, secondHalf = null, middle = null;
		int count = count(head);
		count = (count%2==0) ? (count/2) : (count/2)+1;
		middle = findMiddle(head, count);
		current = middle.next;
		
		middle.next = _01ReverseLinkedList.reverseLinkedList(current);
		
		middle = findMiddle(head, count);
		secondHalf = middle.next;
				
		compareList(head, secondHalf);
		
		middle.next = _01ReverseLinkedList.reverseLinkedList(secondHalf);
		
	}
	
	public static int count(Node head) {
		int count=0;
		Node current = head;
		while(current != null) {
			current = current.next;
			count++;
		}
		return count;
	}
	
	public static Node findMiddle(Node head, int count) {
		Node middle = head;
		for(int i=0; i<count-1; i++) {
			middle = middle.next;
		}
		return middle;
	}
	
	public static void compareList(Node firstHalf, Node secondHalf) {
		while(firstHalf != null && secondHalf != null) {
			if(firstHalf.data != secondHalf.data) {
				System.out.println("False");
				break;
			}
			firstHalf = firstHalf.next;
			secondHalf= secondHalf.next;
		}
	}
}
