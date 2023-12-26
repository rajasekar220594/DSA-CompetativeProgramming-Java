package com.dsa.maths.easy;

public class _03CheckPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 11211;
		System.out.println(checkPalindrome(n));
	}
	
	public static boolean checkPalindrome(int n) {
		int originalNo = n, reverseNo = 0;
		while(n > 0) {
			reverseNo = reverseNo*10 + (n%10);
			n = n/10;
		}
		return (originalNo == reverseNo);
	}

}
