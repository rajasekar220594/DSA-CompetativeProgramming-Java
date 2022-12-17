package com.dsa.string.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class _01GroupAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"a"};
		
		String s = "baat";
		
		char[] ca = new char[26];
        for (char c : s.toCharArray()) ca[c - 'a']++;
        String keyStr = String.valueOf(ca);
        
		char[] frequencyArr = new char[26];
        for(int i = 0;i<s.length();i++){
        	System.out.println(s.charAt(i) - 'a');
            frequencyArr[s.charAt(i) - 'a']++;
        }
        //6 ms use char(0~127) array and new String(frequencyArr) method.
        //17ms when use byte (-128 to 127) array and Arrays.toString(frequencyArr) method
        //29ms when use int(-2,147,483,648 to 2,147,483,647) and Arrays.toString(frequencyArr) method
        String key = new String(frequencyArr);
        System.out.println(key);
		System.out.println(groupAnagrams(strs));
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		String temp;
		Map<String, List<String>> hash = new HashMap<>();
		List<String> list;
		for(int i=0; i<strs.length; i++) {
			char[] ch = strs[i].toCharArray();
			Arrays.sort(ch);
			temp = String.valueOf(ch);
			if(hash.containsKey(temp)) {
				list = hash.get(temp);
				list.add(strs[i]);
			} else {
				list = new ArrayList<String>();
				list.add(strs[i]);
				hash.put(temp, list);
			}
		}
		List<List<String>> groupList = new ArrayList<>();
		for(List<String> value :hash.values()) {
			groupList.add(value);
		}
		return groupList;
	}

}
