package com.dsa.recursion.easy;

public class _04ParameterisedAndFunctionalRecursion {

	// Sum of n no : Input n = 4 , Output 4+3+2+1=10
	public static void main(String[] args) {
		int n = 4;
		parameterisedRecursion(n, 0);
		System.out.println(functionalRecursion(n));
	}
	
	public static void parameterisedRecursion(int n, int sum) {
		if(n<1) {
			System.out.println(sum);
			return;
		}
		parameterisedRecursion(n-1, sum+n);
	}
	
	public static int functionalRecursion(int n) {
		if(n<1) {
			return n;
		}
		return functionalRecursion(n-1)+n;
	}

}
