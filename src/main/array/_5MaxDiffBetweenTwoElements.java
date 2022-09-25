package main.array;

public class _5MaxDiffBetweenTwoElements {

	public static void main(String[] args) {
		int arr[] = {4,3,10,2,11,1,6,12};
		maxDiffBetweenTwoElements(arr);
	}
	public static int maxDiffBetweenTwoElements(int arr[]) {
		int min=arr[0], maxDiff = Integer.MIN_VALUE, diff;
		for(int i=1; i<arr.length; i++) {
			diff = arr[i]-min;
			if(diff>maxDiff) {
				maxDiff = diff;
			}
			if(arr[i]<min) {
				min = arr[i];
			}
		}
		return maxDiff;
	}
	
	public static int maxDiffBetweenTwoElements2(int arr[]) {
		int minSoFar=arr[0], maxDiff = Integer.MIN_VALUE, diff;
		for(int i=1; i<arr.length; i++) {
			if(arr[i] < minSoFar) {
				minSoFar = arr[i];
			} else {
				diff = arr[i]-minSoFar;
				if(diff>maxDiff) {
					maxDiff = diff;
				}
			}
		}
		return maxDiff;
	}
}