package com.dsa.array.easy;

/**
	Maximum difference between two elements such that larger element appears after the smaller number

	Given an array arr[] of integers, find out the maximum difference between any two elements such that larger element appears after the smaller number.

	Input : arr = {2, 3, 10, 6, 4, 8, 1}
	Output : 8
	Explanation : The maximum difference is between 10 and 2.
	
	Input : arr = {7, 9, 5, 6, 3, 2}
	Output : 2
	Explanation : The maximum difference is between 9 and 7.

	https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 */

public class _14MaxDiffBetweenTwoElements {

	public static void main(String[] args) {
		int arr[] = {4,3,10,2,11,1,6,12};
		maxDiffBetweenTwoElements(arr);
	}
	public static int maxDiffBetweenTwoElements(int arr[]) {
		int min=arr[0], maxDiff = Integer.MIN_VALUE, diff;
		for(int i=1; i<arr.length; i++) {
			diff = arr[i]-min;
			if(diff>maxDiff) {
				maxDiff = diff;
			}
			if(arr[i]<min) {
				min = arr[i];
			}
		}
		return maxDiff;
	}
	
	public static int maxDiffBetweenTwoElements2(int arr[]) {
		int minSoFar=arr[0], maxDiff = Integer.MIN_VALUE, diff;
		for(int i=1; i<arr.length; i++) {
			if(arr[i] < minSoFar) {
				minSoFar = arr[i];
			} else {
				diff = arr[i]-minSoFar;
				if(diff>maxDiff) {
					maxDiff = diff;
				}
			}
		}
		return maxDiff;
	}
}
