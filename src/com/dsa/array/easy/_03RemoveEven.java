package com.dsa.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.dsa.array.util.ArraysUtil;

public class _03RemoveEven {

	public static void main(String[] args) {
		int arr[] = {1, 2, 4, 5, 10, 6, 3};
		//ArraysUtil.display(removeEvenUsingTwoLoop(arr));
		ArraysUtil.display(removeEvenUsingJava8(arr));
		ArraysUtil.display(removeEvenUsingCollections(arr));
	}
	
	public static int[] removeEvenUsingTwoLoop(int arr[]) {
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]%2!=0) {
				count++;
			}
		}
		int newArray[] = new int[count];
		count = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]%2!=0) {
				newArray[count++] = arr[i];
			}
		}
		return newArray;
	}
	
	public static int[] removeEvenUsingJava8(int arr[]) {
		return Arrays.stream(arr).filter(i -> i%2!=0).toArray();
	}
	
	public static int[] removeEvenUsingCollections(int arr[]) {
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]%2!=0) {
				list.add(arr[i]);
			}
		}
		
		// Convert List to Integer[]
		Object[] objArray = {21, 58, 69, 33, 65};
		int length = objArray.length;
		Integer[] intArray = Arrays.copyOf(list.toArray(), list.size(), Integer[].class);
		
		//Convert list to int[]
		int[] example1 = list.stream().mapToInt(i->i).toArray();
		// OR
		int[] example2 = list.stream().mapToInt(Integer::intValue).toArray();

		return example2;
	}
}
