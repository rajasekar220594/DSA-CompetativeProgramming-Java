package com.dsa.stack.easy;

import java.util.Stack;

import com.dsa.array.util.ArraysUtil;

public class _04ClosestGreatestElement {

	public static void main(String[] args) {
		int arr[] = {10, 20, 1, 5, 25, 500, 60};
		closestGreatestElementUsingStack(arr);
	}
	
	public static void closestGreatestElementUsingStack(int arr[]) {
		int arr2[] = new int[arr.length];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		int i=1;
		while(!stack.isEmpty()) {
			
		}
		
		ArraysUtil.display(arr2);
	}

}
