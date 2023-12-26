package com.dsa.string.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _01UniqueEmailAddress {

	public static void main(String[] args) {
		String str = "Test";
		
		String arr[] = str.split("");
		
		String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		System.out.println(numUniqueEmails(emails));
	}
	public static int numUniqueEmails(String[] emails) {
        String split[];
        String local;
        Map<String, Integer> hash = new HashMap<>();
        for(String email : emails) {
            split = email.split("@");
            local = split[0];
            local = local.split("\\+")[0];
            local = local.replaceAll("\\.", "");
            hash.put(local+"@"+split[1], null);
        }
        return hash.size();
    }
}
