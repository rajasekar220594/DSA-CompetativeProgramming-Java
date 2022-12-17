package com.dsa.stack.recursion;

public class _06Modulo {

	public static void main(String[] args) {
		int dividend = 14;
		int divisor = 4;
		int remainder = dividend%divisor;
		System.out.println(remainder);
		System.out.println(moduloUsingIterative(dividend, divisor));
		System.out.println(moduloUsingRecursion(dividend, divisor));
	}
	public static int moduloUsingIterative(int dividend, int divisor) {
		while(dividend >= divisor) {
			dividend = dividend - divisor;
		}
		return dividend;
	}
	
	public static int moduloUsingRecursion(int dividend, int divisor) {
		if(dividend < divisor) {
			return dividend;
		}
		return moduloUsingRecursion(dividend-divisor, divisor);
	}

}
