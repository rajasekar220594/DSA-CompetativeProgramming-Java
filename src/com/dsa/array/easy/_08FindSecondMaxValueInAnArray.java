package com.dsa.array.easy;

public class _08FindSecondMaxValueInAnArray {
	public static void main(String[] args) {
		int[] arr = {9, 8, 2, 3, 6, 12, 11, 10};
		System.out.println(findSecondMaximum(arr));
	}
	public static int findSecondMaximum(int[] arr) {
		int max = arr[0], secondMax = Integer.MIN_VALUE;
		for(int i=1; i<arr.length;i++) {
			if(arr[i]>max) {
				secondMax = max;
				max = arr[i];
			} else if(arr[i]>secondMax) {
				secondMax = arr[i];
			}
		}
		return secondMax;
	}
}
