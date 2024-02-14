package com.dsa.maths.easy;

public class _02ReverseANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = -1563847412;
		System.out.println(reverseANumber(n));
	}

	public static int reverseANumber(int n) {
		long reversedNumber = 0;
		while(Math.abs(n)>0) {
			reversedNumber = reversedNumber*10+(n%10);
			n = n/10;
		}
		return (reversedNumber >= Integer.MIN_VALUE  && reversedNumber <= Integer.MAX_VALUE) ? (int) reversedNumber : 0;
	}
}
