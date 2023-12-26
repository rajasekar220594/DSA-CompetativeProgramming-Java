package com.dsa.recursion.easy;

public class _02Print1toN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		//print1toNUsingRecursion(n);
		//print1toNUsingRecursion(1, n);
		print1toNUsingRecursion1(n, n);
	}
	
	public static void print1toNWithoutRecursion(int n) {
		for(int i=1; i<=n; i++) {
			System.out.println(i);
		}
	}
	
	// Direct approach
	public static void print1toNUsingRecursion(int i, int n) {
		if(i > n) return;
		System.out.println(i);
		print1toNUsingRecursion(i+1, n);
	}
	
	// Backtracking approach
	public static void print1toNUsingRecursion1(int i, int n) {
		if(i < 1) return;
		print1toNUsingRecursion1(i-1, n);
		System.out.println(i);
		
	}

	// Backtracking approach
	public static void print1toNUsingRecursion(int n) {
		if(n == 1) {
			System.out.println(n);
			return;
		} else {
			print1toNUsingRecursion(n-1);
			System.out.println(n);
		}
	}
	
}
