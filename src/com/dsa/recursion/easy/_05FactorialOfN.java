package com.dsa.recursion.easy;

public class _05FactorialOfN {
    public static void main(String args[]) {
        System.out.println(factorialOfNUsingRecursion(5));
    }

    public static int factorialOfNWithoutRecursion(int n) {
        int factorial=1;
        for(int i=n; i>0; i--) {
            factorial = i*factorial;
        }
        return factorial;
    }

    public static int factorialOfNUsingRecursion(int n) {
        if(n==1) {
            return n;
        } 
        return n*factorialOfNUsingRecursion(n-1);
    }
}
