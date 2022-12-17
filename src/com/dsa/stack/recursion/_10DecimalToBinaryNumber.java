package com.dsa.stack.recursion;

public class _10DecimalToBinaryNumber {

	public static void main(String[] args) {
		System.out.println(convertDecimalToBinaryNumberUsingIterative(19));
		for(int i=0; i<=20; i++)
			System.out.println(Integer.valueOf(convertDecimalToBinaryNumberUsingRecursion(i)));
	}

	public static int convertDecimalToBinaryNumberUsingIterative(int num) {
		String returnValue ="";
		while(num > 0) {
			returnValue = num%2+returnValue;
			num = num/2;
		}
		return Integer.valueOf(returnValue);
	}
	public static String convertDecimalToBinaryNumberUsingRecursion(int num) {
		if(num < 1) {
			return String.valueOf(num);
		}
		return convertDecimalToBinaryNumberUsingRecursion(num/2)+num%2;
	}
	public static int decimalToBinary(int decimalNum) {
		if (decimalNum == 0) {
			return 0;
		}
		else {
			return (decimalNum%2 + 10*decimalToBinary(decimalNum/2));
		}
	}
}
