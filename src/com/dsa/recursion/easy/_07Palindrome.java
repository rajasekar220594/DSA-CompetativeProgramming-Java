package com.dsa.recursion.easy;

public class _07Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(palindrome("SMADAMS", 0));
	}
	
	public static boolean palindrome(String s, int startIndex) {
		if(startIndex>=s.length()/2) {
			return true;
		}
		if(s.charAt(startIndex) != s.charAt(s.length()-startIndex-1)) {
			return false;
		}
		return palindrome(s, ++startIndex);
	}

}
