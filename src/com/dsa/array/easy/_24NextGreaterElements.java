package com.dsa.array.easy;

import java.util.HashMap;
import java.util.Map;

public class _24NextGreaterElements {

	public static void main(String[] args) {
		nextGreaterElement(new int[] {1,3,5,2,4}, new int[] {6,5,4,3,2,1,7});
	}
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Map<Integer, Integer> hash = new HashMap<>();
		int i=nums2.length-2, temp=nums2[nums2.length-1];
		for(; i>=0; i--) {
			
			hash.put(nums2[i], i);
		}
		for(i=0; i<nums1.length; i++) {
			if(hash.containsKey(nums1[i])) {
				temp = hash.get(nums1[i])+1;
				if(temp >= nums2.length || nums1[i] > nums2[temp]) {
					nums1[i] = -1;
				} else {
					nums1[i] = nums2[temp];
				}
			} else {
				nums1[i] = -1;
			}
		}
		return nums1;
	}
}
