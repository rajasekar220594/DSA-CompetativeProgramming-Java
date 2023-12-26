package com.dsa.maths.easy;

public class _06IsPrimeNo {

	public static void main(String[] args) {
		for(int i=1; i<30; i++) {
			System.out.println(i+"----"+isPrimeNoApproach3(i));
		}

	}
	
	public static boolean isPrimeNoApproach1(int n) {
		if(n==2) return false;
		for(int i=2;i<n; i++) {
			if(n%i==0) return false;
		}
		return true;
	}
	public static boolean isPrimeNoApproach2(int n) {
		if(n==1) return true;
		if(n==2) return false;
		int count=0;
		for(int i=1;i<=n; i++) {
			if(n%i==0) count++;
		}
		return count==2;
	}
	
	public static boolean isPrimeNoApproach3(int n) {
		if(n==1) return true;
		if(n==2) return false;
		int count=0;
		for(int i=1;i*i<=n; i++) {
			if(n%i==0) {
				count++;
				if(n/i!=i) count++;
			}
		}
		return count==2;
	}

}
