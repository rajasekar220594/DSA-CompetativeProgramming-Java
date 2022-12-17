package com.dsa.stack.recursion;

public class _15Palindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("MADAM"));
		System.out.println(palindrome(new int[] {0, 0, 1, 0}, 0));
	}
	public static Object isPalindrome(String text) {
        if(text.isEmpty() || text.length() == 1) {
            return true;
        }
        if(text.charAt(0) == text.charAt(text.length()-1)) {
            return isPalindrome(text.substring(1,text.length()-1));
        } else {
            return false;
        }
    }
	
	public static Object palindrome(int[] array, int idx) {
		// Write your code here
		// Modify the return statement to "true" or "false"
		if(idx > array.length/2) {
			return true;
		}
		if(array[idx] == array[array.length-idx-1]) {
			return palindrome(array, ++idx);
		} else {
			return false;
		}
	}
}
