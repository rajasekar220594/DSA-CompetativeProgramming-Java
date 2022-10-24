package com.dsa.array.easy;

import com.dsa.array.util.ArraysUtil;

public class _20RearrangeSortedArrayInMaxMinForm {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5,6,7,8};
		ArraysUtil.display(maxMin(arr));
	}
	public static int[] maxMinUsingExtraSpace(int[] arr) {
		int newArray[] = new int[arr.length];
		int index=0;
		for(int i=0, j=arr.length-1; i<=j; i++,j--) {
			if(i==j) {
				newArray[index] = arr[i];
			} else {
				newArray[index++] = arr[j];
				newArray[index++] = arr[i];
			}
		}
		for(int i=0; i<arr.length; i++) {
			arr[i] = newArray[i];
		}
		return newArray;
	}
	public static int[] maxMin(int[] arr) {
		int maxIdx = arr.length - 1;
		int minIdx = 0;
		int maxElem = arr[maxIdx] + 1; // store any element that is greater than the maximum element in the array 
		for( int i = 0; i < arr.length; i++) {
			// at even indices we will store maximum elements
			if (i % 2 == 0){  
				arr[i] += (arr[maxIdx] % maxElem ) * maxElem;
				maxIdx -= 1;
			}
			else { // at odd indices we will store minimum elements
				arr[i] += (arr[minIdx] % maxElem ) * maxElem;
				minIdx += 1;
			}
		}
		// dividing with maxElem to get original values.
		for( int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] / maxElem;
		}
		return arr;
	}
}
