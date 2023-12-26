package com.dsa.string.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Student {
	
	int id;
	
}
public class _03ReverseString {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(new Integer(10));
		set.add(new Integer(20));
		set.add(new Integer(10));
		System.out.println(set);
		
		Set<Student> set1 = new HashSet<>();
		set1.add(new Student());
		set1.add(new Student());
		System.out.println(set1);
		reverseStringUsingCharArray("ABCDE");
	}
	
	public static void reverseStringUsingCharArray(String input) {
		char a[] = input.toCharArray();
		int startIndex = 0, endIndex = a.length-1;
		while(startIndex < endIndex) {
			char temp = a[startIndex];
			a[startIndex++] = a[endIndex];
			a[endIndex--] = temp;
		}
		System.out.println(String.copyValueOf(a));
	}
	public static void reverseString(String input) {

	}
}
