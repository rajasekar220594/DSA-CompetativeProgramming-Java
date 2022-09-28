package com.dsa.array;

import com.dsa.array.util.Arrays;

/**
	Count smaller elements on right side

	Write a function to count number of smaller elements on right of each element in an array. 
	Given an unsorted array arr[] of distinct integers, construct another array countSmaller[] such that countSmaller[i] 
	contains count of smaller elements on right side of each element arr[i] in array.

	Input:   arr[] =  {12, 1, 2, 3, 0, 11, 4}
	Output:  countSmaller[]  =  {6, 1, 1, 1, 0, 1, 0} 
	
	(Corner Cases)
	Input:   arr[] =  {5, 4, 3, 2, 1}
	Output:  countSmaller[]  =  {4, 3, 2, 1, 0} 
	
	Input:   arr[] =  {1, 2, 3, 4, 5}
	Output:  countSmaller[]  =  {0, 0, 0, 0, 0}
	
	https://www.geeksforgeeks.org/count-smaller-elements-on-right-side/
 */

public class _13CountNoOfSmallerElementonRightSide {

	public static void main(String[] args) {
		int arr[] =  {12, 1, 2, 3, 0, 11, 4};
		countNoOfSmallerElementonRightSideUsingTwoLoop(arr);
		
		int arr1[] =  {5, 4, 3, 2, 1};
		countNoOfSmallerElementonRightSideUsingTwoLoop(arr1);
		
		int arr2[] =  {1, 2, 3, 4, 5};
		countNoOfSmallerElementonRightSideUsingTwoLoop(arr2);
	}
	
	public static int[] countNoOfSmallerElementonRightSideUsingTwoLoop(int arr[]) {
		int res[] = new int[arr.length];
		int count;
		for(int i=0; i<arr.length-1; i++) {
			count = 0;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] > arr[j]) {
					count++;
				}
			}
			res[i] = count;
		}
		Arrays.display(res);
		return res;
	}
}
