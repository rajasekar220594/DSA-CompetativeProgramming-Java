package com.dsa.array.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
	Find the Number Occurring Odd Number of Times

	Given an array of positive integers. All numbers occur an even number of times except one number which occurs an odd number of times. Find the number in O(n) time & constant space.
	
	Input : arr = {1, 2, 3, 2, 3, 1, 3}
	Output : 3
	
	Input : arr = {5, 7, 2, 7, 5, 2, 5}
	Output : 5

	https://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/
 */
public class _10FindNoOccuringOddNoofTimesInanArray {
	public static void main(String[] args) {
		int arr[] = {3,2,1,2,3,1,1};
		System.out.println(getOddOccurrenceUsingXOR(arr));
	}
	
	public static int oddNoOfTimesInAnArray(int arr[]) {
		Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for(int i=0; i<arr.length; i++) {
			if(hash.containsKey(arr[i])) {
				hash.put(arr[i], hash.get(arr[i])+1);
			} else {
				hash.put(arr[i], 1);
			}
		}
		for(Map.Entry<Integer, Integer> entry : hash.entrySet()) {
			if(entry.getValue()%2 != 0) {
				System.out.println(entry.getKey());
			}
		}
		return -1;
	}
	
	public static int getOddOccurrenceUsingXOR(int arr[])
	{
		int res = 0;
		for (int i = 0; i < arr.length; i++)
		{
			res = res ^ arr[i];
		}
		return res;
	}
}
