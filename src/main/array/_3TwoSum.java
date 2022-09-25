package main.array;

import java.util.HashMap;
import java.util.Map;

/** Find a pair in an array whose sum is equal to given number */
public class _3TwoSum {
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		usingHashingTechnique(arr, 5);
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
}
