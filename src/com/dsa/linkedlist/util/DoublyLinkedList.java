package com.dsa.linkedlist.util;

public class DoublyLinkedList {

	private Node head;
	private Node tail;
	private int length;
	
	private static class Node {
		private int data;
		private Node previous;
		private Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	public boolean isEmpty() {
		return length == 0; // if length ==0 then return true else false;
	}
	
	public int length() {
		return length;
	}
	
	public void displayForward() {
		if(head == null) return;
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	public void displayBackward() {
		if(tail == null) return;
		Node temp = tail;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.previous;
		}
	}
	
	public void insertFirst(int value) {
		Node node = new Node(value);
		if(head == null) {
			head = node;
			tail = node;
		} else {
			head.previous = node;
			node.next = head;
			head = node;
		}
		length++;
	}
	
	public void insertLast(int value) {
		Node node = new Node(value);
		if(tail == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			node.previous = tail;
			tail = node;
		}
		length++;
	}
	
	public void insert(int position, int value) {
		Node node = new Node(value);
		if(position == 1) {
			head.previous = node;
			node.next = head;
			head = node;
		} else {
			Node current = head;
			int count =1;
			while(count < position-1) {
				current = current.next;
				count++;
			}
			Node next = current.next;
			current.next = node;
			node.previous = current;
			node.next = next;
			next.previous = node;
		}
		length++;
	}
	
	public void insertAll(int arr[]) {
		Node firstNode = new Node(arr[0]);
		head = firstNode;
		for(int i=1; i<arr.length; i++) {
			Node nextNode = new Node(arr[i]);
			nextNode.previous = firstNode;
			firstNode.next = nextNode;
			firstNode = nextNode;
		}
		tail = firstNode;
	}
	
	public Node deleteFirst() {
		if(head == null) return head;
		Node current = head;
		head = current.next;
		head.previous = null;
		current.next = null;
		return current;
	}
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.insertAll(new int[] {1,2,3,4,5});
		
		dll.deleteFirst();
		
		dll.displayForward();
		dll.displayBackward();
	}
}
