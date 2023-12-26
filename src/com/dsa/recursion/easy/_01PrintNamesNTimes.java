package com.dsa.recursion.easy;

public class _01PrintNamesNTimes {

	public static void main(String[] args) {
		int n=3;
		printNamesNTimesStartWith1(1,n);
		printNamesNTimesStartWithN(n,n);
		printNamesNTimes(n);
	}
	
	public static void printNamesNTimesStartWith1(int i, int n) {
		if(i > n) return;
		System.out.println("printNamesNTimesStartWith1");
		printNamesNTimesStartWith1(i+1, n);
	}
	
	public static void printNamesNTimesStartWithN(int i, int n) {
		if(i < 1) return;
		System.out.println("printNamesNTimesStartWithN");
		printNamesNTimesStartWithN(i-1, n);
	}
	
	public static void printNamesNTimes(int n) {
		if(n<1) {
			return;
		}
		System.out.println("printNamesNTimes");
		printNamesNTimes(n-1);
	}
}
