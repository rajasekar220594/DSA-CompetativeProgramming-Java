package com.dsa.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dsa.array.util.ArraysUtil;

public class _11RightRotateArray {
	public static void main(String[] args) {
		System.out.println(-4*-4);
		ArraysUtil.display(rotateRightArrayByOne(new int[] {1,2,3,4,5}));
		ArraysUtil.display(rotateLeftArrayByOne(new int[] {1,2,3,4,5}));
		ArraysUtil.display(rotateArrayByNElement(new int[] {1,2,3,4,5},2));
		
		int[] arr = {1,10,20,0,59,86,32,11,9,40};
		ArraysUtil.display(rotateArrayByNElementUsingSpace(arr, 3));
		int n = -5;
		ArraysUtil.display(rotateArrayByNElement(new int[] {1,10,20,0,59,86,32,11,9,40}, n));
		//ArraysUtil.display(rotateArrayByNElementUsingSpace(new int[] {1,10,20,0,59,86,32,11,9,40}, n));
		int[] arr1 =  {1,2,3,4,5};
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<arr1.length; i++) {
			list.add(arr1[i]);
		}
		rotateArrayByNElementUsingSpace(list, n);
		
		List<Integer> nums = Arrays.asList(1,2,3,4,5);
		rotateArray(nums, 2);
	}

	public static int[] rotateRightArrayByOne(int[] arr) {
		int temp = arr[arr.length-1];
		for(int i = arr.length-1; i>0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
		return arr;
	}
	
	public static int[] rotateLeftArrayByOne(int[] arr) {
		int temp = arr[0];
		int i=0;
		for(i=0; i<arr.length-1; i++) {
			arr[i] =arr[i+1];
		}
		arr[i] = temp;
		return arr;
	}
	
	public static int[] rotateArrayByNElement(int arr[], int n) {
		if(n<0) {
			for(int i=1; i<=Math.abs(n); i++) {
				rotateLeftArrayByOne(arr);
			}
		} else {
			for(int i=1; i<=n; i++) {
				rotateRightArrayByOne(arr);
			}
		}

		return arr;
	}
	public static int[] rotateArrayByNElementUsingSpace(int arr[], int n) {
		n = n%arr.length;
		if(n==0) {
			return arr;
		}
		int temp[] = new int[n];
		int count = 0;
		for(int i=arr.length-n; i<arr.length; i++) {
			temp[count++] = arr[i];
		}
		count = arr.length-1-n;
		for(int i=arr.length-1; i>0 && count >=0; i--) {
			arr[i] = arr[count--];
		}
		for(int i=0; i<temp.length; i++) {
			arr[i] = temp[i];
		}
		return arr;
	}
	public static void rotateArrayByNElementUsingSpace(List<Integer> nums, int n) {
		n = n%nums.size();
		if(n > 0) {
			int temp[] = new int[n];
			int count = 0;
			for(int i=nums.size()-n; i<nums.size(); i++) {
				temp[count++] = nums.get(i);
			}
			count = nums.size()-1-n;
			for(int i=nums.size()-1; i>0 && count >=0; i--) {
				nums.set(i, nums.get(count--));
			}
			for(int i=0; i<temp.length; i++) {
				nums.set(i, temp[i]);
			}
		} else {
			n = Math.abs(n);
			int temp[] = new int[n];
			int count=0;
			for(int i=0; i<temp.length; i++) {
				temp[i] = nums.get(i);
			}
			for(int i=n; i<nums.size(); i++) {
				nums.set(count++, nums.get(i));
			}
			for(int i=0; i<temp.length; i++) {
				nums.set(count++, temp[i]);
			}
		}
		
		System.out.println(nums);
	}
	
	static void reverseArray(List<Integer> nums, int start, int end) {
		while (start < end) {
			int temp = nums.get(start);
			nums.set(start, nums.get(end));
			nums.set(end, temp);
			++start;
			--end;
		}
	}

	static void rotateArray(List<Integer> nums, int n) {
		System.out.println(nums);
		int len = nums.size();
		// Normalizing the 'n' rotations
		n = n % len;
		if (n < 0) {
			n = n + len;
		}

		// Let's partition the numsay based on rotations 'n'
		reverseArray(nums, 0, len - 1);
		reverseArray(nums, 0, n - 1);
		reverseArray(nums, n, len - 1);
		
		System.out.println(nums);
	}
	
}
