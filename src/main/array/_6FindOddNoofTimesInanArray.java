package main.array;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class _6FindOddNoofTimesInanArray {
	public static void main(String[] args) {
		int arr[] = {3,2,1,2,3,1,1};
		System.out.println(getOddOccurrenceUsingXOR(arr));
	}
	
	public static int oddNoOfTimesInAnArray(int arr[]) {
		Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for(int i=0; i<arr.length; i++) {
			if(hash.containsKey(arr[i])) {
				hash.remove(arr[i]);
			} else {
				hash.put(arr[i], null);
			}
		}
		Set<Integer> s = hash.keySet();
		System.out.println(s);
		for(Integer d : s) {
			System.out.println(d);
		}
		System.out.println(hash);
		return -1;
	}
	
	public static int getOddOccurrenceUsingXOR(int arr[])
	{
		int res = 0;
		for (int i = 0; i < arr.length; i++)
		{
			res = res ^ arr[i];
		}
		return res;
	}
}
