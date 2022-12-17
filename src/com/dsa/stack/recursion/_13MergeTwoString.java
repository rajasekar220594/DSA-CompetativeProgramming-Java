package com.dsa.stack.recursion;

public class _13MergeTwoString {

	public static void main(String[] args) {
		System.out.println(mergeTwoStringRecurssion("cnt", "ace"));
	}

	public static String mergeTwoStringIterative(String s1, String s2) {
		int s1_index=0, s2_index=0;
		String s3 = "";
		while(s1_index < s1.length() && s2_index < s2.length()) {
			if(s1.charAt(s1_index) <= s2.charAt(s2_index)) {
				s3 = s3+s1.charAt(s1_index++);
			} else {
				s3 = s3+s2.charAt(s2_index++);
			}
		}
		while(s1_index < s1.length()) {
			s3 = s3+s1.charAt(s1_index++);
		}
		while(s2_index < s2.length()) {
			s3 = s3+s2.charAt(s2_index++);
		}
		return s3;
	}
	public static String mergeTwoStringRecurssion(String s1, String s2) {
		if(s1.isEmpty() && !s2.isEmpty()) {
			return s2;
		}
		if(!s1.isEmpty() && s2.isEmpty()) {
			return s1;
		}
		
		if(s1.charAt(0) <= s2.charAt(0)) {
			return s1.charAt(0)+mergeTwoStringRecurssion(s1.substring(1),s2);
		} else {
			return s2.charAt(0)+mergeTwoStringRecurssion(s1, s2.substring(1));
		}
	}
}
