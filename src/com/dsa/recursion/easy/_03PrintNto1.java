package com.dsa.recursion.easy;

public class _03PrintNto1 {
	
	public static void main(String[] args) {
		int n = 5;
		//printNto1(n);
		//printNto1(n,n);
		printNto1Approach2(1,n);
		
	}
	
	public static void printNto1(int n) {
		if(n<1) return;
		System.out.println(n);
		printNto1(n-1);
	}
	
	public static void printNto1(int i, int n) {
		if(i<1) return;
		System.out.println(i);
		printNto1(i-1, n);
	}	
	
	// Backtracking approach
	public static void printNto1Approach2(int i, int n) {
		if(i>n) return;
		printNto1Approach2(i+1, n);
		System.out.println(i);
	}

}
