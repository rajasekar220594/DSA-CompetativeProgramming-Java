package com.dsa.array.easy;

/** 
 	Given an sorted array A of size n, find an element that occurs more than n/2 times
 	
	Find the majority element in the array. A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element). 
	
	Input : {3, 3, 4, 2, 4, 4, 2, 4, 4}
	Output : 4
	Explanation: The frequency of 4 is 5 which is greater than the half of the size of the array size. 
	
	Input : {3, 3, 4, 2, 4, 4, 2, 4}
	Output : No Majority Element
	Explanation: There is no element whose frequency is greater than the half of the size of the array size.
	
	https://www.geeksforgeeks.org/majority-element/
 */
public class _06MajorityElement {
	public static void main(String[] args) {
		int arr[] = {1,1,2,3,4,1,1,1,5};
		System.out.println(moreVotingAlgo(arr));
	}
	public static int findMajorityElement(int arr[]) {
		int n = (arr.length/2)+1;
		for(int i=0; i<arr.length; i++) {
			int temp = i+(n-1);
			if(temp < arr.length && arr[i] == arr[temp]) {
				return arr[i];
			}
		}
		return -1;
	}
	
	public static int moreVotingAlgo(int arr[]) {
		int majorityElement = arr[0], count =1;
		for(int i=1; i<arr.length; i++) {
			if(count == 0) {
				majorityElement = arr[i];
			}
			if(arr[i] == majorityElement) {
				count++;
			} else {
				count--;
			}
		}
		
		int n = (arr.length/2)+1;
		count=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == majorityElement) {
				count++;
			}
			if(count>=n) {
				return majorityElement;
			}
		}
		if(count>=n) {
			return majorityElement;
		}
		return -1;
	}
}
