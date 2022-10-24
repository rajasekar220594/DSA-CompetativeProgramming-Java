package com.dsa.array.easy;

import com.dsa.array.util.ArraysUtil;

public class _07MergeTwoSortedArray {
	public static void main(String[] args) {
		int[] arr1 = {1, 3, 4, 5};
		int[] arr2 = {2, 6, 7, 8};
		ArraysUtil.display(mergeArrays(arr1, arr2));
	}

	public static int[] mergeArrays(int[] arr1, int[] arr2) {  
		int newArray[] = new int[arr1.length+arr2.length];
		int i=0,j=0,k=0;
		while(i < arr1.length && j <arr2.length) {
			if(arr1[i]<arr2[j]) {
				newArray[k++] = arr1[i++]; 
			} else {
				newArray[k++] = arr2[j++]; 
			}
		}
		while(i<arr1.length) {
			newArray[k++] = arr1[i++];
		}
		while(j<arr2.length) {
			newArray[k++] = arr2[j++];
		}
		return newArray; 
	} 
}
