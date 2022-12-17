package com.dsa.stack.recursion;

public class _09PrimeNo {

	public static void main(String[] args) {
		System.out.println(isPrimeUsingRecursion(2, 2));
		System.out.println(isPrimeUsingRecursion(9, 2));
		System.out.println(isPrimeUsingIterative(4));
		int input = 13;
        boolean result = isPrime(input, input/2);
	}

	public static boolean isPrimeUsingIterative(int num) {
		if (num < 2) {
			return false;
		}
		int i = num/2;
		for(; i>1; i--) {
			if(num%i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPrimeUsingRecursion(int num, int i) {
		if(i>=num) {
			return true;
		}
		if(num%i==0) {
			return false;
		}
		return isPrimeUsingRecursion(num,i+1);
	}

	public static boolean isPrime(int num, int i) {

		// First base case
		if (num < 2) {
			return false;
		}
		// Second base case
		else if (i == 1) {
			return true;
		}
		// Third base case
		else if (num%i == 0) {
			return false;
		}
		// Recursive case
		else {
			return isPrime(num, i-1);
		}
	}

}
