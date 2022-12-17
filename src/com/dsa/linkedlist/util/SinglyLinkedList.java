package com.dsa.linkedlist.util;

public class SinglyLinkedList {

	public Node head;
	
	public static class Node {
		public int data;
		public Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void insertFirst(int value) {
		Node firstNode = new Node(value);
		if(head == null) {
			head = firstNode;
			return;
		}
		firstNode.next = head;
		head = firstNode;
	}
	
	public void insertLast(Node node) {
		if(head == null) {
			head = node;
			return;
		}
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = node;
	}
	public void insertLast(int value) {
		Node lastNode = new Node(value);
		if(head == null) {
			head = lastNode;
			return;
		}
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = lastNode;
	}
	
	public void insert(int position, int value) {
		Node newNode = new Node(value);
		if(position == 1) {
			newNode.next = head;
			head = newNode;
			return;
		}
		Node previous = head;
		int count = 1;
		while(count < position-1) {
			previous = previous.next;
			count++;
		}
		
		Node current = previous.next;
		previous.next = newNode;
		newNode.next =  current;
	}
	
	public void insertAll(int arr[]) {
		if(head == null) {
			head = new Node(arr[0]);
			Node current = head;
			for(int i=1; i<arr.length; i++) {
				Node nextNode = new Node(arr[i]);
	 			current.next = nextNode;
				current = nextNode;
			}
		} else {
			Node current = head;
			while(current.next != null) {
				current = current.next;
			}
			
			Node node = new Node(arr[0]);
			current.next = node;
			current = node;
			for(int i=1; i<arr.length; i++) {
				Node nextNode = new Node(arr[i]);
				current.next = nextNode;
				current = nextNode;
			}
		}
	}
	
	public void display() {
		Node current = head;
		while(current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	public int length() {
		if(head == null) return 0;
		Node current = head;
		int count = 0;
		while(current != null) {
			count++;
			current = current.next;
		}
		System.out.println("Total Count --> "+count);
		return count;
	}
	
	public Node deleteFirst() {
		if(head == null) return null;
		Node temp = head;
		head = head.next;
		temp.next = null;
		return temp;
	}
	
	public Node deleteLast() {
		if(head == null || head.next == null) return head;
		Node previous = head;
		while(previous.next.next != null) {
			previous = previous.next;
		}
		Node current = previous.next;
		previous.next = null;
		return current;
	}
	
	public Node delete(int position) {
		if(head == null) return null;
		if(position == 1) {
			// call delete first or write code
			Node temp = head;
			head = head.next;
			temp.next = null;
			return temp;
		} else {
			Node previous = head;
			int count = 1;
			while(count < position-1) {
				previous = previous.next;
				count++;
			}
			Node current = previous.next;
			previous.next = current.next;
			current.next = null;
			return current;
		}
	}
	
	public boolean find(int searchKey) {
		if(head == null) return false;
		Node current = head;
		while(current != null) {
			if(current.data == searchKey) {
				return true;
			}
			current = current.next; 
		}
		return false;
	}
	
	public Node reverse() {
		if(head == null) return head;
		
		Node current = head, next = null, previous = null;
		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}
	public static void addTwoNumbers(Node l1, Node l2) {
		Node main = null, l3 = null, l4 = null;
		int carryForward = 0, sum = 0;
		while(l1 != null || l2 != null || carryForward > 0) {
			sum = carryForward;
			if(l1 != null) {
				sum += l1.data;
				l1 = l1.next;
			}
			if(l2 != null) {
				sum += l2.data;
				l2 = l2.next;
			}
			
			if((sum/10)<1) {
				l4 = new Node(sum);
				carryForward = 0;
			} else {
				l4 = new Node(sum%10);
				carryForward = 1;
			}
			if(l3 == null) {
				l3 = l4;
				main = l3;
			} else {
				l3.next = l4;
				l3 = l4;
			}
		}
    }
	public static void main(String[] args) {
		System.out.println(10%10);
		SinglyLinkedList sl1 = new SinglyLinkedList();
		sl1.insertAll(new int[] {9,9,9,9,9,9,9});
		SinglyLinkedList sl2 = new SinglyLinkedList();
		sl2.insertAll(new int[] {9,9,9,9});
		addTwoNumbers(sl1.head, sl2.head);
		
		
	}
	
}
