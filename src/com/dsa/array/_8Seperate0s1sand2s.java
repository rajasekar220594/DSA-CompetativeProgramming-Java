package com.dsa.array;

import com.dsa.array.util.Arrays;

/**
 * Sort an array of 0s, 1s and 2s | Dutch National Flag problem
 * Given an array arr[] consisting of only 0s, 1s, and 2s. The task is to write a function that sorts the given array. The functions should put all 0s first, then all 1s and all 2s in last.
 * https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 */

public class _8Seperate0s1sand2s {
	public static void main(String[] args) {
		int arr[] = {0,1,2,0,1,2};
		usingThreePointer(arr);
	}
	
	public static void usingCountApproach(int arr[]) {
		int zeroCount = 0, oneCount = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 0) zeroCount++;
			if(arr[i] == 1) oneCount++;
		}
		int i = 0;
		for(; i<zeroCount; i++) {
			arr[i] = 0;
		}
		for(; i<zeroCount+oneCount; i++) {
			arr[i] = 1;
		}
		for(; i<arr.length; i++) {
			arr[i] = 2;
		}
		
		Arrays.display(arr);
	}
	
	public static void usingThreePointer(int arr[]) {
		int lo = 0;
        int hi = arr.length - 1;
        int mid = 0, temp = 0;
        // Iterate till all the elements
        // are sorted
        while (mid <= hi) {
            switch (arr[mid]) {
                // If the element is 0
            case 0: {
                temp = arr[lo];
                arr[lo] = arr[mid];
                arr[mid] = temp;
                lo++;
                mid++;
                break;
            }
                // If the element is 1
            case 1:
                mid++;
                break;
                // If the element is 2
            case 2: {
                temp = arr[mid];
                arr[mid] = arr[hi];
                arr[hi] = temp;
                hi--;
                break;
            }
            }
        }
        Arrays.display(arr);
	}
}
