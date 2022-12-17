package com.dsa.array.easy;

/**
	Given an array of size unknown with all 0’s in the beginning and 1’s in the end. Find the starting index of 1?
	
	We don’t know the size so we can’t apply binary search directly.
	We can use linear search to solve this problem or we can incrementing loop value and search.
	
 */
public class _17BeginningIndexOf1WithUnknownSize {

	public static void main(String[] args) {
		int arr[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
		System.out.println(findFirstIndexOf1UsingLinearApproach(arr));
		System.out.println(findFirstIndexOf1UsingAddIncrApproach(arr, 2));
		System.out.println(findFirstIndexOf1UsingMulIncrApproachWithBS(arr, 2));
	}
	
	public static int findFirstIndexOf1UsingLinearApproach(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 1) return i;
		}
		return -1;
	}
	public static int findFirstIndexOf1UsingAddIncrApproach(int arr[], int increment) {
		int index=0;
		for(;index<arr.length; index=index+increment) {
			if(arr[index]==1) break;
		}
		int left_index = index - increment, right_index = index;
		for(; left_index<=right_index; left_index++) {
			if(arr[left_index] == 1) return left_index;
		}
		return -1;
	}
	
	public static int findFirstIndexOf1UsingMulIncrApproachWithBS(int arr[], int increment) {
		if(arr[0] == 1) return 0;
		int l_index=1, r_index=0, mid_index;
		for(int i=1; i<arr.length; i=i*increment) {
			if(arr[i] == 0) {
				l_index=i;
				r_index=i*increment;
			} else {
				r_index=i;
				break;
			}
		}
		//Binary Search
		while(l_index<r_index) {
			mid_index = (l_index+r_index)/2;
			if(arr[mid_index] == 1 && arr[mid_index-1] == 0) {
				return mid_index;
			} else if(arr[mid_index] == 0) {
				l_index = mid_index+1;
			} else {
				r_index = mid_index-1;
			}
		}
		return -1;
	}
}
