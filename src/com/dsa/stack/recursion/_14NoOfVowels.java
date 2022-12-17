package com.dsa.stack.recursion;

public class _14NoOfVowels {

	public static void main(String[] args) {
		System.out.println(totalVowels("HELLo World", 11,0));

	}
	public static int totalVowels(String text, int len, int index) {
		if(index>=len) {
			return 0;
		}
		if('A' == text.charAt(index) || 'a' == text.charAt(index) || 'E' == text.charAt(index) || 
				'e' == text.charAt(index) || 'I' == text.charAt(index) || 'i' == text.charAt(index) || 
				'O' == text.charAt(index) || 'o' == text.charAt(index) || 'U' == text.charAt(index) || 
				'u' == text.charAt(index)) {
			return 1+totalVowels(text, len, ++index);
		} else {
			return 0+totalVowels(text, len, ++index);
		}
	}
}
