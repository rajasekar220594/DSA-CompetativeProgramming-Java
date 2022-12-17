package com.dsa.stack.recursion;

import java.util.Stack;

public class _01Factorial {

	public static void main(String[] args) {
		System.out.println(factorialUsingIterative(6));
		System.out.println(factorialUsingRecursion(6));
		System.out.println(factorialUsingStack(6));
	}

	public static int factorialUsingIterative(int n) {
		int factorialResult = 1;
		for(int i=1; i<=n; i++) {
			factorialResult = factorialResult*i;
		}
		return factorialResult;
	}
	public static int factorialUsingRecursion(int n) {
		if(n == 1) {
			return 1;
		} else {
			return n*factorialUsingRecursion(n-1);
		}
	}
	public static int factorialUsingStack(int n) {
		int factorialResult = 1;
		Stack<Integer> stack = new Stack<>();
		for(int i=2; i<=n; i++) {
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			factorialResult = factorialResult*stack.pop();
		}
		return factorialResult;
	}
}
