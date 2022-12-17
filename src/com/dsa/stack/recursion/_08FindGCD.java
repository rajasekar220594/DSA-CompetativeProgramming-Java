package com.dsa.stack.recursion;

public class _08FindGCD {

	public static void main(String[] args) {
		System.out.println(gcdUsingRecursion(24,18));
		System.out.println(gcdUsingInterative(36,54));
	}

	public static int gcdUsingInterative(int num1, int num2) {
		int i = 1, gcd = 1;
		while(i<=num1 && i<=num2) {
			if((num1%i) == 0 && (num2%i) == 0) {
				gcd=i;
			}
			i++;
		}
		return gcd;
	}

	public static int gcdUsingRecursion(int num1, int num2) {
		if (num2 == 0)
			return num1;
		return gcdUsingRecursion(num2, num1 % num2); 
	}

	public static int gcd(int num1, int num2) {

		// Base case
		if (num1 == num2) {
			return num1;
		}
		// Recursive case
		if (num1 > num2) {
			return gcd(num1-num2, num2);
		}
		else {
			return gcd(num1, num2-num1);
		}
	}
}
