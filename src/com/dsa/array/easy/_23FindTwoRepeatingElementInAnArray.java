package com.dsa.array.easy;

import com.dsa.array.util.ArraysUtil;

public class _23FindTwoRepeatingElementInAnArray {

	public static void main(String[] args) {
		String s = "test test";
		for(Character c : s.toCharArray()) {
			s = s.concat(c.toString());
			System.out.println(c);
		}

				
		int arr[] = {2,4,2,5,4,3,1};
		repeatingElement(arr);
	}
	
	public static void repeatingElement(int arr[]) {
		int repeat[] = new int[2];
		int count=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[Math.abs(arr[i])] >= 0) {
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			} else {
				repeat[count++] = Math.abs(arr[i]);
			}
		}
		ArraysUtil.display(repeat);
	}
}
