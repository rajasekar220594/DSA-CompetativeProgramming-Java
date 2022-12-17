package com.dsa.stack.easy;

import java.util.LinkedList;
import java.util.Queue;

public class _01ImplStactUsingQueue {

	static Queue<Integer> q1 = new LinkedList<Integer>();
	static Queue<Integer> q2 = new LinkedList<Integer>();
	
	public static void push(int value) {
		if(q1.isEmpty() && q2.isEmpty()) {
			q1.offer(value);
			return;
		}
		if(q1.isEmpty()) {
			q1.offer(value);
			while(!q2.isEmpty()) {
				q1.offer(q2.poll());
			}
		} else {
			q2.offer(value);
			while(!q1.isEmpty()) {
				q2.offer(q1.poll());
			}
		}
	}
	
	public static int pop() {
		return !q1.isEmpty() ? q1.poll() : q2.poll();
	}
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5};
		for(int i=0; i<arr.length; i++) {
			push(arr[i]);
		}
		System.out.println(pop());
		System.out.println(pop());
	}
}
