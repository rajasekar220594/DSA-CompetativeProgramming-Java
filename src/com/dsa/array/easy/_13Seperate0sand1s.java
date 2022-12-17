package com.dsa.array.easy;

import com.dsa.array.util.ArraysUtil;

/**
	You are given an array of 0s and 1s in random order. Segregate 0s on left side and 1s on right side of the array [Basically you have to sort the array]. Traverse array only once. 
	
	Input array   =  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0] 
	
	Output array =  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1] 
	
	https://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/
 */

public class _13Seperate0sand1s {
	public static void main(String[] args) {
		int arr[] = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
		usingCountApproach(arr);
		//usingTwoPointers(arr);
	}
	public static void usingCountApproach(int arr[]) {
		int count = 0, i=0;
		for(; i<arr.length; i++) {
			if(arr[i] == 0) count++;
		}
		i=0;
		for(; i<count; i++) {
			arr[i] = 0;
		}
		for(; i<arr.length; i++) {
			arr[i] = 1;
		}
		ArraysUtil.display(arr);
	}
	
	public static void usingTwoPointers(int arr[]) {
		int l_index = 0, r_index = arr.length-1;
		while(l_index<r_index) {
			while(arr[l_index]==0) {
				l_index++;
			}
			while(arr[r_index] == 1) {
				r_index--;
			}
			if(l_index<r_index) {
				ArraysUtil.swap(arr, l_index++, r_index--);
				//l_index++;
				//r_index--;
			}
		}
		ArraysUtil.display(arr);
	}
}
