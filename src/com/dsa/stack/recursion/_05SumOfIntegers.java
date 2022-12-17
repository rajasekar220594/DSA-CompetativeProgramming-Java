package com.dsa.stack.recursion;

public class _05SumOfIntegers {

	public static void main(String[] args) {
		int num = 12;
		System.out.println(sumOfIntegersUsingIterative(num));
		System.out.println(sumOfIntegersUsingRecursion(num));
		System.out.println(num*(num+1)/2);
	}
	public static int sumOfIntegersUsingIterative(int num) {
		int result = 0;
		for(int i=1; i<=num; i++) {
			result=result+i;
		}
		return result;
	}
	public static int sumOfIntegersUsingRecursion(int num) {
		if(num==0) return 0;
		return sumOfIntegersUsingRecursion(num-1)+num;
	}

}
