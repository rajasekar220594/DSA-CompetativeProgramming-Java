package com.dsa.array;

public class _2BinarySearch {
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
