package com.dsa.maths.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _05PrintAllDivision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printAllDivisionApproach3(36);
	}
	
	// Iterate all and using mod operation for outuput
	// TIme complexity O(n)
	public static void printAllDivisionApproach1(int n) {
		for(int i=1; i<=n; i++) {
			if(n%i==0) System.out.println(i);
		}
	}
	
	// Iterate half of the value and using mathematical calculation achieve same output
	// TIme complexity O(sqrt(n))
	public static void printAllDivisionApproach2(int n) {
		for(int i=1; i*i<=n;/*i<=Math.sqrt(n);*/ i++) {
			if(n%i==0) {
				System.out.println(i);
				if((n/i)!=i) {
					System.out.println(n/i);
				}
			}
		}
	}
	
	// Above approach will not have sorted order so using collections DS we can store and sort the value
	// TIme complexity O(n log n)
	public static void printAllDivisionApproach3(int n) {
		List<Integer> list = new ArrayList<>();
		// O(sqrt(n))
		for(int i=1; i*i<=n;/*i<=Math.sqrt(n);*/ i++) {
			if(n%i==0) {
				list.add(i);
				if((n/i)!=i) {
					list.add(n/i);
				}
			}
		}
		//O(n log n)
		Collections.sort(list);
		System.out.println(list);
	}
}
