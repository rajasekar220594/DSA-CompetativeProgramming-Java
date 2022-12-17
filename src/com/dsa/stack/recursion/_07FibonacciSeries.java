package com.dsa.stack.recursion;

public class _07FibonacciSeries {
	public static void main(String[] args) {
		int num = 5;
		System.out.println(fibonacciSeriesUsingIterative(num));
		System.out.println(fibonacciSeriesUsingRecursion(num));
	}
	
	public static int fibonacciSeriesUsingIterative(int num) {
		int f1=0,f2=1,f3=0;
		if (num <= 1) {
			return num;
		}

		for(int i=2; i<=num; i++) {
			f3=f1+f2;
			f1=f2;
			f2=f3;
		}
		return f3;
	}
	
	public static int fibonacciSeriesUsingRecursion(int num) {
		// Base case 
        /*if (num <= 1) {
            return num;
        }*/
		if(num == 1) {
			return 0;
		}
		if(num == 2) {
			return 1;
		}
        // Recursive case
        else {
            return (fibonacciSeriesUsingRecursion(num-1) + fibonacciSeriesUsingRecursion(num-2));
        }
	}
}
