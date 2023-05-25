package org.example.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibonacciOfNumber(n));
    }

    public static int fibonacciOfNumber(int n){
        if(n == 0 || n == 1) return n;
        return fibonacciOfNumber(n-1) + fibonacciOfNumber(n-2);
    }
}
