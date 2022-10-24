package com.dsa.array.easy;

/**
	Equilibrium index of an array
	
	Given a sequence arr[] of size n, Write a function int equilibrium(int[] arr, int n) that returns an equilibrium index (if any) or -1 if no equilibrium index exist.
	
	The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes. 
	
	Input: A[] = {-7, 1, 5, 2, -4, 3, 0} 
	Output: 3 
	3 is an equilibrium index, because: 
	A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
	
	Input: A[] = {1, 2, 3} 
	Output: -1 

	https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
 */
public class _16EquilibriumIndexInAnArray {
	public static void main(String[] args) {
		int arr[] = {-7, 1, 5, 2, -4, 3, 0};
		equilibriumIndexUsingTwoLoop(arr);
	}
	
	public static void equilibriumIndex(int arr[]) {
		int sum=0,leftSum=0;
		for(int i=0; i<arr.length;i++) {
			sum+=arr[i];
		}
		for(int i=0; i<arr.length; i++) {
			sum-=arr[i];
			if(sum == leftSum) {
				System.out.println("Found "+i);
			}
			leftSum+=arr[i];
		}
	}
	
	public static void equilibriumIndexUsingTwoLoop(int arr[]) {
		int leftSum=0,rightSum;
		for(int i=0; i<arr.length-1;i++) {
			leftSum+=arr[i];
			rightSum = 0;
			for(int j=i+2; j<arr.length; j++) {
				rightSum+=arr[j]; 
			}
			if(leftSum==rightSum) {
				System.out.println("Found "+(i+1));
			}
		}
	}
}
