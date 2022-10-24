package com.dsa.array.easy;

import java.util.HashMap;
import java.util.Map;

public class _09FindFirstNotRepeatingIntegerInAnArray {

	public static void main(String[] args) {
		int[] arr = {9, 2, 3, 2, 6, 6};
		System.out.println(findFirstUnique(arr));
	}
	
	public static int findFirstUnique(int[] arr) {
		int result = 0;
		Map<Integer, Integer> hash = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			if(hash.containsKey(arr[i])) {
				hash.put(arr[i], hash.get(arr[i])+1);
			} else {
				hash.put(arr[i], 1);
			}
		}
		for(int i=0; i<arr.length; i++) {
			if(hash.containsKey(arr[i]) && hash.get(arr[i]) == 1) {
				return arr[i];
			}
		}
		return result;
	}
}
