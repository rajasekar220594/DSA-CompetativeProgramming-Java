package com.dsa.array.easy;

import java.util.Arrays;
import com.dsa.array.util.ArraysUtil;

public class _03RemoveEven {

	public static void main(String[] args) {
		int arr[] = {1, 2, 4, 5, 10, 6, 3};
		//ArraysUtil.display(removeEvenUsingTwoLoop(arr));
		ArraysUtil.display(removeEvenUsingJava8(arr));
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

}
