package com.dsa.stack.recursion;

public class _04ExponentOfANumber {

	public static void main(String[] args) {
		//System.out.println(exponentOfANoUsingIterative(4,3));
		System.out.println(exponentOfANoUsingRecursion(4,3));
		System.out.println(Math.pow(4, 3));
	}
	
	public static int exponentOfANoUsingIterative(int baseNumber, int exponent) {
		int result = 1;
		for(int i=1; i<=exponent; i++) {
			result = result*baseNumber;
		}
		return result;
	}
	public static int exponentOfANoUsingRecursion(int baseNumber, int exponent) {
		if(exponent == 0) {
			return 1;
		} else {
			return baseNumber*exponentOfANoUsingRecursion(baseNumber, exponent-1);
		}
		
	}
}
