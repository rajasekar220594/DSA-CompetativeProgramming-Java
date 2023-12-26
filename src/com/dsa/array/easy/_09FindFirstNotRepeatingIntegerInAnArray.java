package com.dsa.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _09FindFirstNotRepeatingIntegerInAnArray {

	public static void main(String[] args) {
		int[] arr = {9, 2, 3, 2, 6, 6};
		System.out.println(findFirstUnique(arr));
		System.out.println(findFirstUniqueJava8(arr));
	}
	
	public static int findFirstUnique(int[] arr) {
		int result = 0;
		Map<Integer, Integer> hash = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			if(hash.containsKey(arr[i])) {
				hash.put(arr[i], hash.get(arr[i])+1);
			} else {
				hash.put(arr[i], 1);
			}
		}
		for(int i=0; i<arr.length; i++) {
			if(hash.containsKey(arr[i]) && hash.get(arr[i]) == 1) {
				return arr[i];
			}
		}
		return result;
	}
	
	public static int findFirstUniqueJava8(int[] arr) {
		Map<Integer, Long> map = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		Optional<Integer> result = map.entrySet().stream().filter(i->i.getValue()==1L).map(i->i.getKey()).findFirst();
		return result.get();
	}
}
