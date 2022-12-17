package com.dsa.stack.easy;

import java.util.Stack;

public class _03GetMinimumFromStackZeroSpace {
	static Stack<Integer> s1 = new Stack<Integer>();
	static int currMin;
	
	public static void push(int value) {
		if(s1.isEmpty()) {
			currMin = value;
			s1.push(value);
			return;
		}
		if(value < currMin) {
			s1.push(value-currMin);
			currMin = value;
		} else {
			s1.push(value);
		}
	}
	public static int pop() {
		int value;
		if(s1.peek() < currMin) {
			value = currMin;
			currMin = currMin-s1.pop();
		} else {
			value = s1.pop();
		}
		return value;
	}
	public static int getMinimum() {
		return currMin;
	} 
	public static void main(String[] args) {
		int arr[] = {10,20,5,15,3,6,2,1};
		for(int i=0; i<arr.length; i++) {
			push(arr[i]);
		}
		for(int i=0; i<arr.length; i++) {
			System.out.println(getMinimum() +"---"+pop());
		}
	}

}
