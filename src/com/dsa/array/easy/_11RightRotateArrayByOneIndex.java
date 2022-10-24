package com.dsa.array.easy;

import com.dsa.array.util.ArraysUtil;

public class _11RightRotateArrayByOneIndex {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		ArraysUtil.display(rotateArray(arr));
	}

	public static int[] rotateArray(int[] arr) {
		int temp = arr[arr.length-1];
		for(int i = arr.length-1; i>0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
		return arr;
	}
}
