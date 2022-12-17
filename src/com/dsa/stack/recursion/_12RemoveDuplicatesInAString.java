package com.dsa.stack.recursion;

public class _12RemoveDuplicatesInAString {

	public static void main(String[] args) {
		String str = "TThissssss iss a testt";
		System.out.println(removeDuplicatesUsingIterative(str));
		System.out.println(removeDuplicatesUsingRecursion(str));
	}
	
	public static String removeDuplicatesUsingIterative(String str) {
		char ch[] = str.toCharArray();
		int firstPtr = 0, secondPtr = 1;
		str = str.charAt(0)+"";
		while(firstPtr<secondPtr && secondPtr<ch.length) {
			if(ch[firstPtr] != ch[secondPtr]) {
				str = str+ch[secondPtr];
				firstPtr = secondPtr;
				secondPtr++;
			} else {
				secondPtr++;
			}
		}
		int i=1;
		while(i<str.length()) {
			if(str.charAt(i-1) == str.charAt(i)) {
				str = str.substring(0, i)+str.substring(i+1, str.length());
			} else {
				i++;	
			}
		}
		return str;
	}
	
	public static String removeDuplicatesUsingRecursion(String str) {
		// TTThissssss iss a testt
		if(str.isEmpty()) {
			return str;
		}
		if(str.length() > 1 && str.charAt(0) == str.charAt(1)) {
			return removeDuplicatesUsingRecursion(str.substring(1));
		} else {
			return str.charAt(0)+removeDuplicatesUsingRecursion(str.substring(1));
		}
	}

}
