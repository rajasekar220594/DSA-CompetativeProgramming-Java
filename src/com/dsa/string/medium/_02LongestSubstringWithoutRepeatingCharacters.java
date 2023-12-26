package com.dsa.string.medium;

import java.util.HashSet;
import java.util.Set;

public class _02LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(longestSubstringWithoutRepeatingCharactersApproach2("abcabcbb"));
		System.out.println(longestSubstringWithoutRepeatingCharactersApproach2("bbbb"));
		System.out.println(longestSubstringWithoutRepeatingCharactersApproach2("pwwkew"));
		System.out.println(longestSubstringWithoutRepeatingCharactersApproach2(" "));
		System.out.println(longestSubstringWithoutRepeatingCharactersApproach2("au"));
	}
	
	public static int longestSubstringWithoutRepeatingCharactersApproach1(String s) {
		//String longestSubstring = "";
		if(s.isEmpty()) return 0;
		if(s.length()==1) return 1;
		int length=0;
		for(int i=0; i<s.length(); i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(String.valueOf(s.charAt(i)));
			for(int j=i+1; j<s.length(); j++) {
				if(sb.toString().contains(String.valueOf(s.charAt(j)))) {
					break;
				} else {
					sb.append(String.valueOf(s.charAt(j)));
				}
			}
			if(length < sb.length()) {
				length = sb.length();
			}
		}
		
		return length;
	}
	
	public static int longestSubstringWithoutRepeatingCharactersApproach2(String s) {
		int l=0,r=0,length=0;
		
		if(s.isEmpty()) return 0;
		if(s.length()==1) return 1;
		
		Set<Character> set = new HashSet<>();
		for(; r<s.length(); r++) {
			if(!set.add(s.charAt(r))) {
				if((r-l)>length) {
					length = r-l;
				}
				for(;l<=r;l++) {
					if(s.charAt(r) != s.charAt(l)) {
						set.remove(s.charAt(l));
					} else {
						l++;
						break;
					}
					
				}
			}
		}
		if((r-l)>length) {
			length = r-l;
		}
		return length;
	}

}
