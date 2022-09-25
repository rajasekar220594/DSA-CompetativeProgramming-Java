package main.array;

/** Given an sorted array A of size n, find an element that occurs more than n/2 times*/
public class _4MajorityElement {
	public static void main(String[] args) {
		int arr[] = {1,1,2,3,4,1,1,1,5};
		System.out.println(moreVotingAlgo(arr));
	}
	public static int findMajorityElement(int arr[]) {
		int n = (arr.length/2)+1;
		for(int i=0; i<arr.length; i++) {
			int temp = i+(n-1);
			if(temp < arr.length && arr[i] == arr[temp]) {
				return arr[i];
			}
		}
		return -1;
	}
	
	public static int moreVotingAlgo(int arr[]) {
		int majorityElement = arr[0], count =1;
		for(int i=1; i<arr.length; i++) {
			if(count == 0) {
				majorityElement = arr[i];
			}
			if(arr[i] == majorityElement) {
				count++;
			} else {
				count--;
			}
		}
		
		int n = (arr.length/2)+1;
		count=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == majorityElement) {
				count++;
			}
			if(count>=n) {
				return majorityElement;
			}
		}
		if(count>=n) {
			return majorityElement;
		}
		return -1;
	}
}
