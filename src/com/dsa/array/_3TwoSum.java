package com.dsa.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 *  Given an array A[] and a number x, check for pair in A[] with sum as x (aka Two Sum)
 *  Write a program that, given an array A[] of n numbers and another number x, determines whether or not there exist two elements in A[] whose sum is exactly x. 
 *  Find a pair in an array whose sum is equal to given number
 *  https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
 */

public class _3TwoSum {
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		usingHashingTechnique(arr, 5);
	}
	
	public static void usingTwoLoop(int arr[], int target) {
		for(int i=0; i<arr.length; i++) {
			for(int j=1; j<arr.length; j++) {
				if(arr[i]+arr[j]==target) {
					System.out.println(arr[i]+" "+arr[j]);
				}
			}
		}
	}
	
	public static void usingHashingTechnique(int arr[], int target) {
		Map<Integer, Integer> hash = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			if(hash.containsKey(target-arr[i])) {
				System.out.println(arr[i]+" "+(target-arr[i]));
			}
			hash.put(arr[i], null);
		}
	}
}
