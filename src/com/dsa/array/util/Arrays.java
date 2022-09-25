package com.dsa.array.util;

/**
 * @author rajasekar
 * Array Utility class
 */

public class Arrays {
	
	public static void display(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] +" ");
		}
	}

	public static void swap(int arr[], int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
