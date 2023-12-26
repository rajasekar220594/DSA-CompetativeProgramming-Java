package com.dsa.maths.easy;

public class _01PrintAndCountDigits {

	public static void main(String[] args) {
		int n = 77890;
		System.out.println(countDigits(n));
		System.out.println(countDigitsUsingLog(n));
		printDigitsReverseOrder(n);
	}
	
	public static int countDigits(int n) {
		int count = 0;
		while(n>0) {
			count++;
			//int lastDigit = n%10;
			//System.out.print(lastDigit);
			n = n/10;
		}
		return count;
	}
	
	public static int countDigitsUsingLog(int n) {
		int count = (int) (Math.log10(n)+1);
		return count;
	}
	
	public static void printDigitsReverseOrder(int n) {
		while(n>0) {
			int lastDigit = n%10;
			System.out.print(lastDigit);
			n = n/10;
		}
	}

}
