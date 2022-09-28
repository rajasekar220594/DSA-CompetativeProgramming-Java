package com.dsa.array.util;

/**
	Array Utility class
 */

public class Arrays {
	
	public static void display(int arr[]) {
		if(arr == null || arr.length < 1) return;
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] +" ");
		}
		System.out.println("");
	}

	public static void swap(int arr[], int index1, int index2) {
		if(arr == null || arr.length < 1) return;
		
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	public static void sort(int arr[]) {
		if(arr == null || arr.length < 1) return;
		
		java.util.Arrays.sort(arr);
	}
}
