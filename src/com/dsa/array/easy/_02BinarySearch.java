package com.dsa.array.easy;

/**
 * Binary Search
   Problem: Given a sorted array arr[] of n elements, write a function to search a given element x in arr[] and return the index of x in the array.
   Consider array is 0 base index.
   
   Input: arr[] = {10, 20, 30, 50, 60, 80, 110, 130, 140, 170}, x = 110
   Output: 6
   Explanation: Element x is present at index 6. 
   Input: arr[] = {10, 20, 30, 40, 60, 110, 120, 130, 170}, x = 175
   Output: -1
   Explanation: Element x is not present in arr[].
 */

public class _02BinarySearch {
	public static void main(String[] args) {
		int arr[] = {2,5,8,12,16,23,38,50,72,91};
		//System.out.println(binarySearch(arr, 38));
		System.out.println(recursiveBinarySearch(arr, 38, 0, arr.length-1));
	}
	public static int binarySearch(int arr[], int target) {
		int startIndex = 0, endIndex = arr.length-1, midIndex;
		while(startIndex <= endIndex) {
			midIndex = (startIndex + endIndex)/2;
			if(arr[midIndex] == target) {
				return midIndex;
			} else if(arr[midIndex] < target) {
				startIndex = midIndex+1;
			} else {
				endIndex = midIndex-1;
			}
		}
		return -1;
	}
	
	public static int recursiveBinarySearch(int arr[], int target, int startIndex, int endIndex) {
		if(startIndex<=endIndex) {
			int midIndex = (startIndex+endIndex)/2;
			if(arr[midIndex] == target) {
				return midIndex;
			}  else if(arr[midIndex] < target) {
				startIndex = midIndex+1;
			} else {
				endIndex = midIndex-1;
			}
			return recursiveBinarySearch(arr, target, startIndex, endIndex);
		}
		return -1;
	}
}
