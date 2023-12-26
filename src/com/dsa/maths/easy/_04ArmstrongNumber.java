package com.dsa.maths.easy;

public class _04ArmstrongNumber {

	public static void main(String[] args) {
		System.out.println(armstrongNumberApproach2(371));
		System.out.println(armstrongNumberApproach2(1634));
		System.out.println(armstrongNumberApproach2(153));
		System.out.println(armstrongNumberApproach2(35));
		System.out.println(armstrongNumberApproach2(1));
		System.out.println(armstrongNumberApproach2(2));
		System.out.println(armstrongNumberApproach2(3));
	}
	
	
	public static boolean armstrongNumberApproach1(int n) {
		int originalNo = n, sum = 0, count = 0;
		
		// count digits
		while(n>0) {
			count++;
			n = n/10;
		}
		
		n = originalNo;
		
		while(n>0) {
			int lastDigit = n%10, multiply=1;
			for(int i=0; i<count; i++) {
				multiply = lastDigit*multiply;
			}
			sum = sum + multiply;
			n = n/10;
		}
		return originalNo == sum;
	}
	
	public static boolean armstrongNumberApproach2(int n) {
		int originalNo = n, sum = 0, count = 0;
		
		// count digits
		while(n>0) {
			count++;
			n = n/10;
		}
		
		n = originalNo;
		
		while(n>0) {
			int lastDigit = n%10;

			sum = sum + (int) Math.pow(lastDigit, count);
			n = n/10;
		}
		return originalNo == sum;
	}
}
