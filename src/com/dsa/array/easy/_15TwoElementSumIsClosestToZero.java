package com.dsa.array.easy;

import java.util.Arrays;

import com.dsa.array.util.ArraysUtil;

/**
	Two elements whose sum is closest to zero
	An Array of integers is given, both +ve and -ve. You need to find the two elements such that their sum is closest to zero.
	https://www.geeksforgeeks.org/two-elements-whose-sum-is-closest-to-zero/
 */

public class _15TwoElementSumIsClosestToZero {

	public static void main(String[] args) {
		int arr[] = {0, 59, -9, 69, -79, 84 ,85};
		closestToZero(arr);
		closestToZeroSingleNo();
	}
	
	public static void closestToZeroSingleNo() {
		int[] arr = {1,4,5,6,7,-1};

		int closestIndex = 0;
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
		    int abs = Math.abs(arr[i]);
		    if (abs < diff) {
		        closestIndex = i;
		        diff = abs;
		    } else if (abs == diff && arr[i] > 0 && arr[closestIndex] < 0) {
		        //same distance to zero but positive 
		        closestIndex =i;
		    }
		}   
		System.out.println(arr[closestIndex ]);
	}
	public static void closestToZero(int arr[]) {
		Arrays.sort(arr);
		int l_index = 0, r_index = arr.length-1;
		int closest=arr[l_index]+arr[r_index], a = arr[l_index], b = arr[r_index], current;
		
		while(l_index<r_index) {
			current = arr[l_index]+arr[r_index];
			if(Math.abs(current) < Math.abs(closest)) {
				closest = current;
				a = arr[l_index];
				b = arr[r_index];
			}
			
			if(current == 0) {
				System.out.println("Found");
				break;
			} else if(current > 0) {
				r_index--;
			} else {
				l_index++;
			}
		}
		System.out.println(a+" "+b);
	}
}
