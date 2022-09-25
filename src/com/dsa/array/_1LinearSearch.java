package com.dsa.array;

public class _1LinearSearch {
	public static void main(String[] args) {
		int arr[] = {7,5,9,2,10};
		System.out.println(linearSearchUsingForLoop(arr, 2));
		System.out.println(linearSearchUsingWhileLoop(arr, 2));
		System.out.println(linearSearchUsingWhileLoopWithTwoPointers(arr, 32));
	}
	public static int linearSearchUsingForLoop(int arr[], int target) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == target) {
				return i;
			}
		}
		return -1;
	}
	
	public static int linearSearchUsingWhileLoop(int arr[], int target) {
		int i=0;
		while(i<arr.length) {
			if(arr[i] == target) {
				return i;
			}
			i++;
		}
		return -1;
	}
	public static int linearSearchUsingWhileLoopWithTwoPointers(int arr[], int target) {
		int startIndex = 0, endIndex = arr.length-1;
		while(startIndex <= endIndex) {
			if(arr[startIndex] == target) {
				return startIndex;
			}
			if(arr[endIndex] == target) {
				return endIndex;
			}
			startIndex++;
			endIndex--;
		}
		return -1;
	}
	
}
