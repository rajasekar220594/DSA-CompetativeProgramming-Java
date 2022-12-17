package com.dsa.array.easy;

import java.util.HashMap;

public class _21FindSumOfSubarrayEqualToGivenValueX {

	public static void main(String[] args) {
		int arr[] = {5,4,6,7,9,8,3,1,2,60};
		subArraySumUsingTwoPointers(arr, 62);
	}
	
	public static void subArraySumUsingTwoLoop(int arr[], int sum) {
		int currentSum;
		for(int i=0; i<arr.length; i++) {
			currentSum = arr[i];
			if (currentSum == sum) {
                System.out.println("Sum found at indexe "+ i);
                return;
            }
			for(int j=i+1; j<arr.length; j++) {
				currentSum += arr[j];
				if(currentSum == sum) {
					System.out.println("Sum found between indexes " + i + " and " + j);
                        return;
				}
			}
		}
	}

	public static void subArraySumUsingTwoPointers(int arr[], int sum) {
		int left=0, right=1, currentSum = arr[0];
		while(left<=right && left>=0 && right<arr.length) {
			if(arr[right] == sum) {
				System.out.println("Sum found at indexe "+ right);
                return;
			}
			if(currentSum == sum) {
				System.out.println("Sum found between indexes " + left + " and " + right);
				return;
			} 
			if(currentSum < sum) {
				currentSum += arr[right++];
			} 
			if(currentSum > sum){
				currentSum -= arr[left++];
			}
		}
	}
	
	public static void subArraySum(int[] arr, int n,  int sum) {
		// cur_sum to keep track of cumulative sum till that point
		int cur_sum = 0, start = 0, end = -1;
		HashMap<Integer, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			cur_sum = cur_sum + arr[i];
			// check whether cur_sum - sum = 0, if 0 it  means the sub array is starting from index 0 - so stop
			if (cur_sum - sum == 0) {
				start = 0;
				end = i;
				break;
			}
			// if hashMap already has the value, means we already  have subarray with the sum - so stop
			if (hashMap.containsKey(cur_sum - sum)) {
				start = hashMap.get(cur_sum - sum) + 1;
				end = i;
				break;
			}
			// if value is not present then add to hashmap
			hashMap.put(cur_sum, i);
		}
		// if end is -1 : means we have reached end without  the sum
		if (end == -1) {
			System.out.println("No subarray with given sum exists");
		}
		else {
			System.out.println("Sum found between indexes "+ start + " to " + end);
		}
	}
}
