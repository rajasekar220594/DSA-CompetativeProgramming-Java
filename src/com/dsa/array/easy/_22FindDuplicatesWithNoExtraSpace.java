package com.dsa.array.easy;

public class _22FindDuplicatesWithNoExtraSpace {

	public static void main(String[] args) {
		int arr[] = {4,3,1,1,2,2,3,4};
		printRepeating(arr);
	}

	public static void printRepeating(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			if(arr[Math.abs(arr[i])] < 0) {
				System.out.println(Math.abs(arr[i]));
			} else {
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			}
		}
	}

}
