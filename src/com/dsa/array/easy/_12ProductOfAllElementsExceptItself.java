package com.dsa.array.easy;

import com.dsa.array.util.ArraysUtil;

public class _12ProductOfAllElementsExceptItself {

	public static void main(String[] args) {
		int[] arr = {2,3,4,5};
		ArraysUtil.display(findProduct(arr));

	}
	public static int[] findProductUsingBruteForceApproach(int arr[]) {    
		int[] result = new int[arr.length];
		int product;
		for(int i=0; i<arr.length; i++) {
			product = 1;
			for(int j=0; j<arr.length; j++) {
				if(i != j) {
					product = product*arr[j];
				}
			}
			result[i] = product;
		}
		return result; 
	} 
	public static int[] findProductUsingDivideOperator(int arr[]) {
		// This method work only integers and without zero
		int product = 1, i=0;
		for(i=0; i<arr.length; i++) {
			product = product*arr[i];
		}
		for(i=0; i<arr.length; i++) {
			arr[i] = product/arr[i];
		}
		return arr;
	}

	public static int[] findProductUsingAdditionalPointers(int arr[]) {
		int length = arr.length;
		int[] arrLeftProduct = new int[length];
		int[] arrRightProduct = new int[length];
		int leftIndex =0, leftProduct=1, rightIndex = length-1, rightProduct=1;
		while(leftIndex<length && rightIndex>=0) {
			leftProduct = arr[leftIndex]*leftProduct;
			arrLeftProduct[leftIndex++] = leftProduct;
			rightProduct = arr[rightIndex]*rightProduct;
			arrRightProduct[rightIndex--] = rightProduct;
		}
		arr[0] = arrRightProduct[1];
		arr[length-1] = arrLeftProduct[length-2];
		for(int i=1; i<arr.length-1; i++) {
			int temp = arrLeftProduct[i-1]*arrRightProduct[i+1];
			arr[i] = temp;
		}

		return arr;
	}

	public static int[] findProduct(int arr[]) { 
		int n = arr.length;
		int i, temp = 1; 
		// Initializing temp to 1 because from left side no element so it's start from one
		// Initializing temp to 1 for product on left side
		// Allocation of result array
		int result[] = new int[n]; 

		// Product of elements on left side excluding arr[i]
		for (i = 0; i < n; i++) { 
			result[i] = temp; 
			temp = temp * arr[i]; 
		} 

		// Initializing temp to 1 for product on right side
		temp = 1; 

		// Product of elements on right side excluding arr[i] 
		for (i = n - 1; i >= 0; i--) { 
			result[i] = result[i] * temp; 
			temp = temp * arr[i]; 
		}

		return result; 
	} 
}
