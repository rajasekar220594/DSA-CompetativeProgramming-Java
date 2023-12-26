package com.dsa.recursion.easy;

import com.dsa.array.util.ArraysUtil;

public class _06ReverseAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,2};
		//ArraysUtil.display(reverseAnArrayWithoutRecurssion(arr));
		//ArraysUtil.display(reverseAnArrayWithRecurssion(arr, 0, arr.length-1));
		//reverseAnArrayWithRecurssion1(arr, 0, arr.length-1);
		reverseAnArrayWithRecurssion2(arr,0);
		ArraysUtil.display(arr);
	}
	
	public static int[] reverseAnArrayWithoutRecurssion(int arr[]) {
		int startIndex=0, endIndex=arr.length-1;
		while(startIndex<endIndex) {
			ArraysUtil.swap(arr, startIndex++, endIndex--);
		}
		return arr;
	}
	
	public static int[] reverseAnArrayWithRecurssion(int arr[], int startIndex, int endIndex) {
		if(startIndex>=endIndex) {
			return arr;
		} else {
			ArraysUtil.swap(arr, startIndex++, endIndex--);
			return reverseAnArrayWithRecurssion(arr, startIndex, endIndex);
		}
	}
	public static void reverseAnArrayWithRecurssion1(int arr[], int startIndex, int endIndex) {
		if(startIndex>=endIndex) {
			return;
		} else {
			ArraysUtil.swap(arr, startIndex++, endIndex--);
			reverseAnArrayWithRecurssion(arr, startIndex, endIndex);
		}
	}
	
	public static void reverseAnArrayWithRecurssion2(int arr[], int startIndex) {
		if(startIndex>=arr.length/2) {
			return;
		} else {
			int endIndex = arr.length-startIndex-1;
			ArraysUtil.swap(arr, startIndex++, endIndex);
			reverseAnArrayWithRecurssion2(arr, startIndex);
		}
	}

}
