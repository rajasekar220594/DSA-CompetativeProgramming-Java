package com.dsa.array.easy;

import com.dsa.array.util.ArraysUtil;

/**
	Find a triplet that sum to a given value
	Given an array and a value, find if there is a triplet in array whose sum is equal to the given value. 
	If there is such a triplet present in array, then print the triplet and return true. Else return false.

	Input: array = {12, 3, 4, 1, 6, 9}, sum = 24; 
	Output: 12, 3, 9 
	Explanation: There is a triplet (12, 3 and 9) present 
	in the array whose sum is 24. 
	Input: array = {1, 2, 3, 4, 5}, sum = 9 
	Output: 5, 3, 1 
	Explanation: There is a triplet (5, 3 and 1) present 
	in the array whose sum is 9.
 */

public class _05Triplet {
	public static void main(String[] args) {
		int arr[] = {0,3,44,5,9,7};
		usingSortingTechnique2(arr, 63);
	}
	
	public static void usingSortingTechnique(int arr[], int target) {
		ArraysUtil.sort(arr);
		
		int sum;
		for(int i=0; i<arr.length-2; i++) {
			int l_index=i+1, r_index=arr.length-1;
			while(l_index<r_index) {
				sum = arr[i]+arr[l_index]+arr[r_index];
				if(sum == target) {
					System.out.println(arr[i]+" "+arr[l_index++]+" "+arr[r_index--]);
				} else if(target < sum) {
					r_index--;
				} else {
					l_index++;
				}
			}
		}
	}
	public static void usingSortingTechnique2(int arr[], int target) {
		ArraysUtil.sort(arr);
		
		int result;
		for(int i=0; i<arr.length-2; i++) {
			result = target - (arr[i]+arr[i+1]);
			//Binary Search
			int startIndex = i+2, endIndex = arr.length-1, midIndex;
			while(startIndex <= endIndex) {
				midIndex = (startIndex + endIndex)/2;
				if(arr[midIndex] == result) {
					System.out.println(arr[i]+" "+arr[i+1]+" "+arr[midIndex]);
					break;
				} else if(arr[midIndex] < result) {
					startIndex = midIndex+1;
				} else {
					endIndex = midIndex-1;
				}
			}
		}
	}
}
