package com.dsa.maths.easy;

public class _02ReverseANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 778900;
		System.out.println(reverseANumber(n));
	}

	public static int reverseANumber(int n) {
		int reversedNumber = 0;
		while(n>0) {
			reversedNumber = reversedNumber*10+(n%10);
			n = n/10;
		}
		return reversedNumber;
	}
}
