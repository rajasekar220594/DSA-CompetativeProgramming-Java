package com.dsa.stack.recursion;

public class _11ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverseStringUsingIterativeWithSameString("Hello world");
		System.out.println(reverseStringUsingRecursion("Hello world"));
	}
	
	public static void reverseStringUsingSubstring(String word) {
		//		for(int i=0; i<word.length(); i++) {
		//		// Reverse same o/p
		//		word = word.charAt(word.length()-1)+word.substring(0, word.length()-1);
		//	}

		//word = word.charAt(word.length()-1)+word.substring(0, word.length()-1);
		for(int i=0; i<word.length(); i++) {
			word = word.substring(0,i)+word.charAt(word.length()-1)+word.substring(i, word.length()-1);
		}
		System.out.println(word);
	}
	
	public static void reverseStringUsingIterativeWithNewString(String word) {
		String newWord = "";
		for(int i=word.length()-1; i>=0; i--) {
			newWord = newWord+word.charAt(i);
		}
		System.out.println(newWord);
	}
	public static void reverseStringUsingIterativeWithSameString(String word) {
		char[] ch = word.toCharArray();
		word = "";
		for(int i=ch.length-1; i>=0; i--) {
			word = word+ch[i];
		}
		System.out.println(word);
		
		// Improvement
		int l_index = 0, r_index = ch.length-1;
		while(l_index<r_index) {
			char temp = ch[l_index];
			ch[l_index++] = ch[r_index];
			ch[r_index--] = temp;
		}
		System.out.println(String.valueOf(ch));
	}
	public static void reverseStringUsingIterative(String word) {
		
		char ch[] = new char[word.length()];
		int l_index = 0, r_index = word.length()-1;
		while(l_index<r_index) {
			ch[l_index] = word.charAt(r_index);
			ch[r_index] = word.charAt(l_index);
			l_index++;
			r_index--;
		}
		if(r_index == l_index) {
			ch[l_index] = word.charAt(l_index);
		}
		System.out.println(String.valueOf(ch));
	}
	
	public static String reverseStringUsingRecursion(String word) {
		if(word.isEmpty()) {
			return word;
		}
		return reverseStringUsingRecursion(word.substring(1)) + word.charAt(0);
	}
}