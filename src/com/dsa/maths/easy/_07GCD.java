package com.dsa.maths.easy;

public class _07GCD {

	public static void main(String[] args) {
		System.out.println(gcdApproach1(15,20));
		System.out.println(gcdApproach2(15,20));
		System.out.println(gcdApproach3(15,20));
	}
	
	//Time complexity O(Min(n1,n2))
	public static int gcdApproach1(int n1, int n2) {
		int gcd=0;
		for(int i=1; i<=Math.min(n1, n2); i++) {
			if(n1%i==0 && n2%i==0) {
				gcd = i;
			}
		}
		return gcd;
	}
	//Time complexity O(Min(n1,n2))
	public static int gcdApproach2(int n1, int n2) {
		int gcd=0;
		for(int i=Math.min(n1, n2); i>0; i--) {
			if(n1%i==0 && n2%i==0) {
				return i;
			}
		}
		return gcd;
	}
	//Time complexity O(Min(n1,n2))
	public static int gcdApproach3(int n1, int n2) {
		while(n1 > 0 && n2 > 0) {
			if(n1 > n1) {
				n1 = n1 % n2;
			}
			else {
				n2 = n2 % n1;
			}
		}
		if(n1 == 0) return n2;
		return n1;
	}
}
