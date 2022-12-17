package com.dsa.hash;

import java.util.HashMap;

public class _02CountDistinctElementsInAllWindows {

	public static void main(String[] args) {
		int arr[] = {10,10,10,30,30,40,10};
		countDistinctElementsInAllWindowsUsingHash(arr, 3);
	}
	public static void countDistinctElementsInAllWindowsUsingHash(int arr[], int k) {
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		int distinct = 0, i=0, key, value;
		for(; i<k; i++) {
			key = arr[i];
			if(hash.containsKey(key)) {
				value = hash.get(key);
				if(value == 0) {
					hash.put(key, value+1);
					distinct++;
				} else {
					hash.put(key, value-1);
					distinct--;
				}
			} else {
				hash.put(key, 1);
				distinct++;
			}
		}
		System.out.print(distinct+" ");
		
		for(; i<arr.length; i++) {
			// Delete
			value = hash.get(arr[i-k]);
			key = arr[i-k];
			if(value == 0) {
				hash.put(key, value+1);
				distinct++;
			} else {
				hash.put(key, value-1);
				distinct--;
			}

			//add
			key = arr[i];
			if(hash.containsKey(key)) {
				value = hash.get(arr[i]);
				if(value == 0) {
					hash.put(key, value+1);
					distinct++;
				} else {
					hash.put(key, value-1);
					distinct--;
				}
			} else {
				hash.put(key, 1);
				distinct++;
			}
			System.out.print(distinct+" ");
		}
	}
}
