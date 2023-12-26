package com.dsa.recursion.easy;

public class _08FibbonaciSeries {

	public static void main(String[] args) {
		System.out.println(fibbonaciSeriesWithRecursion(0));
		System.out.println(fibbonaciSeriesWithRecursion(1));
		System.out.println(fibbonaciSeriesWithRecursion(2));
		System.out.println(fibbonaciSeriesWithRecursion(3));
		System.out.println(fibbonaciSeriesWithRecursion(4));
		System.out.println(fibbonaciSeriesWithRecursion(5));
		System.out.println(fibbonaciSeriesWithRecursion(6));
	}
	
	public static int fibbonaciSeriesWithoutRecursion(int n) {
		int f1=0, f2=1,f3=0;
		
		if(n==0) return f1;
		if(n==1) return f2;
		for(int i=1; i<n; i++) {
			f3=f1+f2;
			f1=f2;
			f2=f3;
		}
		return f3;
	}
	
	public static int fibbonaciSeriesWithRecursion(int n) {
		//if(n==0) return 0;
		//if(n==1) return 1;
		if(n<=1) return n;
		
		return fibbonaciSeriesWithRecursion(n-1)+fibbonaciSeriesWithRecursion(n-2);
	}

}
