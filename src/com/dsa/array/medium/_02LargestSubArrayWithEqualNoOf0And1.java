package com.dsa.array.medium;

import java.util.HashMap;

public class _02LargestSubArrayWithEqualNoOf0And1 {

	public static void main(String[] args) {
		int arr[] = {0,1,1,0,1,0};
		maxSubArray(arr, arr.length);
		
		int arr1[] = {0,1,1,0,1,1};
		maxSubArray(arr1, arr1.length);
		
		int arr2[] = {1,1,1,1};
		maxSubArray(arr2, arr2.length);
	}
	
	public static int maxSubArray(int arr[], int n) {
		// Creates an empty hashMap hM
		// Key is sum and value is start index
		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

		// Initialize sum of elements
		int sum = 0;

		// Initialize result
		int max_len = -1;
		int ending_index = -1;
		int start_index = 0;
		
		/* Changing array where 0 = -1
		for (int index = 0; index < n; index++) {
			arr[index] = (arr[index] == 0) ? -1 : 1;
		}*/
		
		// Traverse through the given array
		for (int index = 0; index < n; index++) {
			
			// Add current element to sum
			// sum += arr[index]; if we modified array
			sum += (arr[index] == 0) ? -1 : 1;
			
			// To handle sum=0 at last index
			if (sum == 0) {
				max_len = index + 1;
				start_index = 0;
				ending_index = index;
			}
			// If this sum is seen before, then update max_len if required
			if (hM.containsKey(sum)) {
				if (max_len < index - hM.get(sum)) {
					max_len = index - hM.get(sum);
					start_index = hM.get(sum)+1;
					ending_index = index;
				}
			}
			else // Else put this sum in hash table
			hM.put(sum, index);
		}
		
		/* Change back to same array
		for (int index = 0; index < n; index++) {
			arr[index] = (arr[index] == -1) ? 0 : 1;
		}*/

		if(max_len == -1) {
			System.out.println("No such subarray");
		} else {
			int start = ending_index - max_len + 1;
			System.out.println(start_index+" Start "+start + " to " + ending_index);
		}
		return max_len;
	}
	
}
