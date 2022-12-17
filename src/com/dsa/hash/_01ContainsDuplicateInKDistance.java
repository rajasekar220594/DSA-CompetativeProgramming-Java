package com.dsa.hash;

import java.util.HashSet;

public class _01ContainsDuplicateInKDistance {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,1,2,3,4};
		containsDuplicateUsingHash(arr, 3);
	}
	
	public static void containsDuplicateUsingHash(int arr[], int k) {
		HashSet<Integer> hash = new HashSet<Integer>();
		for(int i=0; i<arr.length; i++) {
			if(hash.contains(arr[i])) {
				System.out.println("Duplicate");
				return;
			}
			hash.add(arr[i]);
			if(i >= k) { // i-k >= 0
				hash.remove(arr[i-k]);
			}
		}
		System.out.println("No Duplicate");
	}

}
