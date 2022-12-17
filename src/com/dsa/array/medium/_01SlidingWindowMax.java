package com.dsa.array.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
	Sliding Window Maximum (Maximum of all subarrays of size K)
	
	Given an array and an integer K, find the maximum for each and every contiguous subarray of size K.

	Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3 
	Output: 3 3 4 5 5 5 6
	Explanation: Maximum of 1, 2, 3 is 3
	             Maximum of 2, 3, 1 is 3
	             Maximum of 3, 1, 4 is 4
	             Maximum of 1, 4, 5 is 5
	             Maximum of 4, 5, 2 is 5 
	             Maximum of 5, 2, 3 is 5
	             Maximum of 2, 3, 6 is 6
	
	Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4 
	Output: 10 10 10 15 15 90 90
	Explanation: Maximum of first 4 elements is 10, similarly for next 4 
	             elements (i.e from index 1 to 4) is 10, So the sequence 
	             generated is 10 10 10 15 15 90 90

	https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 */
public class _01SlidingWindowMax {
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		slidingWindowMaxUsingTwoLoop(arr, 3);
		
		int arr1[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		slidingWindowMaxUsingTwoLoop(arr1, 4);
		
		int arr2[] = {10, 4, 5, 11, 3, 15, 12, 8, 7, 9, 21, 14};
		slidingWindowMaxUsingLinkedListQueue(arr2, 3);
	}
	
	public static void slidingWindowMaxUsingTwoLoop(int arr[], int k) {
		int max;
		for(int i=0; i<=arr.length-k; i++) {
			max=arr[i];
			for(int j=i+1; j<k+i; j++) {
				if(arr[j] > max) {
					max = arr[j];
				}
			}
			System.out.print(max +" ");
		}
	}
	
	public static void slidingWindowMaxUsingLinkedListQueue(int arr[], int k) {
		// Input: 10 4 5 11 3 15
		Deque<Integer> Qi = new LinkedList<>();
		int i=0;
		for(; i<k; i++) { 
			while(!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()]) {
				Qi.removeLast(); // 1
			}
			Qi.addLast(i); // 0 1 -> 0 2
		}
		
		for(; i<arr.length; i++) {

			System.out.print(arr[Qi.peek()] + " "); // 10 11 11 15
			
			while ((!Qi.isEmpty()) && Qi.peek() <= i - k)
                Qi.removeFirst(); // 0
			
			while(!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()]) {
				Qi.removeLast(); // 2 -> 4 3
			}
			Qi.addLast(i); // 3 4 -> 5
			
		}
		
		System.out.print(arr[Qi.peek()]);
		
	}
}
