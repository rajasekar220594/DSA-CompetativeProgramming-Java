package com.dsa.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.dsa.array.util.ArraysUtil;

/**
 * 
    Given an array A[] and a number x, check for pair in A[] with sum as x (aka Two Sum)
   
    Write a program that, given an array A[] of n numbers and another number x, determines whether or not there exist two elements 
    in A[] whose sum is exactly x.
   
    Find a pair in an array whose sum is equal to given number
   
    Input: arr[] = {0, -1, 2, -3, 1}
        x= -2
	Output: Pair with a given sum -2 is (-3, 1)
	              Valid pair exists
	Explanation:  If we calculate the sum of the output,1 + (-3) = -2
	
	Input: arr[] = {1, -2, 1, 0, 5}
	       x = 0
	Output: No valid pair exists for 0
	
    https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
 */

public class _04TwoSum {
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		usingSortingTechnique(arr, 5);
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
	
	public static void usingSortingTechnique(int arr[], int target) {
		Arrays.sort(arr);
		int l_index=0, r_index=arr.length-1,sum;
		while(l_index<r_index) {
			sum=arr[l_index]+arr[r_index];
			if(sum == target) {
				System.out.println(arr[l_index++]+" "+arr[r_index--]);
			} else if(target<sum) {
				r_index--;
			} else {
				l_index++;
			}
		}
	}
}
