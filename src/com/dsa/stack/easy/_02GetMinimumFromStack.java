package com.dsa.stack.easy;

import java.util.Stack;

public class _02GetMinimumFromStack {

	static Stack<Integer> s1 = new Stack<Integer>();
	static Stack<Integer> s2 = new Stack<Integer>();
	static int minSoFar;
	public static void push(int value) {
		if(s1.isEmpty()) {
			minSoFar = value;
			s1.push(value);
			s2.push(minSoFar);
		} else {
			if(value <= minSoFar) {
				minSoFar = value;
				s2.push(minSoFar);
			}
			s1.push(value);
		}
	}
	public static int pop() {
		if(s1.peek() == s2.peek()) 	s2.pop();
		return s1.pop();
	}
	public static int getMinimum() {
		return s2.peek();
	}
	public static void main(String[] args) {
		push(10);
		push(6);
		push(20);
		push(6);
		push(25);
		push(5);
		
		System.out.println(getMinimum());
		System.out.println(pop());
		
		System.out.println(getMinimum());
		System.out.println(pop());
		
		System.out.println(getMinimum());
		System.out.println(pop());
		
		System.out.println(getMinimum());
		System.out.println(pop());
		
		System.out.println(getMinimum());
		System.out.println(pop());
	}

}
