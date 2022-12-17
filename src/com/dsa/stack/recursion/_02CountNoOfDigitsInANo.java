package com.dsa.stack.recursion;

public class _02CountNoOfDigitsInANo {

	public static void main(String[] args) {
		System.out.println(1/10);
		System.out.println(countDigitsUsingIterative(1435043));
		System.out.println(countDigitsUsingRecursion(1435043));
	}
	
	public static int countDigitsUsingIterative(int num) {
		int noOfDigits = 0;
		while(num>0) {
			num=num/10;
			noOfDigits++;
		}
		return noOfDigits;
	}
	public static int countDigitsUsingRecursion(int num) {
		if(num<=1) {
			return 1;
		} else {
			return countDigitsUsingRecursion(num/10)+1;
		}
	}
}
